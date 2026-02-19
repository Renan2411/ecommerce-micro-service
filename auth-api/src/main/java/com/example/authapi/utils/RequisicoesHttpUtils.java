package com.example.authapi.utils;

import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RequisicoesHttpUtils {

    private final OkHttpClient okHttpClient;

    @Autowired
    private JsonUtils jsonUtils;

    public RequisicoesHttpUtils() {
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public Response realizarRequisicao(Request request) throws IOException {
        return okHttpClient.newCall(request).execute();
    }

    public void handleResponseStatusError(Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new IOException("Erro HTTP " + response.code());
        }
    }

    public <T> T converterResposta(Response response, Class<T> convetableClass) {
        if (Objects.isNull(response.body())) {
            return null;
        }

        try {
            return jsonUtils.converterJson(response.body().string(), convetableClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

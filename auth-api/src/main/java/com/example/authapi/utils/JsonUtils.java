package com.example.authapi.utils;

import com.example.authapi.exceptions.ConvercaoJsonException;
import lombok.AllArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JsonUtils {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T converterJson(String json, Class<T> convetableClass) {
        try {
            return objectMapper.readValue(json, convetableClass);
        } catch (IOException e) {
            throw new ConvercaoJsonException(String.format("Erro ao converter JSON: [%s]", e.getMessage()));
        }
    }

}

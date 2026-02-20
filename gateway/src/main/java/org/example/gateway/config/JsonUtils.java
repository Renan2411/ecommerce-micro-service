package org.example.gateway.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.gateway.exceptions.ConvercaoJsonException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JsonUtils {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T fromJson(String json, Class<T> convetableClass) {
        try {
            return objectMapper.readValue(json, convetableClass);
        } catch (IOException e) {
            throw new ConvercaoJsonException(String.format("Erro ao converter JSON para objeto. Erro: [%s]", e.getMessage()));
        }
    }

    public <T> String toJson(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ConvercaoJsonException(String.format("Erro ao converter objeto para JSON. Erro: [%s]", e.getMessage()));
        }
    }

}

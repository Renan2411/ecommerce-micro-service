package org.example.gateway.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.gateway.exceptions.ConvercaoJsonException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

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

    public <T> List<T> fromJsonList(String json, Class<T> elementClass) {
        try {
            JavaType listType = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, elementClass);
            return objectMapper.readValue(json, listType);
        } catch (IOException e) {
            throw new ConvercaoJsonException(String.format("Erro ao converter JSON para lista. Erro: [%s]", e.getMessage()));
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

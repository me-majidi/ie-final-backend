package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JsonMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object value) {
        try {
            return JsonMapper.objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static Object parseRequestBody(Class model, HttpServletRequest request) {
        try {
            return new ObjectMapper().readValue(request.getInputStream(), model);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "...";
        }
    }
}

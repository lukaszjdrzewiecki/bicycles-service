package com.workshop.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.ArrayList;

@UtilityClass
public class SerializationUtils {

    private static ObjectMapper objectMapper;

    private static ObjectMapper getMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }


    public static <T> T deserializeEntity(String json, Class<T> tClass) throws IOException {
        return getMapper().readValue(json, tClass);
    }

    public static <T> ArrayList<T> deserializeListOfEntities(String json, Class<T> tClass) throws IOException {
        TypeFactory typeFactory = getMapper().getTypeFactory();
        JavaType type = typeFactory.constructCollectionType(ArrayList.class, tClass);
        return getMapper().readValue(json, type);
    }

    public static String toJson(Object object) throws IOException {
        return getMapper().writeValueAsString(object);
    }
}

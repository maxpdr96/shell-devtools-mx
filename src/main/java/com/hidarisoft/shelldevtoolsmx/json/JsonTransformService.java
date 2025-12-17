package com.hidarisoft.shelldevtoolsmx.json;

import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class JsonTransformService {
    private final ObjectMapper objectMapper;

    public JsonTransformService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toJavaString(String json) {
        Object obj = objectMapper.readValue(json, Object.class);
        String oneLine = objectMapper.writeValueAsString(obj);
        return escapeJava(oneLine);
    }

    public String fromJavaString(String javaString) {
        String unescaped = unescapeJava(javaString);
        Object obj = objectMapper.readValue(unescaped, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(obj);
    }

    private String escapeJava(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private String unescapeJava(String s) {
        return s.replace("\\\"", "\"").replace("\\\\", "\\");
    }
}
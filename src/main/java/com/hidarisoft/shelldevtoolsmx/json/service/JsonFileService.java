package com.hidarisoft.shelldevtoolsmx.json.service;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Service
public class JsonFileService {

    private final JsonTransformService transformService;

    public JsonFileService(JsonTransformService transformService) {
        this.transformService = transformService;
    }

    public Path toJava(Path inputFile) throws Exception {
        String json = Files.readString(inputFile);

        String result = transformService.toJavaString(json);
        System.out.println(result);
        Path outputFile = inputFile
                .getParent()
                .resolve("result-" + LocalDateTime.now() + ".json");

        Files.writeString(outputFile, result);

        return outputFile;
    }

    public Path fromJava(Path inputFile) throws Exception {
        String value = Files.readString(inputFile);

        String result = transformService.fromJavaString(value);
        System.out.println(result);
        Path outputFile = inputFile
                .getParent()
                .resolve("result-" + LocalDateTime.now() + ".json");

        Files.writeString(outputFile, result);

        return outputFile;
    }
}

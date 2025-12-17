package com.hidarisoft.shelldevtoolsmx.json;

import com.hidarisoft.shelldevtoolsmx.json.service.JsonFileService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.nio.file.Path;
import java.nio.file.Paths;

@ShellComponent
public class JsonCommands {

    private final JsonFileService service;

    public JsonCommands(JsonFileService service) {
        this.service = service;
    }

    @ShellMethod(key = "json-str", value = "Converts JSON to an escaped Java string")
    public String toJava(@ShellOption String file) throws Exception {
        Path path = Paths.get(file).toAbsolutePath();
        Path out = service.toJava(path);

        return "Generated file: " + out.toAbsolutePath();
    }

    @ShellMethod(key = "str-json", value = "Converts a Java string to JSON")
    public String fromJava(@ShellOption String file) throws Exception {
        Path path = Paths.get(file).toAbsolutePath();
        Path out = service.fromJava(path);
        return "Generated file:" + out.toAbsolutePath();
    }
}
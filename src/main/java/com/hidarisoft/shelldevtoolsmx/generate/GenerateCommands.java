package com.hidarisoft.shelldevtoolsmx.generate;

import com.hidarisoft.shelldevtoolsmx.generate.service.CpfGeneratorService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ShellComponent
public class GenerateCommands {

    private final CpfGeneratorService cpfGeneratorService;

    public GenerateCommands(CpfGeneratorService cpfGeneratorService) {
        this.cpfGeneratorService = cpfGeneratorService;
    }

    @ShellMethod(key = "gen cpf", value = "Generate CPF")
    public String generateCpf(@ShellOption(defaultValue = "1") int quantity) {
        return String.join("\n", cpfGeneratorService.generateListCpf(quantity));
    }

    @ShellMethod(key = "gen uuid", value = "Generate UUIDs")
    public String generateUUID(@ShellOption(defaultValue = "1") int quantity) {

        if (quantity == 1) {
            return UUID.randomUUID().toString();
        }

        List<String> listUUIDs = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            listUUIDs.add(UUID.randomUUID().toString());
        }

        return String.join("\n", listUUIDs);
    }
}

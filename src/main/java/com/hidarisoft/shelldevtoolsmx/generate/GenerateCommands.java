package com.hidarisoft.shelldevtoolsmx.generate;

import com.hidarisoft.shelldevtoolsmx.generate.service.CpfGeneratorService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

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
}

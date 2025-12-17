package com.hidarisoft.shelldevtoolsmx.generate.service;

import com.hidarisoft.shelldevtoolsmx.generate.utils.CpfGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CpfGeneratorService {

    public String generateCpf() {
        return CpfGenerator.generate();
    }

    public List<String> generateListCpf(int quantity) {
        List<String> CPFLists = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            CPFLists.add(generateCpf());
        }
        return CPFLists;
    }
}

package com.hidarisoft.shelldevtoolsmx.generate.utils;

import java.util.Random;

public class CpfGenerator {

    private static final Random RANDOM = new Random();

    public static String generate() {
        int[] cpf = new int[11];

        // Gera os 9 primeiros dígitos aleatórios
        for (int i = 0; i < 9; i++) {
            cpf[i] = RANDOM.nextInt(10);
        }

        // Calcula o primeiro dígito verificador
        cpf[9] = calculateDigit(cpf, 9);

        // Calcula o segundo dígito verificador
        cpf[10] = calculateDigit(cpf, 10);

        // Converte para String
        StringBuilder sb = new StringBuilder();
        for (int digit : cpf) {
            sb.append(digit);
        }

        return sb.toString();
    }

    private static int calculateDigit(int[] cpf, int length) {
        int sum = 0;
        int weight = length + 1;

        for (int i = 0; i < length; i++) {
            sum += cpf[i] * weight--;
        }

        int remainder = (sum * 10) % 11;
        return (remainder == 10) ? 0 : remainder;
    }

    public static void main(String[] args) {
        System.out.println(generate());
    }
}

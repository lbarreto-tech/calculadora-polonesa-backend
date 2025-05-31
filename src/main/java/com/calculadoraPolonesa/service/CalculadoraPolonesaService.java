package com.calculadoraPolonesa.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class CalculadoraPolonesaService {

     public double calculadoraPolonesaService(String expression) {
        String[] tokens = expression.trim().split("\\s+");
        LinkedList<Double> stack = new LinkedList<>();
        Double soma = 0.0;

        int c = 0;
        for (String token : tokens) {
            c++;
            switch (token) {
                case "+" -> {
                    for(int i = 1; i < c; i++){
                         soma += stack.pop();
                    }
                    stack.push(soma);
                    c = 0;
                }
                case "-" -> {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Double.parseDouble(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expressão inválida.");
        }

        return stack.pop();
    }

}

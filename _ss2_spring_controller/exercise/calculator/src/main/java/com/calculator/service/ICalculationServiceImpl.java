package com.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class ICalculationServiceImpl implements ICalculationService{

    @Override
    public double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator){
            case "Addition":
                return firstNumber + secondNumber;
            case "Subtraction":
                return firstNumber - secondNumber;
            case "Multiplication":
                return firstNumber * secondNumber;
            case "Division":
                return firstNumber / secondNumber;
        }
        return 0;
    }
}

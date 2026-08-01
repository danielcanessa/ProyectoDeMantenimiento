package com.pswe03.patrones;

import java.util.Map;

interface OperationStrategy {
    int calculate(int a, int b);
}

class AdditionStrategy implements OperationStrategy {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class SubtractionStrategy implements OperationStrategy {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

class MultiplicationStrategy implements OperationStrategy {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}

class DivisionStrategy implements OperationStrategy {
    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}

class Calculator {
    private final Map<String, OperationStrategy> strategies = Map.of(
            "sum", new AdditionStrategy(),
            "sub", new SubtractionStrategy(),
            "mul", new MultiplicationStrategy(),
            "div", new DivisionStrategy());

    public int calculate(String operation, int a, int b) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation must not be null");
        }

        OperationStrategy strategy = strategies.get(operation);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

        return strategy.calculate(a, b);
    }
}

package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Example1_IfElseCalculatorTest {

    private final Calculator calculator = new Calculator();

    static Stream<Arguments> supportedOperations() {
        return Stream.of(
                Arguments.of("sum", 5, 3, 8),
                Arguments.of("sub", 5, 3, 2),
                Arguments.of("mul", 5, 3, 15),
                Arguments.of("div", 6, 3, 2));
    }

    @ParameterizedTest(name = "{0} de {1} y {2} produce {3}")
    @MethodSource("supportedOperations")
    void calculatesSupportedOperations(String operation, int first, int second, int expected) {
        assertEquals(expected, calculator.calculate(operation, first, second));
    }

    @Test
    void returnsZeroForUnknownOrNullOperation() {
        assertEquals(0, calculator.calculate("avg", 6, 3));
        assertEquals(0, calculator.calculate(null, 6, 3));
    }
}

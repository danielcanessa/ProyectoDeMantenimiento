package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example5_TemplateMethodLikeTest {

    private final PrintStream originalOutput = System.out;
    private ByteArrayOutputStream capturedOutput;

    @BeforeEach
    void captureOutput() {
        capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOutput);
    }

    @Test
    void originalBeverageExecutesStepsInOrder() {
        Beverage beverage = new Beverage();

        beverage.prepare();

        assertEquals(expectedOutput(
                "Boiling water",
                "Brewing beverage",
                "Pouring in cup",
                "Adding extras"), output());
    }

    @Test
    void templateAllowsSpecializingVariableSteps() {
        BeverageTemplate tea = new BeverageTemplate() {
            @Override
            protected void brew() {
                System.out.println("Steeping tea");
            }

            @Override
            protected void addExtras() {
                System.out.println("Adding lemon");
            }
        };

        tea.prepare();

        assertEquals(expectedOutput(
                "Boiling water",
                "Steeping tea",
                "Pouring in cup",
                "Adding lemon"), output());
    }

    private String output() {
        return capturedOutput.toString(StandardCharsets.UTF_8);
    }

    private String expectedOutput(String... lines) {
        return String.join(System.lineSeparator(), lines) + System.lineSeparator();
    }
}

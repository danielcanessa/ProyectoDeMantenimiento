package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example5_TemplateMethodLikeTest {

    private final Beverage beverage = new Beverage();
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
    void prepareExecutesStepsInOrder() {
        beverage.prepare();

        String expected = String.join(
                System.lineSeparator(),
                "Boiling water",
                "Brewing beverage",
                "Pouring in cup",
                "Adding extras") + System.lineSeparator();

        assertEquals(expected, capturedOutput.toString(StandardCharsets.UTF_8));
    }
}

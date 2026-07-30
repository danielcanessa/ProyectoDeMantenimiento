package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example2_RepeatedFunctionalityLoggerTest {

    private final Service service = new Service();
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
    void processLogsStartAndEndMessages() {
        service.process();

        assertEquals(expectedOutput("Start process", "End process"), output());
    }

    @Test
    void validateLogsStartAndEndMessages() {
        service.validate();

        assertEquals(expectedOutput("Start validate", "End validate"), output());
    }

    private String output() {
        return capturedOutput.toString(StandardCharsets.UTF_8);
    }

    private String expectedOutput(String... lines) {
        return String.join(System.lineSeparator(), lines) + System.lineSeparator();
    }
}

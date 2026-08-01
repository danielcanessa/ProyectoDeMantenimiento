package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example2_RepeatedFunctionalityLoggerTest {

    private final PrintStream originalOutput = System.out;
    private ByteArrayOutputStream capturedOutput;
    private TrackingService basicService;
    private Service service;

    @BeforeEach
    void captureOutput() {
        basicService = new TrackingService();
        service = new LoggingServiceDecorator(basicService);
        capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOutput);
    }

    @Test
    void processDelegatesAndLogsStartAndEndMessages() {
        service.process();

        assertEquals(1, basicService.processCalls);
        assertEquals(expectedOutput("Start process", "End process"), output());
    }

    @Test
    void validateDelegatesAndLogsStartAndEndMessages() {
        service.validate();

        assertEquals(1, basicService.validationCalls);
        assertEquals(expectedOutput("Start validate", "End validate"), output());
    }

    private String output() {
        return capturedOutput.toString(StandardCharsets.UTF_8);
    }

    private String expectedOutput(String... lines) {
        return String.join(System.lineSeparator(), lines) + System.lineSeparator();
    }

    private static class TrackingService implements Service {
        private int processCalls;
        private int validationCalls;

        @Override
        public void process() {
            processCalls++;
        }

        @Override
        public void validate() {
            validationCalls++;
        }
    }
}

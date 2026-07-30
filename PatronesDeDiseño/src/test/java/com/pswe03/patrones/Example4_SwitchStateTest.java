package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Example4_SwitchStateTest {

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
    void opensOnlyWhenConnectionIsClosed() {
        TCPConnection connection = new TCPConnection();
        connection.setState("CLOSED");

        connection.open();

        assertEquals("Opening connection..." + System.lineSeparator(), output());
    }

    @Test
    void closesOnlyWhenConnectionIsOpen() {
        TCPConnection connection = new TCPConnection();
        connection.setState("OPEN");

        connection.close();

        assertEquals("Closing connection..." + System.lineSeparator(), output());
    }

    @Test
    void ignoresInvalidTransitions() {
        TCPConnection connection = new TCPConnection();

        connection.setState("OPEN");
        connection.open();
        connection.setState("CLOSED");
        connection.close();

        assertEquals("", output());
    }

    private String output() {
        return capturedOutput.toString(StandardCharsets.UTF_8);
    }
}

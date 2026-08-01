package com.pswe03.patrones;

interface ConnectionState {
    default void open(TCPConnection connection) {
        // Invalid transition for this state.
    }

    default void close(TCPConnection connection) {
        // Invalid transition for this state.
    }
}

class ClosedState implements ConnectionState {
    @Override
    public void open(TCPConnection connection) {
        System.out.println("Opening connection...");
        connection.changeState(new OpenState());
    }
}

class OpenState implements ConnectionState {
    @Override
    public void close(TCPConnection connection) {
        System.out.println("Closing connection...");
        connection.changeState(new ClosedState());
    }
}

class UnknownState implements ConnectionState {
}

class TCPConnection {
    private ConnectionState state = new UnknownState();

    // Se conserva para mantener compatibilidad con la API anterior basada en strings.
    public void setState(String stateName) {
        if ("CLOSED".equals(stateName)) {
            changeState(new ClosedState());
        } else if ("OPEN".equals(stateName)) {
            changeState(new OpenState());
        } else {
            changeState(new UnknownState());
        }
    }

    public void open() {
        state.open(this);
    }

    public void close() {
        state.close(this);
    }

    void changeState(ConnectionState state) {
        this.state = state;
    }
}

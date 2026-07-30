
public class TCPConnection {
    private String state;

    public void setState(String s) { state = s; }

    public void open() {
        if ("CLOSED".equals(state)) System.out.println("Opening connection...");
    }

    public void close() {
        if ("OPEN".equals(state)) System.out.println("Closing connection...");
    }
}


public class Calculator {
    public int calculate(String operation, int a, int b) {
        if ("sum".equals(operation)) {
            return a + b;
        } else if ("sub".equals(operation)) {
            return a - b;
        } else if ("mul".equals(operation)) {
            return a * b;
        } else if ("div".equals(operation)) {
            return a / b;
        }
        return 0;
    }
}

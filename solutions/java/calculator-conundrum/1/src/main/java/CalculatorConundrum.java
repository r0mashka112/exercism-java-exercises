import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.IntBinaryOperator;

class CalculatorConundrum {

    private final List<String> validOperations;
    private final Map<String, IntBinaryOperator> operations;

    public CalculatorConundrum() {
        this.validOperations = createValidOperationsList();
        this.operations = createOperationsMap();
    }

    private static List<String> createValidOperationsList() {
        return Arrays.asList("+", "*", "/");
    }

    private static Map<String, IntBinaryOperator> createOperationsMap() {
        Map<String, IntBinaryOperator> ops = new HashMap<>();

        ops.put("+", Integer::sum);
        ops.put("*", (a, b) -> a * b);
        ops.put("/", (a, b) -> a / b);

        return ops;
    }

    private String getResult(int operand1, int operand2, String operation) {
        try {
            int result = this.operations.get(operation).applyAsInt(operand1, operand2);

            return String.format("%d %s %d = %d", operand1, operation, operand2, result);
        } catch (ArithmeticException exception) {
            throw new IllegalOperationException("Division by zero is not allowed", exception);
        }
    }

    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        } else if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        } else if (!this.validOperations.contains(operation)) {
            throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }

        return getResult(operand1, operand2, operation);
    }
}

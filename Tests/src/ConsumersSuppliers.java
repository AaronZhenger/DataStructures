import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumersSuppliers {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        Consumer<String> altConsumer = (n) -> System.out.println(n);
    }
}

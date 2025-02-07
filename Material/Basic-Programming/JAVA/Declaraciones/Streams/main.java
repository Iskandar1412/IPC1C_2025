import java.util.List;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Cesar", "Pablo", "Marco", "Pedro", "Peter", "Jose", "Pancho");
        
        
        nombres.stream()
            .filter(nombre -> nombre.contains("a"))
            .forEach(System.out::println);
    }
}

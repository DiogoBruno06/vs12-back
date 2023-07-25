import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<String,String> capitalizarFrase = string -> string.toUpperCase();
        System.out.println(capitalizarFrase.apply("vem ser 12"));

        Function<List<Integer>, Integer> somarImpares = numeros -> {
            int soma = 0;
            for (int numero : numeros){
                if (numero % 2 != 0 ){
                    soma += numero;
                };
            }
            return soma;
        };
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(somarImpares.apply(numeros));
    }
}

public class Subtrair {
    public static void main(String[] args) {
        Calculo calcular = new Calculo() {
            @Override
            public int calcular(int n1, int n2) {
                return n1 - n2;
            }
        };
    }
}

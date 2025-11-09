public class Numero {
    public static void dividir(int a, int b) {
        try {
            int resultado = a / b;
            System.out.println(a + " / " + b + " = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Nao eh possivel dividir por zero");
                      System.out.println(a + " / " + b + " = " + 0);
        }
    }
}
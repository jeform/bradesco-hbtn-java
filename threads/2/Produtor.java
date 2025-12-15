import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private Random random;

    public Produtor(Fila fila) {
        this.fila = fila;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Gera um número aleatório entre 1 e 100
                int numero = random.nextInt(100) + 1;

                // Adiciona o número à fila
                fila.adicionar(numero);

                // Aguarda 1 segundo antes de produzir o próximo item
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

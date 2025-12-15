public class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Retira um item da fila
                int item = fila.retirar();

                // Simula o processamento do item
                System.out.println("Consumidor processando: " + item);
                Thread.sleep(500);

                System.out.println("Consumidor consumiu: " + item);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

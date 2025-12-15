public class SistemaFilas {
    public static void main(String[] args) throws InterruptedException {
        // Cria uma fila com capacidade para 10 itens
        Fila fila = new Fila(10);

        // Cria 2 threads de produtores
        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);

        // Cria 2 threads de consumidores
        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        // Inicia as threads
        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();

        // Executa por 20 segundos
        Thread.sleep(20000);

        // Encerra o programa
        System.out.println("\nEncerrando o sistema...");
        System.exit(0);
    }
}

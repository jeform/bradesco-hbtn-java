import java.util.LinkedList;

public class Fila {
    private LinkedList<Integer> fila;
    private int capacidade;

    public Fila(int capacidade) {
        this.fila = new LinkedList<>();
        this.capacidade = capacidade;
    }

    // Método para adicionar um item à fila
    public synchronized void adicionar(int item) throws InterruptedException {
        // Espera enquanto a fila estiver cheia
        while (fila.size() == capacidade) {
            System.out.println("Fila cheia. Produtor aguardando...");
            wait();
        }

        // Adiciona o item à fila
        fila.add(item);
        System.out.println("Produtor adicionou: " + item + " (Tamanho da fila: " + fila.size() + ")");

        // Notifica todos os consumidores que há um novo item
        notifyAll();
    }

    // Método para retirar um item da fila
    public synchronized int retirar() throws InterruptedException {
        // Espera enquanto a fila estiver vazia
        while (fila.isEmpty()) {
            System.out.println("Fila vazia. Consumidor aguardando...");
            wait();
        }

        // Retira o item da fila
        int item = fila.removeFirst();
        System.out.println("Consumidor retirou: " + item + " (Tamanho da fila: " + fila.size() + ")");

        // Notifica todos os produtores que há espaço disponível
        notifyAll();

        return item;
    }
}

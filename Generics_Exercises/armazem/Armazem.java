import java.util.HashMap;
import java.util.Map;

public class Armazem<T> implements Armazenavel<T> {
    private Map<String, T> inventario;

    public Armazem() {
        this.inventario = new HashMap<>();
    }

    @Override
    public void adicionarAoInventario(String nome, T item) {
        inventario.put(nome, item);
    }

    @Override
    public T obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}

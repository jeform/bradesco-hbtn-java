public interface Armazenavel<T> {
    void adicionarAoInventario(String nome, T item);
    T obterDoInventario(String nome);
}

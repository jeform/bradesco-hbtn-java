public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
        this.identificador = identificador;
        this.estahFeita = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getEstahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setEstahFeita(boolean estahFeita) {
        this.estahFeita = estahFeita;
    }

    public void modificarDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
    }
}

public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setSaudeAtual(int saude) {
        this.saudeAtual = saude;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void tomarDano(int quantidadeDeDano) {
        saudeAtual -= quantidadeDeDano;
        if (saudeAtual < 0) {
            saudeAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        saudeAtual += quantidadeDeCura;
        if (saudeAtual > 100) {
            saudeAtual = 100;
        }
    }
}
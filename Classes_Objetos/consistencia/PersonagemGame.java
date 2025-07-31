public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeInicial, String nomeInicial) {
        setNome(nomeInicial);
        setSaudeAtual(saudeInicial);
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
        // Se nome for nulo ou vazio, mantém o nome atual
    }

    public String getNome() {
        return nome;
    }

    public void setSaudeAtual(int saude) {
        this.saudeAtual = saude;
        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public String getStatus() {
        return status;
    }

     public void tomarDano(int quantidadeDeDano) {
        int novaSaude = saudeAtual - quantidadeDeDano;
        if (novaSaude < 0) {
            novaSaude = 0;
        }
        setSaudeAtual(novaSaude);
    }

    public void receberCura(int quantidadeDeCura) {
        int novaSaude = saudeAtual + quantidadeDeCura;
        if (novaSaude > 100) {
            novaSaude = 100;
        }
        setSaudeAtual(novaSaude);
    }
}
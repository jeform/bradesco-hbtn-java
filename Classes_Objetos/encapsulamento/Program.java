public class Program {
    public static void main(String[] args) {
        PersonagemGame personagem1 = new PersonagemGame();
        
        personagem1.nome = "Sonic";
        personagem1.saudeAtual = 10;

        System.out.printf("Nome: %s - Saude: %d\n", personagem1.getNome(), personagem1.getSaudeAtual());
    }
}
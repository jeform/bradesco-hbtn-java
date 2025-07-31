public class Program {
    public static void main(String[] args) {
        PersonagemGame personagem1 = new PersonagemGame();
        PersonagemGame personagem2 = new PersonagemGame();

        personagem1.setNome("Sonic");
        personagem1.setSaudeAtual(10);

        personagem2.setNome("Mario");
        personagem2.setSaudeAtual(100);

        System.out.printf("Nome: %s - Saude: %d\n", personagem1.getNome(), personagem1.getSaudeAtual());
        System.out.printf("Nome: %s - Saude: %d\n", personagem2.getNome(), personagem2.getSaudeAtual());

    }
}
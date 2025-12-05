import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
        System.out.println("Aluno " + nome + " adicionado com sucesso!");
    }

    public void excluirAluno(String nome) {
        boolean encontrado = false;
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().equals(nome)) {
                alunos.remove(i);
                System.out.println("Aluno " + nome + " excluído com sucesso!");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno " + nome + " não encontrado.");
        }
    }

    public void buscarAluno(String nome) {
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno " + nome + " não encontrado.");
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos cadastrados:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adicionando alunos
        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Maria", 22);
        gestao.adicionarAluno("Pedro", 19);

        System.out.println();

        // Listando todos os alunos
        gestao.listarAlunos();

        System.out.println();

        // Buscando um aluno
        gestao.buscarAluno("Maria");

        System.out.println();

        // Excluindo um aluno
        gestao.excluirAluno("Pedro");

        System.out.println();

        // Listando após exclusão
        gestao.listarAlunos();

        System.out.println();

        // Tentando excluir um aluno inexistente
        gestao.excluirAluno("Carlos");

        System.out.println();

        // Buscando outro aluno
        gestao.buscarAluno("João");
    }
}

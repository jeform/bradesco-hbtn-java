import java.util.ArrayList;
import java.util.List;
import atividades.Atividade;

public class Workflow {

    private List<Atividade> atividades = new ArrayList<>();

    public static void main(String[] args) {
        
    }

    public void registrarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

}

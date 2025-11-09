import atividades.*;

public class Program {

    public static void main(String[] args) {
        MaquinaWorkflow maquinaWorkflow = new MaquinaWorkflow();

        Workflow workflowEncodificarVideo = new Workflow();

        workflowEncodificarVideo.registrarAtividade(new CarregarVideo());
        workflowEncodificarVideo.registrarAtividade(new CodificarVideo());
        workflowEncodificarVideo.registrarAtividade(new EnviarEmail());

        maquinaWorkflow.executar(workflowEncodificarVideo);

        System.out.println("-----");

        Workflow workflowVideos = new Workflow();

        workflowVideos.registrarAtividade(new CarregarVideo());
        workflowVideos.registrarAtividade(new EnviarEmail());

        maquinaWorkflow.executar(workflowVideos);

        System.out.println("-----");

         Workflow workflowVideoStatus = new Workflow();

        workflowVideoStatus.registrarAtividade(new CarregarVideo());
        workflowVideoStatus.registrarAtividade(new ModificarStatusVideo());
        workflowVideoStatus.registrarAtividade(new EnviarEmail());

        maquinaWorkflow.executar(workflowVideoStatus);

    }
}
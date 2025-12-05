import java.util.ArrayList;

public class ProcessadorVideo {
    private ArrayList<CanalNotificacao> canais;

    public ProcessadorVideo() {
        this.canais = new ArrayList<>();
    }

    public void registrarCanal(CanalNotificacao canal) {
        canais.add(canal);
    }

    public void processar(Video video) {
        String textoMensagem = video.getArquivo() + " - " + video.getFormato();
        Mensagem mensagem = new Mensagem(textoMensagem, TipoMensagem.LOG);
        
        for (CanalNotificacao canal : canais) {
            canal.notificar(mensagem);
        }
    }
}

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProcessamentoDePagamentos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);


    public static void main(String[] args) {
        Random random = new Random();

        // Processa 5 pagamentos
        for (int i = 1; i <= 5; i++) {
            logger.info("Iniciando o processamento do pagamento {}", i);

            try {
                // Simula o tempo de processamento
                Thread.sleep(1000);

                // Simula aleatoriamente o estado do pagamento (0: sucesso, 1: falha, 2: pendente)
                int estado = random.nextInt(3);

                switch (estado) {
                    case 0:
                        logger.info("Pagamento {} processado com sucesso.", i);
                        break;
                    case 1:
                        logger.error("Erro ao processar o pagamento {}: Falha na transação.", i);
                        break;
                    case 2:
                        logger.warn("Pagamento {} está pendente. Aguardando confirmação.", i);
                        break;
                }

            } catch (InterruptedException e) {
                logger.error("Erro ao processar o pagamento {}: {}", i, e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        logger.info("Processamento de pagamentos concluído.");
    }
}

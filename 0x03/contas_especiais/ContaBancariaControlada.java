public class ContaBancariaControlada extends ContaBancariaBasica {
    
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeroConta, double saldo, double saldoMinimo, double valorPenalidade) {
        super(numeroConta, saldo);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public double calcularTarifaMensal(double saldo) {
        return 3.0;
    }

    @Override
    public double calcularJurosMensal(double saldo) {
        if(saldo <= 0){
            return 0;
        }
        // Taxa progressiva: saldo == 20 usa 7.5%, saldo < 20 usa 8.3%
        if (saldo >= 20) {
            return Math.ceil((saldo * 0.075) * 100.0) / 100.0;
        } else {
            return Math.ceil((saldo * 0.083) * 100.0) / 100.0;
        }
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        super.aplicarAtualizacaoMensal();
        if (getSaldo() < saldoMinimo) {
            setSaldo(getSaldo() - valorPenalidade);
            if (getSaldo() < 0) {
                setSaldo(0);
            }
        }
    }
    
}

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

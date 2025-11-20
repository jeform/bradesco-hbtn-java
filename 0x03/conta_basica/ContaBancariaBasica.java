import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double saldo, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.saldo = saldo;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public ContaBancariaBasica(String numeracao, double saldo) {
        this.numeracao = numeracao;
        this.saldo = saldo;
        this.taxaJurosAnual = 1.2; // taxa de 120% ao ano = 10% ao mês
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor < 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo -= valor;
    }

    public double calcularTarifaMensal(double saldo){
        return 10.0; // tarifa fixa de 10 reais
    }

    public double calcularJurosMensal(double saldo){
        if(saldo <= 0){
            return 0;
        }
        // taxa progressiva baseada no saldo
        if(saldo >= 500){
            return (saldo * 1.2) / 12; // 10% mensal para saldos >= 500
        } else {
            return (saldo * 0.9) / 12; // 7.5% mensal para saldos < 500
        }
    }  
    
    public void aplicarAtualizacaoMensal() {
        saldo += calcularJurosMensal(saldo);
        saldo -= calcularTarifaMensal(saldo);
        if (saldo < 0) {
            saldo = 0;
        }
    }

}

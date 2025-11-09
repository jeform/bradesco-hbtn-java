package provedores;

public class Loggi implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete;
        // peso está em gramas, converter para kg
        double pesoKg = peso / 1000.0;
        
        if (pesoKg > 5) {
            valorFrete = valor * 0.12; // 12%
        } else {
            valorFrete = valor * 0.04; // 4%
        }
        
        return new Frete(valorFrete, TipoProvedorFrete.LOGGI);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}

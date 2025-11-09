package provedores;

public class Sedex implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete;
        // peso está em gramas, converter para kg
        double pesoKg = peso / 1000.0;
        
        if (pesoKg > 1) {
            valorFrete = valor * 0.10; // 10%
        } else {
            valorFrete = valor * 0.05; // 5%
        }
        
        return new Frete(valorFrete, TipoProvedorFrete.SEDEX);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}

package provedores;

public class JadLog implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete;
        // peso está em gramas, converter para kg
        double pesoKg = peso / 1000.0;
        
        if (pesoKg > 2) {
            valorFrete = valor * 0.07; // 7%
        } else {
            valorFrete = valor * 0.045; // 4,5%
        }
        
        return new Frete(valorFrete, TipoProvedorFrete.JADLOG);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}

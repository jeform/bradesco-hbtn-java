


public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularValorItem();
        }
        total = total - (total * percentualDesconto / 100);

        return total;
    }

    public String apresentarResumoPedido() {

        StringBuilder resumo = new StringBuilder();
        resumo.append("------- RESUMO PEDIDO -------\n");
        for (ItemPedido item : itens) {
            resumo.append(String.format("Tipo: %s Titulo: %s Preco: %.2f Quant: %d Total: %.2f\n",
                    item.getProduto().getClass().getSimpleName(),
                    item.getProduto().getTitulo(),
                    item.getProduto().obterPrecoLiquido(),
                    item.getQuantidade(),
                    item.calcularValorItem()));
        }
        resumo.append("----------------------------\n");
        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            totalProdutos += item.calcularValorItem();
        }
        double valorDesconto = totalProdutos * percentualDesconto / 100;
        resumo.append(String.format("DESCONTO: %.2f\n", valorDesconto));
        resumo.append(String.format("TOTAL PRODUTOS: %.2f\n", totalProdutos));
        resumo.append("----------------------------\n");
        resumo.append("TOTAL PEDIDO: ").append(String.format("%.2f\n", calcularTotal()));
        resumo.append("----------------------------\n");
        System.out.print(resumo.toString());
        return resumo.toString();
    }
}

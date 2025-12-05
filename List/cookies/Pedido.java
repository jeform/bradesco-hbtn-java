import java.util.ArrayList;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedido : cookies) {
            total += pedido.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int totalRemovido = 0;
        
        for (int i = cookies.size() - 1; i >= 0; i--) {
            if (cookies.get(i).getSabor().equals(sabor)) {
                totalRemovido += cookies.get(i).getQuantidadeCaixas();
                cookies.remove(i);
            }
        }
        
        return totalRemovido;
    }
}

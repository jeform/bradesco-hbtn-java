import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private String arquivoEstoque;
    private List<Produto> produtos;

    public Estoque(String arquivoEstoque) {
        this.arquivoEstoque = arquivoEstoque;
        this.produtos = new ArrayList<>();
        carregarEstoque();
    }

    // Carrega o estoque do arquivo CSV
    private void carregarEstoque() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEstoque))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                int quantidade = Integer.parseInt(campos[2]);
                double preco = Double.parseDouble(campos[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Um novo arquivo será criado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque: " + e.getMessage());
        }
    }

    // Salva o estoque no arquivo CSV
    private void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEstoque))) {
            for (Produto produto : produtos) {
                writer.write(produto.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    // Gera um novo ID único
    private int gerarNovoId() {
        int maxId = 0;
        for (Produto produto : produtos) {
            if (produto.getId() > maxId) {
                maxId = produto.getId();
            }
        }
        return maxId + 1;
    }

    // Adiciona um novo produto ao estoque
    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
    }

    // Exclui um produto do estoque pelo ID
    public void excluirProduto(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
                salvarEstoque();
                break;
            }
        }
    }

    // Exibe todos os produtos no estoque
    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    // Atualiza a quantidade de um produto pelo ID
    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                salvarEstoque();
                break;
            }
        }
    }
}
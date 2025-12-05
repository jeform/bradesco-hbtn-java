import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        for (Post p : postagens) {
            if (p.equals(post)) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new LinkedHashMap<>();
        // Initialize with enum order
        for (Categorias cat : Categorias.values()) {
            contagem.put(cat, 0);
        }
        // Count posts
        for (Post post : postagens) {
            Categorias categoria = post.getCategoria();
            contagem.put(categoria, contagem.get(categoria) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getAutor().equals(autor)) {
                posts.add(post);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getCategoria() == categoria) {
                posts.add(post);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postsPorCategoria = new LinkedHashMap<>();
        // Initialize with enum order
        for (Categorias cat : Categorias.values()) {
            postsPorCategoria.put(cat, new TreeSet<>());
        }
        // Add posts
        for (Post post : postagens) {
            Categorias categoria = post.getCategoria();
            postsPorCategoria.get(categoria).add(post);
        }
        return postsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new TreeMap<>();
        for (Post post : postagens) {
            Autor autor = post.getAutor();
            if (!postsPorAutor.containsKey(autor)) {
                postsPorAutor.put(autor, new TreeSet<>());
            }
            postsPorAutor.get(autor).add(post);
        }
        return postsPorAutor;
    }
}

package catolica.com.br.projeto;


import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String id;
    private String email;
    private List<Livro> livrosEmPosse;
    private final int limiteLivros = 5;

    public Usuario(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosEmPosse = new ArrayList<>();
    }

    public boolean adicionarLivro(Livro livro) {
        if (livrosEmPosse.size() < limiteLivros) {
            livrosEmPosse.add(livro);
            return true;
        } else {
            System.out.println("Limite de livros atingido.");
            return false;
        }
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("E-mail: " + email);
        System.out.println("Livros em Posse: ");
        for (Livro livro : livrosEmPosse) {
            System.out.println("  - " + livro.getTitulo());
        }
    }
}
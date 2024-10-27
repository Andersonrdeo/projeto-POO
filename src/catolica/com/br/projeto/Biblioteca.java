package catolica.com.br.projeto;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private String endereco;
    private List<Livro> livrosDisponiveis;
    private int limiteLivros = 100;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livrosDisponiveis = new ArrayList<>();
    }
    public boolean verificarDisponibilidade(Livro livro) {
        return livrosDisponiveis.contains(livro) && livro.getQuantidadeEstoque() > 0;
    }


    public boolean cadastrarLivro(Livro livro) {
        if (livrosDisponiveis.size() < limiteLivros) {
            livrosDisponiveis.add(livro);
            return true;
        } else {
            System.out.println("Limite de livros da biblioteca atingido.");
            return false;
    }
    }

    public Livro localizarLivroPorTitulo(String titulo) {
        for (Livro livro : livrosDisponiveis) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    public List<Livro> localizarLivroPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
    public void devolver(Livro livro) {
        if (livrosDisponiveis.contains(livro)) {
            livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() + 1);
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
    }

    public void emprestar(Livro livro) {
        if (verificarDisponibilidade(livro)) {
            livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() - 1);
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro não disponível.");
        }
    }

    public void exibirInfo() {
        System.out.println("Nome da Biblioteca: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Livros Disponíveis: ");
        for (Livro livro : livrosDisponiveis) {
            livro.exibirInfo();
        }
    }
}
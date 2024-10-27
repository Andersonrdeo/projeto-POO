import catolica.com.br.projeto.Biblioteca;
import catolica.com.br.projeto.Livro;
import catolica.com.br.projeto.Usuario;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Biblioteca Católica", "Rua das Igrejas, 389");

        Livro livro1 = new Livro("A Voz do Brasil", "Jacks Perry", "8852364", 2025, 3);

        biblioteca.cadastrarLivro(livro1);

        Usuario usuario = new Usuario("Joaquim Vaz", "5224", "joaquimvaz@catolica.com");
        usuario.adicionarLivro(livro1);

        biblioteca.exibirInfo();
        usuario.exibirInfo();

        biblioteca.emprestar(livro1);
        biblioteca.devolver(livro1);
    }
}
package trabalho.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List; // Adicionado para podermos usar a Lista de livros

public class main {

    public static void main(String[] args) {

        // 1. Prepara a conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaPU");
        EntityManager em = emf.createEntityManager();

        // 2. Criação dos objetos
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileira");

        Editora editora = new Editora();
        editora.setNome("Editora Garnier");
        editora.setCidade("Rio de Janeiro");

        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAnoPublicacao(1899);
        livro.setIsbn("978-85-12345");
        livro.setPreco(new BigDecimal("45.90"));
        livro.setTipo(TipoPublicacao.IMPRESSO);

        livro.setAutor(autor);
        livro.setEditora(editora);

        // 3. Salva
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();

        System.out.println("Tudo certo! Livro salvo no banco.\n");

        
        System.out.println("--- LISTA DE LIVROS SALVOS NO BANCO ---");
        
        // select no banco de dados
        List<Livro> listaDeLivros = em.createQuery("from Livro", Livro.class).getResultList();
        
        // Passa por cada livro da lista e mostra
        for (Livro l : listaDeLivros) {
            System.out.println("ID do Livro: " + l.getId());
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Preço: R$ " + l.getPreco());
            System.out.println("Autor: " + l.getAutor().getNome());
            System.out.println("Editora: " + l.getEditora().getNome());
            System.out.println("---------------------------------------");
        }

        // fecha as conn
        em.close();
        emf.close();
    }
}
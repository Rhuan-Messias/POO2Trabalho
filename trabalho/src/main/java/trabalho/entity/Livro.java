package trabalho.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private int anoPublicacao;
    private String isbn;
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private TipoPublicacao tipo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "editora_id")
    private Editora editora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer novoId) {
        id = novoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String novoTitulo) {
        titulo = novoTitulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int novoAno) {
        anoPublicacao = novoAno;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String novoIsbn) {
        isbn = novoIsbn;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal novoPreco) {
        preco = novoPreco;
    }

    public TipoPublicacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoPublicacao novoTipo) {
        tipo = novoTipo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor novoAutor) {
        autor = novoAutor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora novaEditora) {
        editora = novaEditora;
    }
}
package trabalho.entity;

import jakarta.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String nacionalidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer novoId) {
        id = novoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String novaNacionalidade) {
        nacionalidade = novaNacionalidade;
    }
}
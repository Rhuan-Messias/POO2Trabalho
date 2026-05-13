package trabalho.entity;

import jakarta.persistence.*;

@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cidade;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String novaCidade) {
        cidade = novaCidade;
    }
}
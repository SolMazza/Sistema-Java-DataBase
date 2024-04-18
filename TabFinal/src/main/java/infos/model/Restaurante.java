package infos.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Restaurante")
public class Restaurante {



    @Id
    @GeneratedValue(strategy=GenerationType.TABLE , generator="Restaurante_generator")
    @TableGenerator(name="Restaurante_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=100)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Nome")
    private String Nome;

    public Restaurante(){}

    public Restaurante(String nome) {
        Nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
package infos.model;
import javax.persistence.*;

@Entity //entidade: objetp que pode ser gravado pelo mecanismo de persistencia
@Table(name="Funcionario")
public class Funcionario {



    @Id
    @GeneratedValue(strategy=GenerationType.TABLE , generator="Funcionario_generator")
    @TableGenerator(name="Funcionario_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=100)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Nome")
    private String Nome;


    public Funcionario(){}

    public Funcionario(String nome) {
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

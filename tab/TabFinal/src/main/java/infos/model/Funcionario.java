package infos.model;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity
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

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "funcionario")
    private List<Voto> votos;

    public Funcionario(){}

    public Funcionario(String nome) {
        Nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<Voto> getVotos() {
        return votos;
    }
    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }



    public void votar(Voto voto){
        if(votos == null){
            votos = new ArrayList<>();
        }
        voto.setFuncionario(this);
        votos.add(voto);
        }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                '}';
    }
}
package infos.model;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name="Voto")
public class Voto {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Voto_generator")
    @TableGenerator(name = "Voto",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 100)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "Data")
    private Calendar data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;



    public Voto() {
    }

    public Voto(Calendar data, Funcionario funcionario, Restaurante restaurante) {
        this.data = data;
        this.funcionario = funcionario;
        this.restaurante = restaurante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Voto voto = (Voto) object;
        return java.util.Objects.equals(id, voto.id);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                ", funcionario=" + funcionario +
                ", restaurante=" + restaurante +
                '}';
    }
}
package infos.model;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity //entidade: objetp que pode ser gravado pelo mecanismo de persistencia
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


    public Voto() {
    }

    public Voto(Calendar data) {
        this.data = data;
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
}
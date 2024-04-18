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

    public Voto(Calendar data) {
        this.data = data;
    }



    public List<Voto> busca (Funcionario funcionario, Calendar data) {

        TypedQuery<Voto> query
        this.en.createQuery
        (s: "select e from Voto e where e.funcionario funcionario and e.data:data", Voto.class);
        query.setParameter(s: "funcionario", funcionario);
        query.setParameter(s: "data", data, TemporalType.DATE);

        try {
            return query.getResultList();
        }
        catch (NoResultException e)
        {
        return null;
        }
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
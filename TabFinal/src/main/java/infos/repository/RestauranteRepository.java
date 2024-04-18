package infos.repository;
import br.org.fundatec.model.Restaurante;
import javax.persistence.*;
import java.util.List;

public class RestauranteRepository {

    private EntityManager ent;

    public RestauranteRepository(){
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("trabalhoFinal");
       ent = factory.createEntityManager();
    }

    public void inserir(Restaurante restaurante){
        this.ent.getTransaction().begin();
        this.ent.merge(restaurante);
        this.ent.getTransaction().commit();
    }

    public void remove(Restaurante restaurante){
        this.ent.getTransaction().begin();
        this.ent.remove(restaurante);
        this.ent.getTransaction().commit();
    }
}

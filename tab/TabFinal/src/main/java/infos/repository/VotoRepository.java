package infos.repository;

import infos.model.Voto;
import infos.model.Funcionario;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

public class VotoRepository {

    private EntityManager ent;

    public VotoRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("trabalhoFinal");
        ent = factory.createEntityManager();
    }

    public List<Voto> busca(Funcionario funcionario, Calendar data) {
        TypedQuery<Voto> query = this.ent.createQuery(
                "SELECT e FROM Voto e WHERE e.funcionario = :funcionario AND e.data = :data", Voto.class);

        query.setParameter("funcionario", funcionario);
        query.setParameter("data", data, TemporalType.DATE);

        return query.getResultList();
    }
    public List<Voto> apuracao(Calendar data) {
        TypedQuery<Voto> query = this.ent.createQuery(
                "SELECT e FROM Voto e WHERE e.data = :data", Voto.class);
        query.setParameter("data", data, TemporalType.DATE);

        return query.getResultList();
    }

}

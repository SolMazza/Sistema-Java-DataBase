package infos.repository;
import br.org.fundatec.model.Funcionario;
import javax.persistence.*;
import java.util.List;

public class FuncionarioRepository {

    private EntityManager ent;

    public FuncionarioRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("trabalhoFinal");
        ent = factory.createEntityManager();
    }

    public void inserir(Funcionario funcionario) {
        this.ent.getTransaction().begin();
        this.ent.merge(funcionario);
        this.ent.getTransaction().commit();
    }

    public List<funcionario> buscar() {
        TypedQuery<funcionario> buscarTodosQuery = this.ent.createQuery("select e from Funcionario e", Funcionario.class);
        return buscarTodosQuery.getResultList();
    }

    public Funcionario buscar(Integer id) {
        return  this.ent.find(Funcionario.class, id);

    }

    public void atualizar(Funcionario funcionario) {
        this.ent.getTransaction().begin();
        this.ent.merge(funcionario);
        this.ent.getTransaction().commit();
    }

    public void remove(Funcionario funcionario) {

        this.ent.remove(funcionario);

    }
}

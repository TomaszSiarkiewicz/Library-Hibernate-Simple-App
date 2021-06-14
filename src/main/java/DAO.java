import HibernateUtil.HibernateUtil;
import entities.EntityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DAO {

    EntityClass findByID(long id);

    void delete(EntityClass ent);

    void save(EntityClass ent);

    void update(EntityClass ent);


}

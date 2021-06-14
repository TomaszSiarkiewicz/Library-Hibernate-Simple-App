import HibernateUtil.HibernateUtil;
import entities.Client;
import entities.EntityClass;
import entities.Rent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClientDAO implements DAO {

    private Session session;

    public ClientDAO() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    public void addRent(Rent rent, Client client) {
        client.getRents().add(rent);
        update(client);
    }

    @Override
    public Client findByID(long id) {
        session.beginTransaction();
        String hquery = "FROM Client WHERE id= :id";
        Client client = (Client) session.createQuery(hquery).setParameter("id", id).getSingleResult();
        session.close();
        session.getTransaction().commit();
        return client;

    }

    @Override
    public void delete(EntityClass ent) {
        session.beginTransaction();
        session.delete(ent);
        session.getTransaction().commit();
    }

    @Override
    public void save(EntityClass ent) {
        session.beginTransaction();
        session.save(ent);
        session.getTransaction().commit();
    }

    @Override
    public void update(EntityClass ent) {
        session.beginTransaction();
        session.update(ent);
        session.getTransaction().commit();
    }
}

import HibernateUtil.HibernateUtil;
import entities.Author;
import entities.EntityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AuthorDAO implements DAO{
    private Session session;

    public AuthorDAO() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    @Override
    public Author findByID(long id) {
        session.beginTransaction();
        String hquery = "FROM Author WHERE id= :id";
        Author author = (Author) session.createQuery(hquery).setParameter("id", id).getSingleResult();
        session.close();
        session.getTransaction().commit();
        return author;

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

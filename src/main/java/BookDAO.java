import HibernateUtil.HibernateUtil;
import entities.Book;
import entities.Client;
import entities.EntityClass;
import entities.Rent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookDAO implements DAO {
    private Session session;

    public BookDAO() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    public void rentBook(Rent rent, Book book){
        book.getRents().add(rent);
        update(book);
    }
    @Override
    public Book findByID(long id) {
        session.beginTransaction();
        String hquery = "FROM Book WHERE id= :id";
        Book book = (Book) session.createQuery(hquery).setParameter("id", id).getSingleResult();
        session.close();
        session.getTransaction().commit();
        return book;

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

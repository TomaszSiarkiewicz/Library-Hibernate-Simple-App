import HibernateUtil.HibernateUtil;
import entities.Book;
import entities.Client;
import entities.EntityClass;
import entities.Rent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RentDAO implements DAO {
    private Session session;

    public RentDAO() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    public void newRent(Book book, Client client) {
        Rent rent = new Rent();
        BookDAO bookDAO = new BookDAO();
        bookDAO.rentBook(rent, book);
        ClientDAO clientDao = new ClientDAO();
        clientDao.addRent(rent, client);

    }

    @Override
    public Rent findByID(long id) {
        session.beginTransaction();
        String hquery = "FROM Rent WHERE id= :id";
        Rent rent = (Rent) session.createQuery(hquery).setParameter("id", id).getSingleResult();
        session.close();
        session.getTransaction().commit();
        return rent;
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

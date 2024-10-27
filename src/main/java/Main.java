import com.practice.entity.Guest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public final class Main {
    private Main() { }

    /**
     * edoti.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("Project Started!");
        SessionFactory factory = new Configuration().configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Guest guest1 = new Guest("Sri", "sri@gmail.com", "766779");
        session.save(guest1);


        transaction.commit();
        session.close();
    }
}

package sondev.hibernate_mysql.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buiderSessionFactory();
    private static SessionFactory buiderSessionFactory (){
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Innitial SessionFactory creation failed." +ex);
            throw new ExceptionInInitializerError(ex);
        }
    };

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdow(){
        getSessionFactory().close();
    };
}

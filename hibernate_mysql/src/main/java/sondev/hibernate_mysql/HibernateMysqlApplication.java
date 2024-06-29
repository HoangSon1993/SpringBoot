package sondev.hibernate_mysql;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;
import sondev.hibernate_mysql.entity.Category;
import sondev.hibernate_mysql.entity.Product;
import sondev.hibernate_mysql.utils.HibernateUtil;

@SpringBootApplication
public class HibernateMysqlApplication {

    public static void main(String[] args) {
//        Transaction transaction =null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try{
//            transaction = session.beginTransaction();
//
//            Category category = new Category("Electronics");
//            session.save(category);
//
//            Product product = new Product("Iphone 15 pro max",24500.0, category);
//            session.save(product);
//
//            transaction.commit();
//        }catch (Exception e){
//            if(transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        HibernateUtil.shutdow();

        SpringApplication.run(HibernateMysqlApplication.class, args);
    }

}

package persistencia;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private EntityManagerProvider() {
    }

    public static EntityManagerFactory getEMF() {
        if (emf == null) {
            Properties prop = new Properties();
            prop.setProperty("javax.persistence.jdbc.url", "jdbc:mysql://localhost/produto");
            prop.setProperty("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            prop.setProperty("javax.persistence.jdbc.password", "vertrigo");
            prop.setProperty("javax.persistence.jdbc.user", "root");
            emf = Persistence.createEntityManagerFactory("PU", prop);
        }
        return emf;
    }

    public static EntityManager getEM() {
        if (em == null) {
            em = getEMF().createEntityManager();

        }
        return em;
    }
}

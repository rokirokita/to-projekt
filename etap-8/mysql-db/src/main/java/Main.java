import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MysqlConnection mysqlConnection = new MysqlConnection();
        EntityManager em = mysqlConnection.getEntityManager();

        System.out.println("Zapytanie - SELECT c FROM Country c limit 1 -");
        long start = System.currentTimeMillis();
        Query q11 = em.createQuery("SELECT c FROM Country c").setMaxResults(1);
        q11.getSingleResult();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Zapytanie - SELECT c FROM City c limit 1 -");
//        start = System.currentTimeMillis();
//        Query q12 = em.createQuery("SELECT c FROM City c").setMaxResults(1);
//        q12.getSingleResult();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//
//        System.out.println("Zapytanie - SELECT b FROM Border b limit 1 -");
//        start = System.currentTimeMillis();
//        Query q13 = em.createQuery("SELECT b FROM Border b").setMaxResults(1);
//        q13.getSingleResult();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Zapytanie - SELECT c FROM Country c -");
//        start = System.currentTimeMillis();
//        Query q21 = em.createQuery("SELECT c FROM Country c");
//        ArrayList<Country> res21 = (ArrayList<Country>) q21.getResultList();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms" + " | Ilosc: " + res21.size());
//
//        System.out.println("Zapytanie - SELECT c FROM City c -");
//        start = System.currentTimeMillis();
//        Query q22 = em.createQuery("SELECT c FROM City c");
//        List res22 = q22.getResultList();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms" + " | Ilosc: " + res22.size());
//
//
//        System.out.println("Zapytanie - SELECT b FROM Border b -");
//        start = System.currentTimeMillis();
//        Query q23 = em.createQuery("SELECT b FROM Border b");
//        List res23 = q23.getResultList();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms" + " | Ilosc: " + res23.size());
//
//        Country country = new Country();
//        country.setName("B1");
//        country.setFullName("Republic of b1");
//        country.setBackground("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et fringilla odio. Vestibulum eget varius diam.");
//        country.setLocation("North Europe");
//        country.setLatitude(1);
//        country.setLongitude(1);
//        country.setLatitudeType("N");
//        country.setLongitudeType("E");
//        country.getNeighbors().add(res21.get(0));
//        Religion religion = new Religion();
//        religion.setName("Islam");
//        religion.setValue(100);
//        country.getReligions().add(religion);
//        Language language = new Language();
//        language.setName("polish");
//        country.getLanguages().add(language);
//        country.setGdpPerCapita(10);
//        country.setGdpTotal(1000000);
//
//        System.out.println("Tworzenie - Country");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.persist(country);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        City city = new City();
//        city.setName("City of b1");
//        city.setPopulation(10000);
//        city.setCapital(false);
//
//        System.out.println("Tworzenie - City");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.persist(city);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        Border border = new Border();
//        border.setLength(100);
//        border.getCountries().add(country);
//        border.getCountries().add((Country) res21.get(0));
//        System.out.println("Tworzenie - Border");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.persist(border);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        country.setName("Republic");
//        System.out.println("Edycja - Country");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.persist(country);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        city.setPopulation(1000000);
//        city.setCapital(true);
//        System.out.println("Edycja - City");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.persist(city);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        border.setLength(100000);
//        System.out.println("Edycja - Border");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.persist(border);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//
//
//        System.out.println("Usuwanie - City");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.remove(city);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Usuwanie - Border");
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.remove(border);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Usuwanie - Country");
//        em.refresh(country);
//        start = System.currentTimeMillis();
//        em.getTransaction().begin();
//        em.remove(country);
//        em.getTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");

        System.out.println("Zapytanie - SELECT c FROM Country c JOIN c.cities ci WHERE ci.name like '%a%' GROUP BY c -");
        start = System.currentTimeMillis();
        Query q123 = em.createQuery("SELECT c FROM Country c JOIN c.cities ci WHERE ci.name like '%a%' GROUP BY c");
        q123.getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        System.out.println("Zapytanie - SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c -");
        start = System.currentTimeMillis();
        Query q1234 = em.createQuery("SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c");
        q1234.getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
    }
}

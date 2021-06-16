/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objectdb.world;

import javax.persistence.*;
import java.util.*;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author Adam
 */
public class main {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("objectdb://underctrl.xyz:6136/world.odb;user=admin;password=admin");
        //Persistence.createEntityManagerFactory("objectdb:$objectdb/db/world.odb");
        EntityManager em = emf.createEntityManager();
        long start;
        long finish;
        long timeElapsed;
        //Country TEST_find = em.find(Country.class, );
        //System.out.println(TEST_find.getName());
        
       
                System.out.println("----------------------------------------------");
               start = System.currentTimeMillis();
              TypedQuery<Country> query =
       em.createQuery("SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c", Country.class);
       List<Country> results = query.getResultList();
        finish = System.currentTimeMillis();
         timeElapsed = finish - start;
        System.out.println("Ilosc rekordow: " + results.size() + " | Czas: " + timeElapsed + "ms");
       
        
        
              System.out.println("----------------------------------------------");
               start = System.currentTimeMillis();
              TypedQuery<Country> query3 =
       em.createQuery("SELECT c FROM Country c JOIN c.cities ci WHERE ci.name like '%a%'  GROUP BY c", Country.class);
       List<Country> results3 = query3.getResultList();
        finish = System.currentTimeMillis();
         timeElapsed = finish - start;
        System.out.println("Ilosc rekordow: " + results3.size() + " | Czas: " + timeElapsed + "ms");
   
        
        
    /*     
        System.out.println("Zapytanie - SELECT c FROM Country c limit 1 -");
        long start = System.currentTimeMillis();
        Query q11 = em.createQuery("SELECT c FROM Country c");
        //q11.setRange(0,1);
        List<Country> res1 = q11.setMaxResults(1).getResultList();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res1.size());

        System.out.println("Zapytanie - SELECT c FROM City c limit 1 -");
        start = System.currentTimeMillis();
        Query q21 = em.createQuery("SELECT c FROM City c");
        //q21.setRange(0,1);
        List<Border> res2 = q21.setMaxResults(1).getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res2.size());

        System.out.println("Zapytanie - SELECT b FROM Border b limit 1 -");
        start = System.currentTimeMillis();
        Query q31 = em.createQuery("SELECT b FROM Border b");
        //q31.setRange(0,1);
        List<City> res3 = q31.setMaxResults(1).getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res3.size());

        System.out.println("Zapytanie - SELECT c FROM Country c -");
        start = System.currentTimeMillis();
        Query q12 = em.createQuery("SELECT c FROM Country c");
        List<Country> res12 = q12.getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res12.size());

        System.out.println("Zapytanie - SELECT c FROM City c -");
        start = System.currentTimeMillis();
        Query q22 = em.createQuery("SELECT c FROM City c");
        List<Border> res22 = q22.getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res22.size());

        System.out.println("Zapytanie - SELECT b FROM Border b -");
        start = System.currentTimeMillis();
        Query q32 = em.createQuery("SELECT b FROM Border b");
        List<City> res32 = q32.getResultList();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res32.size());
        
        
       
        Country country = new Country();
        country.setId("A1");
        country.setName("!");
        country.setFullName("Republic of A1");
        country.setBackground("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et fringilla odio. Vestibulum eget varius diam.");
        country.setLocation("North Europe");
        country.getCoordinates().setLatitude(1);
        country.getCoordinates().setLongitude(1);
        country.getCoordinates().setLatitudeType(Coordinates.LatitudeType.N);
        country.getCoordinates().setLongitudeType(Coordinates.LongitudeType.E);
        country.setArea(100);
        country.getNeighbors().add(res1.get(0));
        country.setCoastline(100);
        country.setPopulation(100000);
        country.setPopulationGrowth(1);
        country.getReligions().put("Islam", 100f);
        country.getLanguages().add("polish");
        country.getGdp().setPerCapita(10);
        country.getGdp().setTotal(1000000);
        country.setUnemployment(1);

        System.out.println("Tworzenie - Country");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        City city = new City();
        city.setName("City of A1");
        city.setCapital(false);
        city.setPopulation(100000);

        System.out.println("Tworzenie - City");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
        Border border = new Border();
        border.getCountries()[0] = res1.get(0);
        border.getCountries()[1] = country;
        border.setLength(100);

        System.out.println("Tworzenie - Border");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.persist(border);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        country.getCities().add(city);
        country.getBorders().add(border);
        System.out.println("Edycja - Country");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        city.setPopulation(1000000);
        city.setCapital(true);
        System.out.println("Edycja - City");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        border.setLength(100000);
        System.out.println("Edycja - Border");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.persist(border);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        System.out.println("Usuwanie - Country");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        System.out.println("Usuwanie - City");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.remove(city);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");

        System.out.println("Usuwanie - Border");
        start = System.currentTimeMillis();
        em.getTransaction().begin();
        em.remove(border);
        em.getTransaction().commit();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
 
 */
        
       
        
        /*
        em.getTransaction().begin();
        
        for (int i = 0; i < 1000; i++) {
        City TEST_find = new City();
TEST_find.setName("TEST" + i);d
em.persist(TEST_find);
        }
  
        em.getTransaction().commit();
        */
 
        
        
      /*  
        Country TEST_find = em.find(Country.class, "A_7");  
        System.out.println(TEST_find.getId());
        System.out.println("Usuwanie - Border");
        long start = System.currentTimeMillis();
            em.getTransaction().begin();    
            em.remove(TEST_find);
            em.getTransaction().commit();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
        */
      
        /*
         City city = em.find(City.class, 694);
        System.out.println(city.getName());
        System.out.println("Usuwanie - Border");
        long start = System.currentTimeMillis();
            em.getTransaction().begin();    
            em.remove(city);
            em.getTransaction().commit();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
        */
   /*
        Border border = em.find(Border.class, 723);
        System.out.println("Usuwanie - Border");
        long start = System.currentTimeMillis();
            em.getTransaction().begin();    
            em.remove(border);
            em.getTransaction().commit();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
        */
        
        /*
        Border border = em.find(Border.class, 719);
        System.out.println(border.getLength());
        border.setLength(98231);
        System.out.println("Edycja - City");
        long start = System.currentTimeMillis();
        em.getTransaction().begin();
                    
            em.persist(border);
            em.getTransaction().commit();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
        
        */
        
        /*
        City city = em.find(City.class, 694);
        System.out.println(city.getName());
        city.setPopulation(1000000);
        city.setCapital(true);
        System.out.println("Edycja - City");
        long start = System.currentTimeMillis();
        em.getTransaction().begin();
                    
            em.persist(city);
            em.getTransaction().commit();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
        */
        
        /*
        
        Border border = em.find(Border.class, 723);
        City city = em.find(City.class, "City A_3");
        Country TEST_find = em.find(Country.class, "A_3");
        
        
        System.out.println(TEST_find.getId());
        System.out.println(border.getLength());
       
                TEST_find.getCities().add(city);
                TEST_find.getBorders().add(border);
                long start = System.currentTimeMillis();
        em.getTransaction().begin();
                    
            em.persist(TEST_find);
            em.getTransaction().commit();
        
         long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Czas: " + timeElapsed + "ms");
       */
        
        
        
        /*
        
        System.out.println("----------------------------------------------");
        long start = System.currentTimeMillis();
        TypedQuery<Country> query2 =
       em.createQuery("SELECT c FROM Country c", Country.class);
       List<Country> results2 = query2.getResultList();
       long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Ilosc rekordow: " + results2.size() + " | Czas: " + timeElapsed + "ms");
       for (Country p : results2) { 
            System.out.println(p);
        }  
        */
      
       
        /*
        Country testcity = new Country();
            testcity.setId("A_7");
            testcity.setName("A_City_7");
            testcity.setLocation("LOC_test_7");
            testcity.setArea(2648);
            testcity.setCoastline(123);
            testcity.setPopulation(1111111);
            testcity.setPopulationGrowth(12);
            testcity.setUnemployment(6);
            testcity.setFullName("FULL_NAME");
            testcity.setBackground("BACKGROUND");
            testcity.getReligions().put("MAKARONIARZE", 12f);
            testcity.getGdp().setPerCapita(985654);
            testcity.getGdp().setTotal(484848488);
            testcity.getCoordinates().setLatitude(6);
            testcity.getCoordinates().setLatitudeType(Coordinates.LatitudeType.N);
            testcity.getCoordinates().setLongitude(12);
            testcity.getCoordinates().setLongitudeType(Coordinates.LongitudeType.E);
            testcity.getLanguages().add("POLOMOA");

         TypedQuery<Country> query2 =
        em.createQuery("SELECT c FROM Country c where c.id = 'A_3' ", Country.class);
       List<Country> results2 = query2.getResultList();

        Border border = new Border();
        border.getCountries()[0] = results2.get(0);
        //border.getCountries()[1] = "A_7";
        border.setLength(100);
//        country.getBorders().add(border);
        System.out.println("Tworzenie - Border");
     
            em.getTransaction().begin();
            long start = System.currentTimeMillis();
            em.persist(border);
            em.getTransaction().commit();
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println( "Czas: " + timeElapsed + "ms");

  */   
            
            
            
            
        /*
        Country TEST_find = em.find(Country.class, "br");
        System.out.println(TEST_find.getId());
        em.getTransaction().begin();
        em.detach(TEST_find);
        TEST_find.setId("BR_TEST1");
        TEST_find = em.merge(TEST_find);
                    
            em.persist(TEST_find);
            em.getTransaction().commit();
        */
        
        
        /*
        em.getTransaction().begin();
        TEST_find.setId("br_test");
        em.getTransaction().commit();
        System.out.println(TEST_find.getId());
        */
        
        /* 
        Query q1 = em.createQuery("SELECT SUM(p.population) FROM Country p where p.populationGrowth < 0 ");
               System.out.println("Average X: " + q1.getSingleResult()); 
              
       System.out.println("----------------------------------------------");       
       TypedQuery<Country> query1 =
       em.createQuery("SELECT p FROM Country p where p.unemployment > 45", Country.class);
       List<Country> results1 = query1.getResultList();
       for (Country p : results1) {
            //System.out.println(p.getId());
            System.out.println(p);
        }  
       System.out.println("----------------------------------------------");
              TypedQuery<Country> query =
       em.createQuery("SELECT p FROM Country p where p.populationGrowth < 0 ORDER BY p.name DESC", Country.class);
       List<Country> results = query.getResultList();
       for (Country p : results) {
            //System.out.println(p.getId());
            System.out.println(p);
        }  
       System.out.println("----------------------------------------------");
              TypedQuery<Country> query2 =
       em.createQuery("SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c", Country.class);
       List<Country> results2 = query.getResultList();
       for (Country p : results2) {
            //System.out.println(p.getId());
            System.out.println(p);
        }  
       
       */
        /* 
                      System.out.println("----------------------------------------------");
              long start = System.currentTimeMillis();
              TypedQuery<Country> query2 =
       em.createQuery("SELECT c FROM Country c", Country.class);
       List<Country> results2 = query2.getResultList();
       long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Ilosc rekordow: " + results2.size() + " | Czas: " + timeElapsed + "ms");
       for (Country p : results2) { 
            System.out.println(p);
        }  
        
           
       
       
       
              System.out.println("----------------------------------------------");
               start = System.currentTimeMillis();
              TypedQuery<Country> query =
       em.createQuery("SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c", Country.class);
       List<Country> results = query.getResultList();
        finish = System.currentTimeMillis();
         timeElapsed = finish - start;
        System.out.println("Ilosc rekordow: " + results.size() + " | Czas: " + timeElapsed + "ms");
       for (Country p : results) {
            System.out.println(p);
        }  
       
        
        
              System.out.println("----------------------------------------------");
               start = System.currentTimeMillis();
              TypedQuery<Country> query3 =
       em.createQuery("SELECT c FROM Country c JOIN c.cities ci WHERE ci.name like '%a%'  GROUP BY c", Country.class);
       List<Country> results3 = query3.getResultList();
        finish = System.currentTimeMillis();
         timeElapsed = finish - start;
        System.out.println("Ilosc rekordow: " + results3.size() + " | Czas: " + timeElapsed + "ms");
       for (Country p : results3) {
            //System.out.println(p.getId());
            System.out.println(p);
        }  
       
       */
       
       
       
       
        /*      
        TypedQuery<Country> query =
    em.createQuery("SELECT p FROM Country p", Country.class);
       List<Country> results = query.getResultList();
       for (Country p : results) {
            System.out.println(p);
        }*/
        
 //TypedQuery<com.objectdb.world.Country> query =
 //           em.createQuery("SELECT p FROM com.objectdb.world.Country p ", Country.class);
  //      List<com.objectdb.world.Country> results = query.getResultList();
   //     for (com.objectdb.world.Country p : results) {
   //         System.out.println(p);
    //    }
        // Retrieve all the City objects from the database:


        // Close the database connection:
        em.close();
        emf.close();
    }
}

import com.objectdb.world.Border;
import com.objectdb.world.City;
import com.objectdb.world.Coordinates;
import com.objectdb.world.Country;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Array;
import java.util.*;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Properties properties = new Properties();
        properties.setProperty(
                "javax.jdo.PersistenceManagerFactoryClass", "com.objectdb.jdo.PMF");
        properties.setProperty(
                "javax.jdo.option.ConnectionURL", "objectdb://underctrl.xyz:6136/world.odb");
        properties.setProperty("javax.jdo.option.ConnectionUserName", "admin");
        properties.setProperty("javax.jdo.option.ConnectionPassword", "admin");

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(properties);
        PersistenceManager pm = pmf.getPersistenceManager();

//        System.out.println("Zapytanie - SELECT c FROM Country c limit 1 -");
//        long start = System.currentTimeMillis();
//        Query q11 = pm.newQuery("SELECT c FROM Country c");
//        q11.setRange(0,1);
//        List<Country> res1 = (List<Country>)q11.execute();
//        long finish = System.currentTimeMillis();
//        long timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res1.size());
//
//        System.out.println("Zapytanie - SELECT c FROM City c limit 1 -");
//        start = System.currentTimeMillis();
//        Query q21 = pm.newQuery("SELECT c FROM City c");
//        q21.setRange(0,1);
//        List<Border> res2 = (List<Border>)q21.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res2.size());
//
//        System.out.println("Zapytanie - SELECT b FROM Border b limit 1 -");
//        start = System.currentTimeMillis();
//        Query q31 = pm.newQuery("SELECT b FROM Border b");
//        q31.setRange(0,1);
//        List<City> res3 = (List<City>)q31.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res3.size());
//
//        System.out.println("Zapytanie - SELECT c FROM Country c -");
//        start = System.currentTimeMillis();
//        Query q12 = pm.newQuery("SELECT c FROM Country c");
//        List<Country> res12 = (List<Country>)q12.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res12.size());
//
//        System.out.println("Zapytanie - SELECT c FROM City c -");
//        start = System.currentTimeMillis();
//        Query q22 = pm.newQuery("SELECT c FROM City c");
//        List<Border> res22 = (List<Border>)q22.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res22.size());
//
//        System.out.println("Zapytanie - SELECT b FROM Border b -");
//        start = System.currentTimeMillis();
//        Query q32 = pm.newQuery("SELECT b FROM Border b");
//        List<City> res32 = (List<City>)q32.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms | Ilosc: " + res32.size());
//        Country country = new Country();
//        country.setId("b17");
//        country.setName("b7");
//        country.setFullName("Republic of b7");
//        country.setBackground("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et fringilla odio. Vestibulum eget varius diam.");
//        country.setLocation("North Europe");
//        country.getCoordinates().setLatitude(1);
//        country.getCoordinates().setLongitude(1);
//        country.getCoordinates().setLatitudeType(Coordinates.LatitudeType.N);
//        country.getCoordinates().setLongitudeType(Coordinates.LongitudeType.E);
//        country.setArea(100);
//        country.getNeighbors().add(res1.get(0));
//        country.setCoastline(100);
//        country.setPopulation(100000);
//        country.setPopulationGrowth(1);
//        country.getReligions().put("Islam", 100f);
//        country.getLanguages().add("polish");
//        country.getGdp().setPerCapita(10);
//        country.getGdp().setTotal(1000000);
//        country.setUnemployment(1);
//
//        System.out.println("Tworzenie - Country");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.makePersistent(country);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        City city = new City();
//        city.setName("City of b7");
//        city.setCapital(false);
//        city.setPopulation(100000);
//
//        System.out.println("Tworzenie - City");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.makePersistent(city);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//        Border border = new Border();
//        border.getCountries()[0] = res1.get(0);
//        border.getCountries()[1] = country;
//        border.setLength(100);
//
//        System.out.println("Tworzenie - Border");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.makePersistent(border);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        country.getCities().add(city);
//        country.getBorders().add(border);
//        System.out.println("Edycja - Country");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.makePersistent(country);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        city.setPopulation(1000000);
//        city.setCapital(true);
//        System.out.println("Edycja - City");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.makePersistent(city);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        border.setLength(100000);
//        System.out.println("Edycja - Border");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.makePersistent(border);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Usuwanie - Country");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.deletePersistent(country);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Usuwanie - City");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.deletePersistent(city);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");
//
//        System.out.println("Usuwanie - Border");
//        start = System.currentTimeMillis();
//        pm.currentTransaction().begin();
//        pm.deletePersistent(border);
//        pm.currentTransaction().commit();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Czas: " + timeElapsed + "ms");

//          duplicateData(pm);
        generateDataMysql(pm);
//        System.out.println("Zapytanie - SELECT c FROM Country c JOIN c.cities ci WHERE ci.name like '%a%' GROUP BY c -");
//        start = System.currentTimeMillis();
//        Query q123 = pm.newQuery("SELECT c FROM Country c JOIN c.cities ci WHERE ci.name like '%a%' GROUP BY c");
//        List<Country> res123 = (List<Country>)q123.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Ilość rekordów: " + res123.size() + " | Czas: " + timeElapsed + "ms");
//
//        System.out.println("Zapytanie - SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c -");
//        start = System.currentTimeMillis();
//        Query q223 = pm.newQuery("SELECT c FROM Country c JOIN c.borders b WHERE b.length > 1000 GROUP BY c");
//        List<Country> res223 = (List<Country>)q223.execute();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Ilość rekordów: " + res223.size() + " | Czas: " + timeElapsed + "ms");
    }
    private static void duplicateData(PersistenceManager pm) {
        System.out.println("Zapytanie - SELECT c FROM Country c-");
        Query q11 = pm.newQuery("SELECT c FROM Country c");
        List<Country> res1 = (List<Country>)q11.execute();
        System.out.println("Ilosc: " + res1.size());
        pm.currentTransaction().begin();
        for(Country country: res1) {
            Country c = pm.detachCopy(country);
            c.setId(c.getId() + "-1");
            pm.makePersistent(c);
            for(City city: country.getCities()) {
                City ci = pm.detachCopy(city);
                ci.setId(ci.getId() + 1000);
                c.getCities().add(ci);
            }
            for(Border border: country.getBorders()) {
                Border border1 = new Border();
                border1.setLength(border.getLength());
                border1.getCountries()[0] = c;
                border1.getCountries()[1] = border.getCountries()[0];
                c.getBorders().add(border1);
            }
        }
        pm.currentTransaction().commit();
    }
    private static void generateDataMysql(PersistenceManager pm) {
        Query q = pm.newQuery("SELECT c FROM Country c");
        try {
            FileWriter myWriter = new FileWriter("C:/nowy/dump.sql");

        List<Country> res = (List<Country>)q.execute();
        int x = 1;
        int y = 1;
        int a = 1;
        int b = 1;
        Map<String, Integer> countryIds = new HashMap<String, Integer>();
        for(Country item : res) {
            myWriter.write("INSERT INTO countries " +
                    "(id, background, fullName, gdpPerCapita, gdpTotal, latitude, latitudeType, location, longitude, longitudeType, name, capitol_id) " +
                    "VALUES("
                    +x+", '"
                    + (item.getBackground() != null ? item.getBackground().replace("'", "\\\'") : "") +"', '"
                    +(item.getFullName() != null ? item.getFullName().replace("'", "\\\'") : "")+"', "
                    +item.getGdp().getPerCapita()+", "
                    +item.getGdp().getTotal()+", "
                    +item.getCoordinates().getLatitude()+", '"
                    +item.getCoordinates().getLatitudeType()+"', '"
                    +(item.getLocation() != null ? item.getLocation().replace("'", "\\\'") : "")+"', "
                    +item.getCoordinates().getLongitude()+", '"
                    +(item.getCoordinates().getLongitudeType() != null ? item.getCoordinates().getLongitudeType() : "")+"', '"
                    +(item.getName() != null ? item.getName().replace("'", "\\\'") : "")+"', null);");
            countryIds.put(item.getId(), x);
            for (String lang : item.getLanguages()) {
                myWriter.write("INSERT INTO languages (id, name) VALUES("+y+", '"+lang+"');");
                myWriter.write("INSERT INTO country_languages (country_id, language_id) VALUES("+x+", "+y+");");
                y++;
            }
            for(Map.Entry<String, Float> entry : item.getReligions().entrySet()) {
                myWriter.write("INSERT INTO religions (id, name, value, country_id) VALUES("+a+", '"+entry.getKey().replace("'", "\\\'")+"', "+entry.getValue()+", "+x+");");
                a++;
            }

            for (City city : item.getCities()) {
                myWriter.write("INSERT INTO cities (id, capital, name, population, country_id) " +
                        "VALUES("+b+", "+city.isCapital()+", '"+city.getName().replace("'", "\\\'")+"', "+city.getPopulation()+", "+x+");");
                if(city.isCapital()){
                    myWriter.write("UPDATE countries SET capitol_id="+b+" WHERE id="+x+";");
                }
                b++;
            }
            x++;
        }
        List<String> borders = new ArrayList<String>();
        int e = 1;
        for(Country item : res) {
            int z = countryIds.get(item.getId());
            for (Country neighbor : item.getNeighbors()) {
                myWriter.write("INSERT INTO country_neighbors (country_id, neighbor_id) VALUES(" + z + ", " + countryIds.get(neighbor.getId()) + ");");
            }
            for (Border border : item.getBorders()) {
                int c = countryIds.get(border.getCountries()[0].getId());
                int d = countryIds.get(border.getCountries()[1].getId());
                if(!borders.contains(c+"-"+d) && !borders.contains(d+"-"+c)) {
                    myWriter.write("INSERT INTO borders (id, length) " +
                            "VALUES(" + e + ", "+border.getLength()+");");
                    myWriter.write("INSERT INTO border_countries (border_id, country_id) VALUES ("+e+", "+c+");");
                    myWriter.write("INSERT INTO border_countries (border_id, country_id) VALUES ("+e+", "+d+");");
                    borders.add(c+"-"+d);
                    e++;
                }
            }

        }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

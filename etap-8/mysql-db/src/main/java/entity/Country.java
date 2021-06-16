package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String fullName;

    private String background;

    private String location;

    private float latitude;

    private float longitude;

    private String latitudeType;

    private String longitudeType;

    private Integer gdpPerCapita;

    private double gdpTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capitol_id", referencedColumnName = "id")
    private City capital;

    @ManyToMany(mappedBy = "countries")
    private Set<Border> borders = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "country_neighbors",
            joinColumns = { @JoinColumn(name = "country_id") },
            inverseJoinColumns = { @JoinColumn(name = "neighbor_id") }
    )
    private Set<Country> neighbors = new HashSet<>();


    @OneToMany(mappedBy="country")
    private Set<City> cities = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "country_languages",
            joinColumns = { @JoinColumn(name = "country_id") },
            inverseJoinColumns = { @JoinColumn(name = "language_id") }
    )
    private Set<Language> languages = new HashSet<>();


    @OneToMany(mappedBy="country")
    private Set<Religion> religions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getLatitudeType() {
        return latitudeType;
    }

    public void setLatitudeType(String latitudeType) {
        this.latitudeType = latitudeType;
    }

    public String getLongitudeType() {
        return longitudeType;
    }

    public void setLongitudeType(String longitudeType) {
        this.longitudeType = longitudeType;
    }

    public Integer getGdpPerCapita() {
        return gdpPerCapita;
    }

    public void setGdpPerCapita(Integer gdpPerCapita) {
        this.gdpPerCapita = gdpPerCapita;
    }

    public double getGdpTotal() {
        return gdpTotal;
    }

    public void setGdpTotal(double gdpTotal) {
        this.gdpTotal = gdpTotal;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Set<Border> getBorders() {
        return borders;
    }

    public void setBorders(Set<Border> borders) {
        this.borders = borders;
    }

    public Set<Country> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Country> neighbors) {
        this.neighbors = neighbors;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<Religion> getReligions() {
        return religions;
    }

    public void setReligions(Set<Religion> religions) {
        this.religions = religions;
    }
}

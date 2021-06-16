package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="borders")
public class Border {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer length;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "border_countries",
            joinColumns = { @JoinColumn(name = "border_id") },
            inverseJoinColumns = { @JoinColumn(name = "country_id") }
    )
    private Set<Country> countries = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}

package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    private Long id;
    private String name;
    @Column(name = "adress")
    private String address;
    private String details;


    @OneToMany(mappedBy = "location")
    @JsonBackReference
    private List<Attraction> attractions;

    public Location() {
    }

    public Location(Long id, String name, String address, String details) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.details = details;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(name, location.name) &&
                Objects.equals(address, location.address) &&
                Objects.equals(details, location.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, details);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

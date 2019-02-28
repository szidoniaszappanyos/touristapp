package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class AttractionType {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "attractionType")
    @JsonBackReference
    private List<Attraction> attractions;

    @OneToMany(mappedBy = "attractionType",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Interests> interests;

    public AttractionType() {
    }

    public AttractionType(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttractionType that = (AttractionType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(attractions, that.attractions) &&
                Objects.equals(interests, that.interests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attractions, interests);
    }

    @Override
    public String toString() {
        return "AttractionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attractions=" + attractions +
                ", interests=" + interests +
                '}';
    }
}

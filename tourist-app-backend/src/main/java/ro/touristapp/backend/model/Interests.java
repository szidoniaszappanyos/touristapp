package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Interests {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tourist_user_id")
    @JsonManagedReference
    private TouristUser touristUser;

    @ManyToOne
    @JoinColumn(name = "attraction_type_id")
    @JsonBackReference
    private AttractionType attractionType;

    public Interests() {
    }

    public Interests(Long id, TouristUser touristUser, AttractionType attractionType) {
        this.id = id;
        this.touristUser = touristUser;
        this.attractionType = attractionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TouristUser getTouristUser() {
        return touristUser;
    }

    public void setTouristUser(TouristUser touristUser) {
        this.touristUser = touristUser;
    }

    public AttractionType getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(AttractionType attractionType) {
        this.attractionType = attractionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interests interests = (Interests) o;
        return Objects.equals(id, interests.id) &&
                Objects.equals(touristUser, interests.touristUser) &&
                Objects.equals(attractionType, interests.attractionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, touristUser, attractionType);
    }

    @Override
    public String toString() {
        return "Interests{" +
                "id=" + id +
                ", touristUser=" + touristUser +
                ", attractionType=" + attractionType +
                '}';
    }
}

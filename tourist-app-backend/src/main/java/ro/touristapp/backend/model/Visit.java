package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Visit {
    @Id
    @SequenceGenerator(name="visit_pk_sequence",sequenceName="visit_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="visit_pk_sequence")
    private Long id;
    private Timestamp visitDate;
    private String details;

    @ManyToOne
    @JoinColumn(name = "attraction_id")
    @JsonBackReference
    private Attraction attraction;

    @ManyToOne
    @JoinColumn(name = "tourist_user_id")
    @JsonManagedReference
    private TouristUser touristUser;

    public Visit() {
    }

    public Visit(Long id, Timestamp visitDate, String details, Attraction attraction, TouristUser touristUser) {
        this.id = id;
        this.visitDate = visitDate;
        this.details = details;
        this.attraction = attraction;
        this.touristUser = touristUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public TouristUser getTouristUser() {
        return touristUser;
    }

    public void setTouristUser(TouristUser touristUser) {
        this.touristUser = touristUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id) &&
                Objects.equals(visitDate, visit.visitDate) &&
                Objects.equals(details, visit.details) &&
                Objects.equals(attraction, visit.attraction) &&
                Objects.equals(touristUser, visit.touristUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visitDate, details, attraction, touristUser);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", visitDate=" + visitDate +
                ", details='" + details + '\'' +
                ", attraction=" + attraction +
                ", touristUser=" + touristUser +
                '}';
    }
}

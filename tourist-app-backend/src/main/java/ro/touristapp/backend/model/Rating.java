package ro.touristapp.backend.model;

import javax.persistence.*;

@Entity
public class Rating {
    @Id
    @SequenceGenerator(name="rating_pk_sequence",sequenceName="rating_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="rating_pk_sequence")
    private long id;
    @ManyToOne
    private TouristUser user;
    @ManyToOne
    private Tour tour;
    private int rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TouristUser getUser() {
        return user;
    }

    public void setUser(TouristUser user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

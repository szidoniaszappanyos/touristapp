package ro.touristapp.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    private long id;
    @ManyToOne
    private TouristUser user;
    @ManyToOne
    private Tour tour;
    private int stars;

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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

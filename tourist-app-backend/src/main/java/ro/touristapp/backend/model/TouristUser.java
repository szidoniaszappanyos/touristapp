package ro.touristapp.backend.model;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TouristUser {

    @Id
    @SequenceGenerator(name="tourist_pk_sequence",sequenceName="tourist_user_id_seq",allocationSize = 1,initialValue = 2)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tourist_pk_sequence")
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private Timestamp birthDate;

    @OneToOne(mappedBy = "touristUser")
    @JsonBackReference
    private Users users;

    @OneToMany(mappedBy = "touristUser")
    @JsonBackReference
    private List<Interests> interests;

    @OneToMany(mappedBy = "touristUser")
    @JsonBackReference
    private List<Visit> visits;

    @OneToMany(mappedBy = "user")
    private Set<Rating> ratings;

    public TouristUser() {
    }

    public TouristUser(String lastName, String firstName, String email, Timestamp birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TouristUser that = (TouristUser) o;
        return Objects.equals(id, that.id) && Objects.equals(lastName, that.lastName)
                && Objects.equals(firstName, that.firstName) && Objects.equals(email, that.email)
                && Objects.equals(birthDate, that.birthDate) && Objects.equals(users, that.users)
                && Objects.equals(visits, that.visits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, email, birthDate, users, visits);
    }

    @Override
    public String toString() {
        return "TouristUser{" + "id=" + id + ", lastName='" + lastName + '\'' + ", firstName='" + firstName + '\''
                + ", email='" + email + '\'' + ", birthDate=" + birthDate + '}';
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public int[] getInterestsPoints(boolean adjusted) {
        int art = 0;
        int amusement = 0;
        int recreation = 0;
        int historic = 0;
        for (int i = 0; i < interests.size(); i++) {
            int multiplicationFactor = 1;
            if(adjusted){
                multiplicationFactor=interests.get(i).getStars();
            }
            Set<AttractionCategory> categories = interests.get(i).getAttractionType().getCategories();

            for (Iterator<AttractionCategory> attCategory = categories.iterator(); attCategory.hasNext(); ) {
                AttractionCategory attractionCategory = attCategory.next();
                switch (attractionCategory.getId().intValue()) {
                    case 1:
                        art += multiplicationFactor;
                        break;
                    case 2:
                        amusement += multiplicationFactor;
                        break;
                    case 3:
                        recreation += multiplicationFactor;
                        break;
                    case 4:
                        historic += multiplicationFactor;
                        break;
                }
            }
        }
        return new int[]{art, amusement, recreation, historic};
    }
}

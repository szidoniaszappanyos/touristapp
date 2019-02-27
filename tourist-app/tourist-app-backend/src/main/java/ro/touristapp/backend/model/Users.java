package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Users {

    @Id
    private Long id;
    private String username;
    private String password;
    private Timestamp creationDate;
    private Timestamp updateDate;

    @OneToOne
    @JoinColumn(name="tourist_user_id")
    @JsonManagedReference
    private TouristUser touristUser;

    public Users() {
    }

    public Users(Long id, String username, String password, Timestamp creationDate, Timestamp updateDate, TouristUser touristUser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.touristUser = touristUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
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
        Users users = (Users) o;
        return Objects.equals(id, users.id) &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(creationDate, users.creationDate) &&
                Objects.equals(updateDate, users.updateDate) &&
                Objects.equals(touristUser, users.touristUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, creationDate, updateDate, touristUser);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", touristUser=" + touristUser +
                '}';
    }
}

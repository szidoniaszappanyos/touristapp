package ro.touristapp.backend.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TouristUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

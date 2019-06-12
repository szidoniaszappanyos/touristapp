package ro.touristapp.backend.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	private int stars;

	public Interests() {
	}

	public Interests(Long id, TouristUser touristUser, AttractionType attractionType, int stars) {
		this.id = id;
		this.touristUser = touristUser;
		this.attractionType = attractionType;
		if (stars < 0) {
			stars = 0;
		}
		if (stars > 5) {
			stars = 5;
		}
		this.stars = stars;
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

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Interests interests = (Interests) o;
		return Objects.equals(id, interests.id) && Objects.equals(touristUser, interests.touristUser)
				&& Objects.equals(attractionType, interests.attractionType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, touristUser, attractionType);
	}

	@Override
	public String toString() {
		return "Interests{" + "id=" + id + ", touristUser=" + touristUser + ", attractionType=" + attractionType + '}';
	}
}

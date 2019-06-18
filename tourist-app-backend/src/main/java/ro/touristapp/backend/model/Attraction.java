package ro.touristapp.backend.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Attraction {
	@Id
	@SequenceGenerator(name="attraction_pk_sequence",sequenceName="attraction_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="attraction_pk_sequence")
	private Long id;
	private String name;
	private String details;
	private Double cost;
	private Long duration;

	@ManyToOne
	@JoinColumn(name = "location_id")
	@JsonManagedReference
	private Location location;

	@ManyToOne
	@JoinColumn(name = "attraction_type_id")
	@JsonManagedReference
	private AttractionType attractionType;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "gallery", joinColumns = { @JoinColumn(name = "attraction_id") }, inverseJoinColumns = {
			@JoinColumn(name = "picture_id") })
	@JsonManagedReference
	private List<Picture> pictures;

	@ManyToOne
	@JoinColumn(name = "weekly_schedule_id")
	@JsonManagedReference
	private WeeklySchedule weeklySchedule;

	@OneToMany(mappedBy = "attraction")
	@JsonManagedReference
	private List<Visit> visits;

	@ManyToMany
	@JoinTable(name = "attraction_tour", joinColumns = { @JoinColumn(name = "attraction_id") }, inverseJoinColumns = {
			@JoinColumn(name = "tour_id") })
	private Set<Tour> tourSet;

	public Attraction() {
	}

	public Attraction(Long id, String name, String details, Location location, AttractionType attractionType) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.location = location;
		this.attractionType = attractionType;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public AttractionType getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(AttractionType attractionType) {
		this.attractionType = attractionType;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public WeeklySchedule getWeeklySchedule() {
		return weeklySchedule;
	}

	public void setWeeklySchedule(WeeklySchedule weeklySchedule) {
		this.weeklySchedule = weeklySchedule;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Attraction that = (Attraction) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(details, that.details)
				&& Objects.equals(location, that.location) && Objects.equals(attractionType, that.attractionType)
				&& Objects.equals(pictures, that.pictures) && Objects.equals(weeklySchedule, that.weeklySchedule)
				&& Objects.equals(visits, that.visits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, details, location, attractionType, pictures, weeklySchedule, visits);
	}

	@Override
	public String toString() {
		return "Attraction{" + "id=" + id + ", name='" + name + '\'' + ", details='" + details + '\'' + ", location="
				+ location + ", attractionType=" + attractionType + ", pictures=" + pictures + ", weeklySchedule="
				+ weeklySchedule + ", visits=" + visits + '}';
	}
}

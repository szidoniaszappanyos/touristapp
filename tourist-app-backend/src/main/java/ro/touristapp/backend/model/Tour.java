package ro.touristapp.backend.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Tour {

	private long distance;// meters
	private long duration;// seconds
	private double cost;// dollars
	private int art;
	private int amusement;
	private int recreation;
	private int historic;

	@OneToMany
	private Set<Attraction> attractions = new HashSet<>();

	public void generateSummary() {

		for (Iterator<Attraction> it = attractions.iterator(); it.hasNext();) {
			Attraction attraction = it.next();
			Set<AttractionCategory> categories = attraction.getAttractionType().getCategories();
		}
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getArt() {
		return art;
	}

	public void setArt(int art) {
		this.art = art;
	}

	public int getAmusement() {
		return amusement;
	}

	public void setAmusement(int amusement) {
		this.amusement = amusement;
	}

	public int getRecreation() {
		return recreation;
	}

	public void setRecreation(int recreation) {
		this.recreation = recreation;
	}

	public int getHistoric() {
		return historic;
	}

	public void setHistoric(int historic) {
		this.historic = historic;
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(Set<Attraction> attractions) {
		this.attractions = attractions;
	}

}

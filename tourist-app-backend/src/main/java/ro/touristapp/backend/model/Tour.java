package ro.touristapp.backend.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tour {
	@Id
	private long id;

	private long distance;// meters
	private long duration;// seconds
	private double cost=0.0;// dollars
	private int art;
	private int amusement;
	private int recreation;
	private int historic;
	@OneToMany
	private Set<Attraction> attractions = new HashSet<>();

	public void generateSummary() {

		for (Iterator<Attraction> it = attractions.iterator(); it.hasNext();) {
			Attraction attraction = it.next();
			duration+= Optional.ofNullable(attraction.getDuration()).orElse(1800L);
			cost+=Optional.ofNullable(attraction.getCost()).orElse(0.0);
			Set<AttractionCategory> categories = attraction.getAttractionType().getCategories();
			for(Iterator<AttractionCategory>catsIt=categories.iterator();catsIt.hasNext();){
				AttractionCategory attractionCategory = catsIt.next();
				for(Iterator<AttractionType> typeIt = attractionCategory.getAttractionType().iterator();typeIt.hasNext();){
					AttractionType attractionType=typeIt.next();
					switch (attractionType.getId().intValue()){
						case 1:
							art++;
							break;
						case 2:
							amusement++;
							break;
						case 3:
							recreation++;
							break;
						case 4:
							historic++;
							break;
						default:
							break;
					}

				}
			}
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

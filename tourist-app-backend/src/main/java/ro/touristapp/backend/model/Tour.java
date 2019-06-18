package ro.touristapp.backend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Entity
public class Tour {
	@Id
	@SequenceGenerator(name="tour_pk_sequence",sequenceName="tour_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tour_pk_sequence")
	private Long id;

	private long distance;// meters
	private long duration;// seconds
	private double cost=0.0;// dollars
	private int art;
	private int amusement;
	private int recreation;
	private int historic;
	@ManyToMany
	@JoinTable(name = "attraction_tour", joinColumns = { @JoinColumn(name = "tour_id") }, inverseJoinColumns = {
			@JoinColumn(name = "attraction_id") })
	private Set<Attraction> attractions = new HashSet<>();

	@OneToMany(mappedBy = "tour")
	private Set<Rating> ratings;


	public void generateSummary() {

		Attraction previous= null;
		for (Iterator<Attraction> it = attractions.iterator(); it.hasNext();) {
			Attraction attraction = it.next();
			if(previous!=null) {
				distance+=distance(attraction.getLocation(),previous.getLocation());
			}
			duration+= Optional.ofNullable(attraction.getDuration()).orElse(1800L);
			cost+=Optional.ofNullable(attraction.getCost()).orElse(0.0);
			Set<AttractionCategory> categories = attraction.getAttractionType().getCategories();
			for(Iterator<AttractionCategory>catsIt=categories.iterator();catsIt.hasNext();){
				AttractionCategory attractionCategory = catsIt.next();
				switch (attractionCategory.getId().intValue()){
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
			previous=attraction;
		}
	}

	private double distance(Location a1,Location a2){
		return 0.0;
	}

	private double distance(
			double x1,
			double y1,
			double x2,
			double y2) {

		double ac = Math.abs(y2 - y1);
		double cb = Math.abs(x2 - x1);

		return Math.hypot(ac, cb);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}

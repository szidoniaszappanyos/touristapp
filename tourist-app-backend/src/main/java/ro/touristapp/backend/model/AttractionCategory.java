package ro.touristapp.backend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class AttractionCategory {

	@Id
	private Long id;

	@ManyToMany
	@JoinTable(name = "attraction_type_category", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id"))
	private Set<AttractionType> attractionType;

	private String category;

	public Set<AttractionType> getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(Set<AttractionType> attractionType) {
		this.attractionType = attractionType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

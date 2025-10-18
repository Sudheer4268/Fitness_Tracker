package fitness.models;


import fitness.helper.EnumCollections.Goal;
import fitness.helper.EnumCollections.Levels;
import fitness.helper.EnumCollections.Types;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="fitnessgoal")
public class FitnessGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int duration;
	private Double cost;
	
	@Enumerated(EnumType.STRING)
	private Levels level;
	
	@Enumerated(EnumType.STRING)
	private Types type;
	
	@Enumerated(EnumType.STRING)
	private Goal goal;
	
	private String imageUrl;
	
	public FitnessGoal() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Levels getLeve() {
		return level;
	}

	public void setLeve(Levels leve) {
		this.level = leve;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public FitnessGoal(Long id, String title, int duration, Double cost, Levels leve, Types type, Goal goal,
			String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.cost = cost;
		this.level = leve;
		this.type = type;
		this.goal = goal;
		this.imageUrl = imageUrl;
	}


	
}

package la.loaplanner.LoaPlanner.model.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Contents")
public class Contents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String contentName;
	String minILevel;
	int capacity;
	int phases;

	@Column(nullable = true)
	String difficulty;


}

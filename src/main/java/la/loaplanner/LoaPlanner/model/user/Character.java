package la.loaplanner.LoaPlanner.model.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Characters")
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String characterName;
	private String characterILV;

	private String isRep;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}

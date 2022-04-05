package la.loaplanner.LoaPlanner.model.raid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Raids")
public class Raid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	// 다대일
	Long bossId;


}

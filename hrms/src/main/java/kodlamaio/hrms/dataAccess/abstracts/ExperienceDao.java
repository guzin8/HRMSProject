package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.School;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
	
	List<Experience> findAllByOrderByDateDesc();

}

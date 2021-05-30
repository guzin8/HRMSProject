package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Advertisement;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer>{
	
	List<Advertisement> getByStatusTrue();
	List<Advertisement> findAllByOrderByCreatedDateAsc();
	List<Advertisement> getByEmployer_CompanyName(String companyName);
	Advertisement getById(int id);

}

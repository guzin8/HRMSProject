package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Advertisement;
import kodlamaio.hrms.entities.dtos.AdvertisementDto;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer>{
	
	List<Advertisement> getByStatusTrue();
	List<Advertisement> findAllByOrderByCreatedDateAsc();
	List<Advertisement> getByEmployer_CompanyName(String companyName);
	Advertisement getById(int id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.AdvertisementDto" + 
	"(e.id, e.companyName, a.numberOfHires, a.createdDate, a.deadline)" + 
    "From Employer e Inner Join e.advertisements a")
	List<AdvertisementDto> getAdvertisementDetails();

}

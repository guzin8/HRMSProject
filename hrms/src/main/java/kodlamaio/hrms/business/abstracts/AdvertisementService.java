package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Advertisement;
import kodlamaio.hrms.entities.dtos.AdvertisementDto;

public interface AdvertisementService {
	
	DataResult<List<Advertisement>> getByStatusTrue();
	DataResult<List<Advertisement>> findAllByOrderByCreatedDateAsc();
	DataResult<List<Advertisement>> getByEmployer_CompanyName(String companyName);
	Result add(Advertisement advertisement);
	Result delete(int advertisementId);
	DataResult<List<AdvertisementDto>> getAdvertisementDetails();

}

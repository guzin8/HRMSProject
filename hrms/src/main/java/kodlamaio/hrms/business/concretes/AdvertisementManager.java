package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AdvertisementDao;
import kodlamaio.hrms.entities.concretes.Advertisement;
import kodlamaio.hrms.entities.dtos.AdvertisementDto;

@Service
public class AdvertisementManager implements AdvertisementService{
	
	private AdvertisementDao advertisementDao;
	
	@Autowired
	public AdvertisementManager(AdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}


	@Override
	public DataResult<List<Advertisement>> getByStatusTrue() {
		
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByStatusTrue(),"İlanlar listelendi.");
	}

	@Override
	public Result add(Advertisement advertisement) {
		this.advertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı başarıyla eklendi.");
	}

	@Override
	public DataResult<List<Advertisement>> findAllByOrderByCreatedDateAsc() {
		
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findAllByOrderByCreatedDateAsc(),"İlanlar listelendi.");
	}


	@Override
	public DataResult<List<Advertisement>> getByEmployer_CompanyName(String companyName) {

		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByEmployer_CompanyName(companyName),"Şirketin ilanları listelendi.");
	}


	@Override
	public Result delete(int advertisementId) {
		
	    this.advertisementDao.getById(advertisementId).setStatus(false);
	    this.advertisementDao.save(this.advertisementDao.getById(advertisementId));
		return new SuccessResult("İş ilanı silindi.");
	}


	@Override
	public DataResult<List<AdvertisementDto>> getAdvertisementDetails() {
		
		return new SuccessDataResult<List<AdvertisementDto>>(this.advertisementDao.getAdvertisementDetails(),"İlanlar listelendi.");
	}
	

}

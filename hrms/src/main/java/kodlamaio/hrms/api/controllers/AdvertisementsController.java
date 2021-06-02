package kodlamaio.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Advertisement;
import kodlamaio.hrms.entities.dtos.AdvertisementDto;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementsController {
	
	private AdvertisementService advertisementService;
	
	@Autowired
	public AdvertisementsController(AdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}
	
	
	@GetMapping("/getByStatusTrue")
	public DataResult<List<Advertisement>> getByStatusTrue(){
		
		return this.advertisementService.getByStatusTrue();
	}
	
	@GetMapping("/getByStatusTrueAndorderByCreatedDateAsc")
	public DataResult<List<Advertisement>> getByStatusTrueAndorderByCreatedDateAsc(){
		
		return this.advertisementService.findAllByOrderByCreatedDateAsc();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Advertisement advertisement){
		
		return this.advertisementService.add(advertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam  int advertisementId){
		
		return this.advertisementService.delete(advertisementId);
	}
	
	@GetMapping("/getByEmployer_CompanyName")
	public DataResult<List<Advertisement>> getByEmployer_CompanyName(@RequestParam String companyName){
		
		return this.advertisementService.getByEmployer_CompanyName(companyName);
	}
	
	@GetMapping("/getAdvertisementDetails")
	public DataResult<List<AdvertisementDto>> getAdvertisementDetails(){
		
		return this.advertisementService.getAdvertisementDetails();
	}
	

}

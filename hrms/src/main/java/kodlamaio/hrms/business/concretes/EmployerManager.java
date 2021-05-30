package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
    
	private EmployerDao employerDao;
	private UserDao userDao;
	private EmailValidationService eMailValidationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, EmailValidationService eMailValidationService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.eMailValidationService = eMailValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		
		if(this.checkEmail(employer.getUser().getEmail())){
			
			if(this.eMailValidationService.getClick()){
				this.employerDao.save(employer);
				return new SuccessResult("İş veren eklendi.");
			}
			
		}
		
		return new ErrorResult("Ekleme başarısız.");
	}
	
	public boolean checkEmail(String eMail) {
		 
		if(this.userDao.getByEmail(eMail).isEmpty()) {
			return true;
		}
		else {
			System.out.println("Email adresi mevcut. Yeni bir email adresi giriniz.");
			return false;
		}
	}

}

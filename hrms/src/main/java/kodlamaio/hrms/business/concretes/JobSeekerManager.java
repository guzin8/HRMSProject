package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.MernisService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService {
	
	private EmailValidationService emailValidationService;
	private MernisService mernisService;
	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;

	@Autowired
	public JobSeekerManager(EmailValidationService emailValidationService, MernisService mernisService, UserDao userDao, JobSeekerDao jobSeekerDao) {
		super();
		this.emailValidationService = emailValidationService;
		this.mernisService = mernisService;
		this.userDao = userDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
	
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
	
		if(this.mernisService.isValidate(jobSeeker.getIdentityNumber()) == true && this.checkEmail(jobSeeker.getUser().getEmail()) == true && this.checkıdentityNumber(jobSeeker.getIdentityNumber()) == true){
			
			if(this.emailValidationService.getClick()) {
				this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Sisteme kayıt başarılı.");
			}
	}
		
		return new ErrorResult("Sisteme kayıt başarısız.");
	
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
	
	public boolean checkıdentityNumber(String identityNumber) {
		if(this.jobSeekerDao.getByIdentityNumber(identityNumber).isEmpty()) {
			return true;
		}
		
		else {
			System.out.println("Kimlik numarası mevcut. Yeni bir kimlik numarası giriniz.");
			return false;
		}
			
	}

}

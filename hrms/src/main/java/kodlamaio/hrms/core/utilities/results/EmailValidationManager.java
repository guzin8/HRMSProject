package kodlamaio.hrms.core.utilities.results;

import org.springframework.stereotype.Service;

@Service
public class EmailValidationManager implements EmailValidationService {

	@Override
	public void senToEmail() {
		System.out.println("Email gönderildi.");
		
	}

	@Override
	public boolean getClick() {
		return true;
	}

}

package kodlamaio.hrms.core.utilities.results;

import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService {

	@Override
	public boolean isValidate(String identityNumber) {
		
		if(identityNumber.length() > 11) {
			
			return true;
		}
		
		return false;
	}

}

package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>("Kullanıcılar listelendi.");
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		
		return new SuccessDataResult<List<User>>(this.userDao.getByEmail(email));
	}

}

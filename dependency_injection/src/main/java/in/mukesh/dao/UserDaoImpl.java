package in.mukesh.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements IUserDao {

	@Override
	public boolean saveUser(String name, String email, String pwd) {
		
		System.out.println("Saved in Database");
		return true;
	}

}

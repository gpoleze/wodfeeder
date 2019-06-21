package com.gabrielpf.wodfeeder.dao;

import com.gabrielpf.wodfeeder.model.auth.User;
import com.gabrielpf.wodfeeder.repo.UserRepo;
import com.gabrielpf.wodfeeder.vo.SignUpUserVO;
import com.gabrielpf.wodfeeder.vo.UserInVO;
import com.gabrielpf.wodfeeder.vo.UserOutVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDao {

	protected static final Logger log = LoggerFactory.getLogger(UserDao.class.getName());

	private final UserRepo repo;

	@Autowired
	public UserDao(UserRepo repo) {this.repo = repo;}

	private String hash(String s) {
		String salt = BCrypt.gensalt(13);
		return BCrypt.hashpw(s, salt);
	}

	private UserOutVO saveUser(User userIn) {
		log.info("Persisting user " + userIn.getUsername());
		userIn.setPassword(hash(userIn.getPassword()));
		var userOut = repo.save(userIn);
		return new UserOutVO(userOut);
	}

	public UserOutVO saveUser(SignUpUserVO signUpUserVO) {
		Optional<User> user = repo.findByUsername(signUpUserVO.getUsername());

		if (user.isPresent()) {
			log.info("User " + signUpUserVO.getUsername() + " already present in the database. Returning it.");
			return new UserOutVO(user.get());
		}

		var userIn = new User(signUpUserVO);

		return saveUser(userIn);
	}

	public UserOutVO findByUserInVo(UserInVO userInVO) {
		return repo
				.findByUsername(userInVO.getUsername())
				.map(UserOutVO::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with the username " + userInVO.getUsername()));
	}
}

package com.gabrielpf.wodfeeder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;
import com.gabrielpf.wodfeeder.model.auth.User;
import com.gabrielpf.wodfeeder.repo.AuthGroupRepo;
import com.gabrielpf.wodfeeder.repo.AuthUserGroupRepo;
import com.gabrielpf.wodfeeder.repo.UserRepo;
import com.gabrielpf.wodfeeder.vo.UserVO;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthUserGroupRepo authUserGroupRepo;

    @Autowired
    private AuthGroupRepo authGroupRepo;

    @Transactional
    public UserVO save(User user) {
        final var savedUser = userRepo.save(hashPassword(user));

        final var authGroup = authGroupRepo.findByName(AuthGroupEnum.COMMON.getName())
                .orElseThrow(() -> new RuntimeException("Somehow the database did not find the entry for the regular user AuthGroup"));

        final var authUserGroup = new AuthUserGroup(savedUser, authGroup);

        authUserGroupRepo.save(authUserGroup);

        return new UserVO(savedUser);
    }

    public boolean hasUser(User user) {
        return userRepo.findByUsername(user.getUsername()).isPresent();
    }

    private User hashPassword(User user) {
        final var hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        return user.setPassword(hashpw);
    }
}

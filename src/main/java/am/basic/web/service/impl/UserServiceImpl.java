package am.basic.web.service.impl;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepositoryIMPL;

    @Override
    public User getByUsername(String username) throws SQLException {
        return userRepositoryIMPL.getByUsername( username );
    }

    @Override
    public UserRepository getUserRepository() {
        return userRepositoryIMPL;
    }
}

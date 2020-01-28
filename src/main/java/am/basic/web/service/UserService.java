package am.basic.web.service;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;

import java.sql.SQLException;

public interface UserService {
    User getByUsername(String username) throws SQLException;

    UserRepository getUserRepository();
}

package am.basic.web.repository;

import am.basic.web.model.User;

import java.sql.SQLException;

public interface UserRepository {
    User getById(long id) throws SQLException;

    void add(User user) throws SQLException;

    void Delete(Long id) throws SQLException;

    void Update(User user) throws SQLException;

    User getByUsernamePassword(String username, String password) throws SQLException;

    User getByUsername(String username) throws SQLException;
}

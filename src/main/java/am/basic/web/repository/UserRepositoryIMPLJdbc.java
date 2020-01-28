package am.basic.web.repository;


import am.basic.web.model.User;
import am.basic.web.util.Datasource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryIMPLJdbc implements UserRepository {
    @Override
    public User getById(long id) throws SQLException {
        User user = null;
        Connection con = Datasource.getConnection();
        PreparedStatement pst = con.prepareStatement( "SELECT * FROM user WHERE id = ?" );
        pst.setLong( 1, id );
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId( rs.getLong( 1 ) );
            user.setAge( rs.getInt( 4 ) );
            user.setName( rs.getString( 5 ) );
            user.setUsername( rs.getString( 2 ) );
            user.setSurname( rs.getString( 3 ) );
            user.setPassword( rs.getString( 6 ) );
            user.setCode( rs.getString( 7 ) );
        }
        return user;
    }

    @Override
    public void add(User user) throws SQLException {
        Connection con1 = Datasource.getConnection();
        PreparedStatement pst = con1.prepareStatement( "INSERT INTO user VALUES(?,?,?,?,?,?,?)" );
        pst.setLong( 1, 0 );
        pst.setString( 2, user.getUsername() );
        pst.setString( 3, user.getSurname() );
        pst.setInt( 4, user.getAge() );
        pst.setString( 5, user.getName() );
        pst.setString( 6, user.getPassword() );
        pst.setString( 7, user.getCode() );
        pst.execute();
    }

    @Override
    public void Delete(Long id) throws SQLException {
        Connection con1 = Datasource.getConnection();
        PreparedStatement pst = con1.prepareStatement( " DELETE FROM user WHERE id = ?" );
        pst.setLong( 1, id );
        pst.executeUpdate();
    }

    @Override
    public void Update(User user) throws SQLException {
        Connection con1 = Datasource.getConnection();
        PreparedStatement pst = con1.prepareStatement( " UPDATE user Set username = ?, surname = ?, age = ?, name = ?, password=?, code = ? WHERE id = ?" );
        pst.setLong( 7, user.getId() );
        pst.setString( 1, user.getUsername() );
        pst.setString( 2, user.getSurname() );
        pst.setInt( 3, user.getAge() );
        pst.setString( 4, user.getName() );
        pst.setString( 5, user.getPassword() );
        pst.setString( 6, user.getCode() );
        pst.execute();
    }

    @Override
    public User getByUsernamePassword(String username, String password) throws SQLException {
        User user = null;
        Connection con = Datasource.getConnection();
        PreparedStatement pst = con.prepareStatement( "SELECT * FROM user WHERE username = ? AND password = ?" );
        pst.setString( 1, username );
        pst.setString( 2, password );
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId( rs.getLong( 1 ) );
            user.setAge( rs.getInt( 4 ) );
            user.setName( rs.getString( 5 ) );
            user.setUsername( rs.getString( 2 ) );
            user.setSurname( rs.getString( 3 ) );
            user.setPassword( rs.getString( 6 ) );
            user.setCode( rs.getString( 7 ) );
        }
        return user;
    }

    @Override
    public User getByUsername(String username) throws SQLException {
        User user = null;
        Connection con = Datasource.getConnection();
        PreparedStatement pst = con.prepareStatement( "SELECT * FROM user WHERE username = ?" );
        pst.setString( 1, username );
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId( rs.getLong( 1 ) );
            user.setAge( rs.getInt( 4 ) );
            user.setName( rs.getString( 5 ) );
            user.setUsername( rs.getString( 2 ) );
            user.setSurname( rs.getString( 3 ) );
            user.setPassword( rs.getString( 6 ) );
            user.setCode( rs.getString( 7 ) );
        }
        return user;
    }


}

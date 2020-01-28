package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.Datasource;
import am.basic.web.util.Hybernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Scope("Singleton")
public class UserRepositoryIMPL implements UserRepository {
    @PostConstruct
    public void init() {
        System.out.println( "UserRepositoryImpl" );
    }

    @Autowired
    private SessionFactory sessionFactory;

    public User getById(long id) {
        Session session = sessionFactory.openSession();
        return session.get( User.class, id );
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save( user );
    }

    @Override
    public void Delete(Long id) throws SQLException {

    }
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void Delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete( user );
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Throwable.class, noRollbackFor = RuntimeException.class)
    public void Update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update( user );
    }

    public User getByUsernamePassword(String username, String password) {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery( "SELECT * FROM user WHERE name = ? AND password = ?" );
        query.setParameter( 1, username );
        query.setParameter( 2, password );
        return query.uniqueResult();
    }
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery( "SELECT * FROM user WHERE name = ?", User.class );
        query.setParameter( 1, username );
        return query.uniqueResult();
    }

    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
    }

    @PreDestroy
    public void destroy() {
        System.out.println( "destroy" );
    }
}

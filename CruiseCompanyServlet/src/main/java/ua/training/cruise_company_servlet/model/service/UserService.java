package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import ua.training.cruise_company_servlet.model.dao.DBConnectionException;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.UserDao;
import ua.training.cruise_company_servlet.model.entity.User;
import ua.training.cruise_company_servlet.model.entity.UserRole;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private UserDao userDao;

    public UserService() throws SQLException {
        try {
            this.userDao = DaoFactory.getInstance().createUserDao();
        } catch (DBConnectionException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public UserRole checkUserOnLogin(String login, String password) throws SQLException, UserNotFoundException {
        Optional<User> userOptional;
        try {
            userOptional = userDao.findByEmail(login);
        } catch (SQLException e) {
            logger.error("SQL exception from userDao.findByEmail");
            logger.debug( e.getMessage());
            throw e;
        }

        if( ! userOptional.isPresent()){
            logger.info("login '" + login + "' not found in the DB");
            throw new UserNotFoundException("login not found in the DB");
        }

        User userFromDB = userOptional.get();
        logger.info( userFromDB );

        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw(password, userFromDB.getPassword())){
            logger.info("password is correct");
            return userFromDB.getRole();
        }
        else {
            logger.error("entered password does not match the one from the DB");
            throw new UserNotFoundException("incorrect password");
        }
    }
}

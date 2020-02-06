package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.UserDao;
import ua.training.cruise_company_servlet.model.entity.User;
import ua.training.cruise_company_servlet.model.enums.UserRole;

import java.util.List;
import java.util.Optional;

public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public UserRole checkUserOnLogin(String login, String password) throws UserNotFoundException {

        Optional<User> userOptional;
        try(UserDao userDao = daoFactory.createUserDao()) {
            userOptional = userDao.findByEmail(login);
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

    public List<User> getAllUsers() {
        try(UserDao userDao = daoFactory.createUserDao()) {
            return userDao.findAll();
        }
    }

    public boolean updateUserRole(String email, UserRole newRole){
        try {
            try(UserDao userDao = daoFactory.createUserDao()) {
                return userDao.updateUserRole(email, newRole);
            }
        } catch(DAOLevelException ex){
            return false;
        }
    }
}

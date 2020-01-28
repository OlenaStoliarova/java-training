package ua.training.cruise_company_servlet.model.dao;

import ua.training.cruise_company_servlet.model.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByEmail(String email) throws SQLException;
}

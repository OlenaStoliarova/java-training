package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.UserDao;
import ua.training.cruise_company_servlet.model.entity.User;
import ua.training.cruise_company_servlet.model.entity.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private static final Logger logger = LogManager.getLogger(JDBCUserDao.class);

    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email){
        String selectUserByEmail = "SELECT * FROM users WHERE email=\"" + email + "\"";

        ResultSet resultSet = executeMyQuery(selectUserByEmail);
        try{
            if (resultSet.next()) {
                return Optional.of(extractFromResultSet(resultSet));
            }
            return Optional.empty();

        } catch(SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public List<User> findAll(){
        String selectAllUsers = "SELECT * FROM users";
        List<User> resultList = new ArrayList<>();

        ResultSet resultSet = executeMyQuery(selectAllUsers);
        try {
            while (resultSet.next()) {
                User user = extractFromResultSet(resultSet);
                resultList.add(user);
            }
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }

    private ResultSet executeMyQuery(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sqlQuery);
        }catch(SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    private User extractFromResultSet(ResultSet rs) throws SQLException {
        User result = new User();

        result.setId( rs.getLong("id") );
        result.setEmail( rs.getString("email") );
        result.setPassword( rs.getString("password"));
        result.setFirstNameEn( rs.getString("first_name_en") );
        result.setLastNameEn( rs.getString("last_name_en") );
        result.setFirstNameNative( rs.getString("first_name_native") );
        result.setLastNameNative( rs.getString("last_name_native") );
        result.setRole( UserRole.valueOf( rs.getString("role") ));

        return result;
    }
}

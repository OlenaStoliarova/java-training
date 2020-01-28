package ua.training.cruise_company_servlet.model.dao.implementation;

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
    public Optional<User> findByEmail(String email) {
        String selectUserByEmail = "SELECT * FROM users WHERE email=\"" + email + "\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectUserByEmail);
            if (resultSet.next()) {
                return Optional.of( extractFromResultSet(resultSet) );
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        String selectAllUsers = "SELECT * FROM users";
        List<User> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectAllUsers);
            while (resultSet.next()) {
                User user = extractFromResultSet(resultSet);
                resultList.add(user);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
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

    static User extractFromResultSet(ResultSet rs) throws SQLException {
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

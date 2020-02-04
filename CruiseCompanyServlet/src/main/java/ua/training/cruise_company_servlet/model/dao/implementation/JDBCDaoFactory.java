package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.SeaportDao;
import ua.training.cruise_company_servlet.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private static final Logger logger = LogManager.getLogger(JDBCDaoFactory.class);

    private final DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public SeaportDao createSeaportDao() {
        return new JDBCSeaportDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        }
        catch (SQLException ex) {
            logger.error("Failed to get connection to DB ");
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }
}

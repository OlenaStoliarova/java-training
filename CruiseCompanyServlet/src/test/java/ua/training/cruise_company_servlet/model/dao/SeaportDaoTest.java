package ua.training.cruise_company_servlet.model.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.cruise_company_servlet.model.dao.implementation.JDBCSeaportDao;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class SeaportDaoTest {
    private static final Logger logger = LogManager.getLogger(SeaportDaoTest.class);

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cruise_company";
    private static final String DB_USER = "elena";
    private static final String DB_PASSWORD = "reload12";

    private static Connection connection;
    private static SeaportDao seaportDao;

    @BeforeClass
    public static void setup(){
        try {
            Class.forName(JDBC_DRIVER);
            connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            seaportDao = new JDBCSeaportDao(connection);
        } catch (Exception e){
            logger.error("Failed to setup test environment");
            System.exit(-1);
       }
    }

    @Test
    public void testCreateSeaport() throws SQLException {
        Seaport seaport = new Seaport();
        seaport.setNameEn("Test port");
        seaport.setNameUkr("Тестовий порт");
        seaport.setCountryEn("Imagineland");
        seaport.setCountryUkr("Уявляндія");

        try {
            connection.setAutoCommit(false);

            Assert.assertFalse( seaportDao.findByNameEn("Test port").isPresent());

            Assert.assertTrue(seaportDao.create(seaport)); //first insert should be successful
            Optional<Seaport> insertedSeaport = seaportDao.findByNameEn("Test port");
            Assert.assertTrue( insertedSeaport.isPresent());
            Assert.assertNotNull( insertedSeaport.get().getId());

            Assert.assertFalse(seaportDao.create(seaport)); //second attempt should break unique constraint

        } finally {
            connection.rollback();
        }
    }
}

package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cruise_company";
    private static final String DB_USER = "elena";
    private static final String DB_PASSWORD = "reload12";

    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName(JDBC_DRIVER);
                    ds.setUrl(DB_URL);
                    ds.setUsername(DB_USER);
                    ds.setPassword(DB_PASSWORD);
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);

                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}

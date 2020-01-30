package ua.training.cruise_company_servlet.model.dao;

public class DataSourceConnectionException extends Exception {
    public DataSourceConnectionException(Throwable cause) {
        super(cause);
    }
    public DataSourceConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

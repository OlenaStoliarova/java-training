package ua.training.cruise_company_servlet.controller.constant;

public interface AttributesConstants {
    String USER_ROLE = "user_role";
    String USER_NAME = "user_name";
    String LOGGED_USERS = "logged_users";

    String LOGIN = "username";
    String PASSWORD = "password";
    String ERROR_UNKNOWN_USER = "unknown_user";
    String ERROR_ALREADY_LOGGED_IN = "already_loggedin";

    String PORT_NAME_EN = "nameEn";
    String PORT_NAME_UKR = "nameUkr";
    String PORT_COUNTRY_EN = "countryEn";
    String PORT_COUNTRY_UKR = "countryUkr";


    String ALL_SEAPORTS = "all_seaports";
    String EXCURSION_OBJECT = "excursion";
    String EXCURSION_NAME_EN = "nameEn";
    String EXCURSION_NAME_UKR = "nameUkr";
    String EXCURSION_DESCRIPTION_EN = "descriptionEn";
    String EXCURSION_DESCRIPTION_UKR = "descriptionUkr";
    String EXCURSION_DURATION = "approximateDurationHr";
    String EXCURSION_PRICE = "priceUSD";
    String EXCURSION_PORT = "seaportId";
    String ERROR_VALIDATION = "validation_errors";
    String ERROR_NO_PORT_FOUND = "no_port_found";
    String ERROR_NON_UNIQUE = "non_unique";
    String EXCURSION_ID = "excursionId";
    String ERROR_NO_EXCURSION_FOUND = "no_excursion_found";
}

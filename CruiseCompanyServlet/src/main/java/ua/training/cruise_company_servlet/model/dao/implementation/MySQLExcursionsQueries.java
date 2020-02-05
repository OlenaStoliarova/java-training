package ua.training.cruise_company_servlet.model.dao.implementation;

public interface MySQLExcursionsQueries {
    String SELECT_ALL_EXCURSIONS = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_en AS port_name_en, " +
            "s.name_ukr AS port_name_ukr, " +
            "s.country_en AS port_country_en, " +
            "s.country_ukr AS port_country_ukr " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id";

    String SELECT_ALL_EXCURSIONS_FOR_TRAVEL_AGENT_DTO_EN = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_en AS port_name, " +
            "s.country_en AS port_country " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id";

    String SELECT_ALL_EXCURSIONS_FOR_TRAVEL_AGENT_DTO_UKR = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_ukr AS port_name, " +
            "s.country_ukr AS port_country " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id";

    String SELECT_ALL_EXCURSIONS_IN_SEAPORT_FOR_TRAVEL_AGENT_DTO_EN = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_en AS port_name, " +
            "s.country_en AS port_country " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id " +
            "WHERE e.seaport_id = ?";

    String SELECT_ALL_EXCURSIONS_IN_SEAPORT_FOR_TRAVEL_AGENT_DTO_UKR = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_ukr AS port_name, " +
            "s.country_ukr AS port_country " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id " +
            "WHERE e.seaport_id = ?";
}

package ua.training.cruise_company_servlet.model.dao.mapper;

import ua.training.cruise_company_servlet.model.dto.SeaportDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeaportDTOMapper implements ObjectMapper<SeaportDTO> {
    @Override
    public SeaportDTO extractFromResultSet(ResultSet rs) throws SQLException {
        return extractFromResultSet(rs, "");
    }

    public SeaportDTO extractFromResultSet(ResultSet rs, String prefix) throws SQLException {
        SeaportDTO result = new SeaportDTO();

        result.setId( rs.getLong(prefix + "id") );
        result.setName( rs.getString(prefix + "name") );
        result.setCountry( rs.getString(prefix + "country"));

        return result;
    }
}

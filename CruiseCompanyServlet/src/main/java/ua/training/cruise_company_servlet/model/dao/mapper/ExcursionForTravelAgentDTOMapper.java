package ua.training.cruise_company_servlet.model.dao.mapper;

import ua.training.cruise_company_servlet.model.dto.ExcursionForTravelAgentDTO;
import ua.training.cruise_company_servlet.model.utilities.LocalizationHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcursionForTravelAgentDTOMapper implements ObjectMapper<ExcursionForTravelAgentDTO> {
    @Override
    public ExcursionForTravelAgentDTO extractFromResultSet(ResultSet rs) throws SQLException {
        return extractFromResultSet(rs, "");
    }

    public ExcursionForTravelAgentDTO extractFromResultSet(ResultSet rs, String prefix) throws SQLException {
        ExcursionForTravelAgentDTO result = new ExcursionForTravelAgentDTO();

        result.setId( rs.getLong(prefix + "id") );
        result.setNameEn( rs.getString(prefix + "name_en") );
        result.setNameUkr( rs.getString(prefix + "name_ukr") );
        result.setDescriptionEn(rs.getString(prefix + "description_en"));
        result.setDescriptionUkr(rs.getString(prefix + "description_ukr"));
        result.setApproximateDurationHr(rs.getLong(prefix + "approximate_duration_hr"));
        result.setPrice( LocalizationHelper.getPriceInLocaleCurrency( rs.getBigDecimal(prefix + "priceusd")));

        return result;
    }
}

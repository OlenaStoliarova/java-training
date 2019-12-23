package ua.training.task01cut2.entity;

import java.math.BigDecimal;

public abstract class RailcarImpl implements ua.training.task01cut2.interfaces.Railcar {
    /** idNumber unique  number of a railway carriage given to it by its manufacturer */
    protected String idNumber;
    protected BigDecimal tareWeight;

    @Override
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setTareWeight(BigDecimal tareWeight) {
        this.tareWeight = tareWeight;
    }
}

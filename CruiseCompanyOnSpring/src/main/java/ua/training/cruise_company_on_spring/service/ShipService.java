package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.entity.Ship;
import ua.training.cruise_company_on_spring.repository.ShipRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> allShips(){ return shipRepository.findAllByOrderByName();}

    public Ship getShipById(Long id) throws NoEntityFoundException {
        return shipRepository.findById(id)
                            .orElseThrow(() -> new NoEntityFoundException("There is no ship with provided id (" + id + ")"));
    }

    public boolean saveShip(Ship ship){
        if ( ship.getId() == null) {
            //adding new ship
            Optional<Ship> shipFromDB = shipRepository.findByName(ship.getName());
            if (shipFromDB.isPresent()) {
                return false;
            }
            shipRepository.save(ship);
            return true;
        } else{
            //editing existing ship
            Optional<Ship> shipFromDB = shipRepository.findById(ship.getId());
            if (shipFromDB.isPresent()) {
                shipRepository.save(ship);
                return true;
            }
            return false;
        }
    }
}

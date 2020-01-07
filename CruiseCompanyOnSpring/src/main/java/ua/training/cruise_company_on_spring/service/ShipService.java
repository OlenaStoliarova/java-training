package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.dto.ShipDTO;
import ua.training.cruise_company_on_spring.entity.Extra;
import ua.training.cruise_company_on_spring.entity.Ship;
import ua.training.cruise_company_on_spring.repository.ShipRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<ShipDTO> allShips(){
        return shipRepository.findAllByOrderByName().stream().map(ShipService::shipToDTO).collect(Collectors.toList());}

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

    static ShipDTO shipToDTO(Ship ship){
        return ShipDTO.builder()
                .id(ship.getId())
                .name(ship.getName())
                .firstClassCapacity(ship.getFirstClassCapacity())
                .secondClassCapacity(ship.getSecondClassCapacity())
                .thirdClassCapacity(ship.getThirdClassCapacity())
                .totalCapacity(ship.getFirstClassCapacity() + ship.getSecondClassCapacity() + ship.getThirdClassCapacity())
                .route(RouteService.routeToDTO(ship.getRoute()))
                .extras(ship.getExtras()
                        .stream().sorted( Comparator.comparing(Extra::getNameEn))
                        .collect(Collectors.toList()))
                .build();
    }
}
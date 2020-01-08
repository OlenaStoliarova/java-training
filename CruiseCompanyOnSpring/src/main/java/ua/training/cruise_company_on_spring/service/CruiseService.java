package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.entity.Cruise;
import ua.training.cruise_company_on_spring.repository.CruiseRepository;

import java.util.Optional;

@Service
public class CruiseService {
    @Autowired
    private CruiseRepository cruiseRepository;

    public boolean saveCruise(Cruise cruise){
        if ( cruise.getId() == null) {
            //adding new cruise
            //check if ship is available on selected dates
            if( cruiseRepository.findCollisionOnAddNew( cruise.getShip().getId(), cruise.getStartingDate(), cruise.getFinishingDate()).isEmpty()){
                cruiseRepository.save(cruise);
                return true;
            } else{
                // ? throw dates not available
                return false;
            }
        } else{
            //editing existing cruise
            Optional<Cruise> cruiseFromDB = cruiseRepository.findById(cruise.getId());
            if (cruiseFromDB.isPresent()) {
                cruiseRepository.save(cruise);
                return true;
            }
            return false;
        }
    }
}

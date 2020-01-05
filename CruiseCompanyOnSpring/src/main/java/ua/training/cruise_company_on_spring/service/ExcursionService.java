package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.entity.Excursion;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.repository.ExcursionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExcursionService {
    @Autowired
    private ExcursionRepository excursionRepository;

    public List<Excursion> allExcursions(){
        return excursionRepository.findAllByOrderBySeaportAsc();
    }

    public List<Excursion> allExcursionsInSeaport(Seaport seaport){
        return excursionRepository.findBySeaport(seaport);
    }

    public Excursion getExcursionById(String id){
        return excursionRepository.findById(new Long(id)).orElse(null);
    }

    public boolean saveExcursion(Excursion excursion) {
        if ( excursion.getId() == null) {
            //adding new excursion
            Optional<Excursion> excursionFromDB = excursionRepository.findByNameEnAndSeaport(excursion.getNameEn(), excursion.getSeaport());
            if (excursionFromDB.isPresent()) {
                return false;
            }
            excursionRepository.save(excursion);
            return true;
        } else{
            //editing existing excursion
            Optional<Excursion> excursionFromDB = excursionRepository.findById(excursion.getId());
            if (excursionFromDB.isPresent()) {
                excursionRepository.save(excursion);
                return true;
            }
            return false;
        }
    }
}

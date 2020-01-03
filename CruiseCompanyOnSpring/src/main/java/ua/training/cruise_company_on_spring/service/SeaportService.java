package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.repository.SeaportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeaportService {
    @Autowired
    SeaportRepository seaportRepository;

    public List<Seaport> allPorts() {
        return seaportRepository.findAllByOrderByNameEnAsc();
    }

    public boolean savePort(Seaport seaport) {
        Optional<Seaport> seaportFromDB = seaportRepository.findByNameEn(seaport.getNameEn());

        if ( seaportFromDB.isPresent()){
            return false;
        }

        seaportRepository.save(seaport);
        return true;
    }
}

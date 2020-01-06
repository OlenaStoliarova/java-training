package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.entity.Extra;
import ua.training.cruise_company_on_spring.repository.ExtraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraService {
    @Autowired
    private ExtraRepository extraRepository;

    public List<Extra> allExtras() { return extraRepository.findAll();}

    public Extra findExtraByNameEn(String nameEn) throws NoEntityFoundException {
        return extraRepository.findByNameEn(nameEn)
                .orElseThrow(() -> new NoEntityFoundException("There is no extra with provided name (" + nameEn + ")"));
    }

    public Extra findExtraById(Long id) throws NoEntityFoundException {
        return extraRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("There is no extra with provided id (" + id + ")"));
    }

    public boolean saveExtra(Extra extra) {
        if ( extra.getId() == null) {
            //adding new
            Optional<Extra> extraFromDB = extraRepository.findByNameEn(extra.getNameEn());
            if ( extraFromDB.isPresent()){
                return false;
            }
            extraRepository.save(extra);
            return true;
        } else {
            //editing existing
            Optional<Extra> extraFromDB = extraRepository.findById(extra.getId());
            if (extraFromDB.isPresent()) {
                extraRepository.save(extra);
                return true;
            }
            return false;
        }
    }
}

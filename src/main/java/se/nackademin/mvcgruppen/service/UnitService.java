package se.nackademin.mvcgruppen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.mvcgruppen.domain.Unit;
import se.nackademin.mvcgruppen.repository.UnitRepository;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public void saveUnit(Unit unit) {
        unitRepository.save(unit);
    }

    public List<Unit> getUnits(){
        return unitRepository.findAll();
    }
}

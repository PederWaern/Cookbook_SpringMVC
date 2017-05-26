package se.nackademin.mvcgruppen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.mvcgruppen.domain.Unit;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Integer> {

    List<Unit> findAll();


}

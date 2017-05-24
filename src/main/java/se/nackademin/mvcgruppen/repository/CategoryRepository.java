package se.nackademin.mvcgruppen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.mvcgruppen.domain.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findAll();
}

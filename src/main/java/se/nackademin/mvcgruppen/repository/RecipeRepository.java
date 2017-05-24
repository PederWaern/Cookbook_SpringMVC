package se.nackademin.mvcgruppen.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.mvcgruppen.domain.Recipe;
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}

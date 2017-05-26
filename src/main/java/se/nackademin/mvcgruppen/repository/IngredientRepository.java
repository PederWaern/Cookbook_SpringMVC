package se.nackademin.mvcgruppen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.mvcgruppen.domain.Ingredient;
import se.nackademin.mvcgruppen.domain.Recipe;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer>{

    List<Ingredient> findAll();
    Ingredient findByRecipe(Recipe recipe);
}

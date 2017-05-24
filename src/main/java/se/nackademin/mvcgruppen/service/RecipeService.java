package se.nackademin.mvcgruppen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.mvcgruppen.domain.Recipe;
import se.nackademin.mvcgruppen.repository.RecipeRepository;

@Service
public class RecipeService {

    private final RecipeRepository repo;

    @Autowired
    public RecipeService(RecipeRepository repo) {
        this.repo = repo;
    }

    public void saveRecipe(Recipe recipe) {

        repo.save(recipe);
    }
}

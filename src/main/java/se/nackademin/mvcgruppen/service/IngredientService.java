package se.nackademin.mvcgruppen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.mvcgruppen.domain.Ingredient;
import se.nackademin.mvcgruppen.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingRepository;

    @Autowired
    public IngredientService(IngredientRepository ingRepository) {
        this.ingRepository = ingRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingRepository.findAll();
    }

    public void saveIngredient(Ingredient newIngredient) {
        ingRepository.save(newIngredient);
    }
}

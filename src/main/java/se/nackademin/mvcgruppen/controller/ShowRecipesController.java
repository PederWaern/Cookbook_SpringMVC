package se.nackademin.mvcgruppen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.nackademin.mvcgruppen.domain.Recipe;
import se.nackademin.mvcgruppen.service.RecipeService;

import java.util.Arrays;
import java.util.List;

@Controller
public class ShowRecipesController {

    @Autowired
    private RecipeService recipeService;

    private List<Integer> portionValues = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    private Recipe oldRecipe;


    @GetMapping("/recipes")
    public String recipeDisplay(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    public String showRecipe(@PathVariable int id, Model model) {
        Recipe currentRecipe = recipeService.getRecipeById(id);
        oldRecipe = currentRecipe;
        model.addAttribute("recipe", currentRecipe);
        model.addAttribute("portionValues", portionValues);

        return "showrecipe";
    }
    @PostMapping("/recipes/changedPortion")
    public String portionChanged(@ModelAttribute Recipe recipe, Model model) {
        model.addAttribute("recipe",updatedRecipe(recipe.getPortion()));
        model.addAttribute("portionValues", portionValues);

        return "showrecipe";
    }

    private Recipe updatedRecipe(int newPortionValue) {
        Recipe updatedRecipe = oldRecipe;

        updatedRecipe.getIngredients().forEach
                (ingredient -> ingredient.setQuantity(ingredient.getQuantity() / updatedRecipe.getPortion()));
        updatedRecipe.getIngredients().forEach(
                ingredient -> ingredient.setQuantity(ingredient.getQuantity() * newPortionValue));

        updatedRecipe.setPortion(newPortionValue);

        return updatedRecipe;
    }
}
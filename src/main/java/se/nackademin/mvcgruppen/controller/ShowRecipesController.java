package se.nackademin.mvcgruppen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.nackademin.mvcgruppen.domain.Recipe;
import se.nackademin.mvcgruppen.service.RecipeService;

import java.util.Arrays;
import java.util.List;

@Controller
public class ShowRecipesController {

    @Autowired
    private RecipeService recipeService;

    private List<Integer> portionValues = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    private int currentPortions;


    @GetMapping("/recipes")
    public String recipeDisplay(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    public String showRecipe(@PathVariable Integer id, Model model) {

        Recipe currentRecipe = recipeService.getRecipeById(id);


        model.addAttribute("recipe", currentRecipe);
        model.addAttribute("portionValues", portionValues);

        System.out.println(portionValues);
        return "showrecipe";
    }
}

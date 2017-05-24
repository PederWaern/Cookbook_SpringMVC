package se.nackademin.mvcgruppen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.nackademin.mvcgruppen.service.RecipeService;
import se.nackademin.mvcgruppen.service.UploadService;

@Controller
public class ShowRecipesController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public String recipeForm(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }
}

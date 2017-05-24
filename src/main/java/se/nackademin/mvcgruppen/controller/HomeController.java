package se.nackademin.mvcgruppen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import se.nackademin.mvcgruppen.domain.Recipe;
import se.nackademin.mvcgruppen.service.RecipeService;
import se.nackademin.mvcgruppen.service.UploadService;

@Controller
public class HomeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UploadService uploadService;

    @GetMapping("/recipe")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "home";
    }


    @PostMapping("/recipe")
    public String recipeSubmit(@RequestParam(value = "file") MultipartFile image,
                               @ModelAttribute Recipe recipe) {

        recipe.setImgUrl(uploadService.cloudUpload(image));
        recipeService.saveRecipe(recipe);
        return "home";
    }

    @ModelAttribute("recipe")
    public Recipe getRecipe(){
        return new Recipe();
    }

}

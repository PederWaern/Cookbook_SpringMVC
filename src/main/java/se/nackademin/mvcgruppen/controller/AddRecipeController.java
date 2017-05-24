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
import se.nackademin.mvcgruppen.service.CategoryService;
import se.nackademin.mvcgruppen.service.RecipeService;
import se.nackademin.mvcgruppen.service.UploadService;

@Controller
public class AddRecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/addrecipe")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "addrecipe";
    }


    @PostMapping("/addrecipe")
    public String recipeSubmit(@RequestParam(value = "file") MultipartFile image,
                               @ModelAttribute Recipe recipe) {
        recipe.setImgUrl(uploadService.cloudUpload(image));
        recipeService.saveRecipe(recipe);
        return "addrecipe";
    }


}

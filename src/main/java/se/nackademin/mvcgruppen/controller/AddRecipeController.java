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
import se.nackademin.mvcgruppen.service.UnitService;
import se.nackademin.mvcgruppen.service.UploadService;

import java.util.Arrays;
import java.util.List;

@Controller
public class AddRecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UnitService unitService;

    private List<Integer> portionValues = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);

    @GetMapping("/addrecipe")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("units", unitService.getAllUnits());
        model.addAttribute("portions", portionValues);
        return "addrecipe";
    }


    @PostMapping("/addrecipe")
    public String recipeSubmit(@RequestParam(value = "file") MultipartFile image,
                               @ModelAttribute Recipe recipe) {
        recipe.setImgUrl(uploadService.cloudUpload(image));
        recipe.getIngredients().forEach(ing -> ing.setRecipe(recipe));
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }


}

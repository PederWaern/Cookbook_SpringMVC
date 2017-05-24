package se.nackademin.mvcgruppen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.nackademin.mvcgruppen.domain.Category;
import se.nackademin.mvcgruppen.domain.Recipe;
import se.nackademin.mvcgruppen.service.CategoryService;

@Controller
public class AddCategoryController {

    private final CategoryService categoryService;

    @Autowired
    public AddCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/addcategory")
    public String categoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/addcategory")
    public String categorySubmit(@ModelAttribute Category newCategory) {
        categoryService.saveCategory(newCategory);
        return "addcategory";
    }

}

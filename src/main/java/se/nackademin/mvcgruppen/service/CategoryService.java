package se.nackademin.mvcgruppen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.mvcgruppen.domain.Category;
import se.nackademin.mvcgruppen.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category newCategory){
        categoryRepository.save(newCategory);
    }

}

package se.nackademin.mvcgruppen.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "unit")
    private List<Ingredient> ingredients = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

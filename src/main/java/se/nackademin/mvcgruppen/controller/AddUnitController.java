package se.nackademin.mvcgruppen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.nackademin.mvcgruppen.domain.Unit;
import se.nackademin.mvcgruppen.service.UnitService;

@Controller
public class AddUnitController {

  @Autowired
  private UnitService unitService;

    @GetMapping("/addunit")
    public String unitForm(Model model) {
        model.addAttribute("unit", new Unit());
        return "addunit";
    }

    @PostMapping("/addunit")
    public String unitSubmit(@ModelAttribute Unit newUnit) {
        unitService.saveUnit(newUnit);
        return "addunit";
    }
}

package kacd.AnimalClinic.controller;

import kacd.AnimalClinic.dao.PetDao;
import kacd.AnimalClinic.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetController {

    @Autowired
    private PetDao petDao;

    @GetMapping("/pets/add")
    public String addPet() {
        return "pets/add";
    }

    @PostMapping("/pets/add")
    public String addPet(@ModelAttribute Pet pet) {
        petDao.save(pet);
        return "redirect:/pets/all";
    }

    @GetMapping("/pets/all")
    public String showPets(ModelMap modelMap) {
        modelMap.put("pets", petDao.findAll());
        return "pets/all";
    }

    @GetMapping("/pets/{id}")
    public String getPet(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("pet", petDao.findById(id).get());
        return "pets/show";
    }

    @PostMapping("/pets/update")
    public String petUpdate(@ModelAttribute Pet pet) {
        petDao.save(pet);
        return "redirect:/pets/all";
    }

}

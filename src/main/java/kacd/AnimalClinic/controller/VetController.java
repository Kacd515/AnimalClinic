package kacd.AnimalClinic.controller;

import kacd.AnimalClinic.dao.VetDao;
import kacd.AnimalClinic.models.Pet;
import kacd.AnimalClinic.models.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VetController {

    @Autowired
    private VetDao vetDao;

    @GetMapping("/")
    public String showMain() {
        return "main";
    }

    @GetMapping("/vets/add")
    public String addVet(){
        return "vets/add";
    }

    @PostMapping("/vets/add")
    public String addVet(@ModelAttribute Vet vet) {
        vetDao.save(vet);
        return "redirect:/vets/all";
    }

    @GetMapping("/vets/all")
    public String showVets(ModelMap modelMap) {
        modelMap.put("vets" ,vetDao.findAll());
        return "vets/all";
    }

    @GetMapping("/vets/{id}")
    public String getVet(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("vet", vetDao.findById(id).get());
        return "vets/show";
    }

    @PostMapping("/vets/update")
    public String vetUpdate(@ModelAttribute Vet vet) {
        vetDao.save(vet);
        return "redirect:/vets/all";
    }

    @GetMapping("/vets/{id}/remove")
    public String petRemove(@ModelAttribute Vet vet) {
        vetDao.delete(vet);
        return "redirect:/vets/all";
    }
}

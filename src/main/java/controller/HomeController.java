package controller;

import model.Produit;
import service.ProduitService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private ProduitService service = new ProduitService();

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("listeProduit", service.getAllProduits());
        return "produits";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Produit p) {
        service.addProduit(p);
        return "redirect:/index";
    }

    @RequestMapping("/deleteProduit")
    public String deleteProduit(@RequestParam Long id) {
        service.deleteProduit(id);
        return "redirect:/index";
    }

    @RequestMapping("/editProduit")
    public String editProduit(@RequestParam Long id, Model model) {
        Produit p = service.getProduit(id);
        model.addAttribute("produitEdit", p);
        model.addAttribute("listeProduit", service.getAllProduits());
        return "produits";
    }

    @RequestMapping("/updateProduit")
    public String updateProduit(Produit p) {
        service.updateProduit(p);
        return "redirect:/index";
    }
}
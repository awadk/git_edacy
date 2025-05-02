package admin_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import admin_user.model.Produit;
import admin_user.service.ProduitService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	
	@Autowired
	ProduitService service;
	
	@GetMapping("/liste")
	public String showPaginatedPage(@Param(value = "keyword") String keyword,
			Model model)
	{
		

		model.addAttribute("produits", service.listProduit());
		return "liste_produit";

	}
	
	@GetMapping("/nouveau")
	public String ajoutProduit(Produit produit) {
		return "new_produit";
	}
	
	@PostMapping("/new")
	public String newProduit(@Valid Produit produit, BindingResult result) {
		if(result.hasErrors()) {
			return "new_produit";
		}
		service.ajouter(produit);
		return "redirect:/produit/liste";
	}
	
	@GetMapping("/modifier/{id}")
	public String modifier(@PathVariable Long id, Model model) {
		Produit produit = service.getById(id);
		model.addAttribute("produit", produit);
		return "edit_produit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, @Valid Produit 
			produit, BindingResult result) {
		if(result.hasErrors()) {
			produit.setId(id);
			return "edit_produit";
		}
		service.ajouter(produit);
		
		return "redirect:/produit/liste";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable Long id) {
		Produit produit = service.getById(id);
		service.delete(produit);
		return "redirect:/produit/liste";
	}
}

package admin_user.service;

import java.util.List;

import admin_user.model.Produit;

public interface ProduitService {
	public Produit getById(Long Id);
	public List<Produit>listProduit();
	public void ajouter(Produit Produit);
	public void delete(Produit produit); 

}

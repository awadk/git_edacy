package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Produit;
import admin_user.repositories.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	ProduitRepository repo;
	@Override
	public Produit getById(Long Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id).get();
	}

	@Override
	public List<Produit> listProduit() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void ajouter(Produit produit) {
		// TODO Auto-generated method stub
		repo.save(produit);
	}

	@Override
	public void delete(Produit produit) {
		// TODO Auto-generated method stub
		repo.delete(produit);
	}
	
	

}

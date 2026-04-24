package service;

import dao.ProduitDao;
import model.Produit;
import java.util.List;

public class ProduitService {

    private ProduitDao dao = new ProduitDao();

    public void addProduit(Produit p) {
        dao.saveProduit(p);
    }

    public List<Produit> getAllProduits() {
        return dao.getAllProduits();
    }

    public void deleteProduit(Long id) {
        dao.deleteProduit(id);
    }

    public Produit getProduit(Long id) {
        return dao.getProduit(id);
    }

    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }
}
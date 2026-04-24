package dao;

import model.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProduitDao {

    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    // ADD
    public void saveProduit(Produit p) {
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(p);

        session.getTransaction().commit();
        session.close();
    }

    // LIST
    public List<Produit> getAllProduits() {
        Session session = factory.openSession();
        List<Produit> list = session.createQuery("from Produit", Produit.class).list();
        session.close();
        return list;
    }

    // DELETE
    public void deleteProduit(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Produit p = session.get(Produit.class, id);
        if (p != null) {
            session.delete(p);
        }

        session.getTransaction().commit();
        session.close();
    }

    // GET ONE
    public Produit getProduit(Long id) {
        Session session = factory.openSession();
        Produit p = session.get(Produit.class, id);
        session.close();
        return p;
    }

    // UPDATE
    public void updateProduit(Produit p) {
        Session session = factory.openSession();
        session.beginTransaction();

        session.update(p);

        session.getTransaction().commit();
        session.close();
    }
}
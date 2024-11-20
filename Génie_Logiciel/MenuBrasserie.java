package version4;

import java.util.HashMap;
import java.util.Iterator;


public class MenuBrasserie implements Menu {
    private final HashMap<String, Plat> plats;
    private int compteur;

    public MenuBrasserie() {
        this.plats = new HashMap<>();
        this.compteur = 0;
		ajouterPlat("Salade du Forez", "Saucisson chaud lyonnais artisanal, R�p�es de pomme de terre maison",
				false, 11.50);
		ajouterPlat("Salade berg�re", "Fourme fondue, Crottin de ch�vre chaud",
				false, 11.50);
		ajouterPlat("Salade bien-�tre", "Assortiment de crudit�s",
				true, 11.50);
    }

    public void ajouterPlat(String nom, String description, boolean vegetarien, double prix) {
        // Génération d'un identifiant unique basé sur le compteur
        String id = "P" + (++compteur);
        Plat plat = new Plat(nom, description, vegetarien, prix);
        plats.put(id, plat);
    }
    
    public HashMap<String, Plat> getPlats() {
        return plats;
    }

	@Override
	public Iterator<Plat> creerIterateur() {
		return new IterateurMenuBrasserie(plats);
	}
}


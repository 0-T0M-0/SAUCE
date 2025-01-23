package version2;

public class MenuCafeteria {
	
	// Attributs
	private final static int MAX_PLATS = 5;
	private int nombrePlats = 0;
	private Plat[] plats;
	
	// Méthodes
	public MenuCafeteria() {
		plats = new Plat[MAX_PLATS];
		ajouterPlat("Salade du Forez", "Saucisson chaud lyonnais artisanal, Râpées de pomme de terre maison", false, 11.50);
		ajouterPlat("Salade bergère", "Fourme fondue, Crottin de chèvre chaud", false, 11.50);
		ajouterPlat("Salade bien-être", "Assortiment de crudités", true, 11.50);	
	}
	
	public Plat[] getPlats() {
		return plats;
	}
	
	public void ajouterPlat(String nom, String description, boolean vegetarien, double prix) {
		Plat plat = new Plat(nom, description, vegetarien, prix);
		if (nombrePlats >= MAX_PLATS) {
			System.err.println("Il a y d�j� " + MAX_PLATS + " dans le menu, ajout impossible");
		}
		else {
			plats[nombrePlats] = plat;
			nombrePlats++;
		}
	}
	public IterateurMenuCafeteria creerIterateur() {
		return new IterateurMenuCafeteria(plats);
	}
	
}

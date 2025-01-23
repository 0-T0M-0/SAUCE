package version4;
import java.util.Iterator;

public class MenuCafeteria implements Menu {

	private final static int MAX_PLATS = 5;
	private int nombreDePlats = 0;
	private Plat[] plats;
	
	public MenuCafeteria() {
		plats = new Plat[MAX_PLATS];
		ajouterPlat("Salade du Forez", "Saucisson chaud lyonnais artisanal, R�p�es de pomme de terre maison",
				false, 11.50);
		ajouterPlat("Salade berg�re", "Fourme fondue, Crottin de ch�vre chaud",
				false, 11.50);
		ajouterPlat("Salade bien-�tre", "Assortiment de crudit�s",
				true, 11.50);
		
	}
	
	@Override
	public void ajouterPlat(String nom, String description, boolean vegetarien, double prix) {
		Plat plat = new Plat(nom, description, vegetarien, prix);
		if (nombreDePlats >= MAX_PLATS) {
			System.err.println("Il a y d�j� " + MAX_PLATS + " dans le menu, ajout impossible");
		}
		else {
			plats[nombreDePlats] = plat;
			nombreDePlats++;
		}
	}

	
	public int getNombreDePlats() {
		return nombreDePlats;
	}

	@Override
	public Iterator<Plat> creerIterateur() {
		return new IterateurMenuCafeteria(plats);
	}
	
	
}

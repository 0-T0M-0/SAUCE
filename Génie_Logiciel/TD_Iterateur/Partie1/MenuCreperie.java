package version1;

import java.util.ArrayList;
import java.util.List;

import version3.Plat;
public class MenuCreperie {
	
		// Attribut
		private List <Plat> plats;

		
		// Méthodes
		public MenuCreperie() {
			plats = new ArrayList<Plat>();
			ajouterPlat("Galette Annie", "Jambon blanc, emmental", false, 10.90);
			ajouterPlat("Galette Jeannette", "Jambon blanc, oeuf, emmental", false, 12.50);
			ajouterPlat("Galette Paulette", "Jambon blanc, oeuf, emmental, champignons à la crême", false, 13.50);
			ajouterPlat("Galette Germaine", "Légumes au choix : fondue de poireaux, épinards, ratatouille Maison selon la saison ou champignons à la crême", true, 11.90);
		}
		
		public List<Plat> getPlats() {
			return plats;
		}
		
		public void ajouterPlat(String nom, String description, boolean vegetarien, double prix) {
			Plat plat = new Plat(nom, description, vegetarien, prix);
			plats.add(plat);
		}

		
}

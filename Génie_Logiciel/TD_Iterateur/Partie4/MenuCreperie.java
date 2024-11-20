package version4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuCreperie implements Menu {

	List<Plat> plats;
	
	public MenuCreperie() {
		plats = new ArrayList<Plat>();
		ajouterPlat("Galette Annie", "Jambon blanc, emmental", false, 10.90);
		ajouterPlat("Galette Jeannette", "Jambon blanc, �uf, emmental", false, 12.50);
		ajouterPlat("Galette Paulette", "Jambon blanc, �uf, emmental, champignons � la cr�me", false, 13.50);
		ajouterPlat("Galette Germaine", "L�gumes au choix : fondue de poireaux, �pinards, ratatouille"
				+ " Maison selon la saison ou champignons � la cr�me", true, 11.90);
		
	}
	
	@Override
	public void ajouterPlat(String nom, String description, boolean vegetarien, double prix) {
		Plat plat = new Plat(nom, description, vegetarien, prix);
		plats.add(plat);
	}

	@Override
	public Iterator<Plat> creerIterateur() {
		return plats.iterator();
	}
	
	
}

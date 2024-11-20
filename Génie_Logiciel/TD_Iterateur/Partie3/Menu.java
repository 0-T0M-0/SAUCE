package version3;

import java.util.Iterator;

public interface Menu {

	public void ajouterPlat(String nom, String description, boolean vegetarien, double prix);
	public Iterator<Plat> creerIterateur();
	
}

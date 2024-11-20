package version4;
import java.util.Iterator;

public class Serveuse {

	private Menu menuCreperie;
	private Menu menuCafeteria;
	private Menu menuBrasserie;
	
	public Serveuse(Menu menuCreperie, Menu menuCafeteria, Menu menuBrasserie) {
		this.menuCreperie = menuCreperie;
		this.menuCafeteria = menuCafeteria;
		this.menuBrasserie = menuBrasserie;
	}
	
	public void afficherMenu() {
		Iterator<Plat> iterateurCreperie = menuCreperie.creerIterateur();
		Iterator<Plat> iterateurCafet = menuCafeteria.creerIterateur();
		Iterator<Plat> iterateurBrass = menuBrasserie.creerIterateur();
		System.out.println("-- Menu Creperie --");
		afficherMenu(iterateurCreperie);
		
		System.out.println("-- Menu Cafeteria --");
		afficherMenu(iterateurCafet);
		
		System.out.println("-- Menu Brasserie --");
		afficherMenu(iterateurBrass);
		
	}
	
	private void afficherMenu(Iterator<Plat> iterator) {
		iterator.forEachRemaining((plat) ->  {
			System.out.print(plat.getNom() + " -- ");
			System.out.print(plat.getPrix() + "� -- ");
			System.out.println(plat.getDescription());
		});
		
	}
	
	
}

package version3;
import java.util.Iterator;

//import java.util.List;

public class Serveuse {

	private Menu menuCreperie;
	private Menu menuCafeteria;
	
	public Serveuse(Menu menuCreperie, Menu menuCafeteria) {
		this.menuCreperie = menuCreperie;
		this.menuCafeteria = menuCafeteria;
	}
	
	public void afficherMenu() {
		Iterator<Plat> iterateurCreperie = menuCreperie.creerIterateur();
		Iterator<Plat> iterateurCafet = menuCafeteria.creerIterateur();
		
		System.out.println("-- Menu Creperie --");
		afficherMenu(iterateurCreperie);
		
		System.out.println("-- Menu Cafeteria --");
		afficherMenu(iterateurCafet);
		
	}
	
	private void afficherMenu(Iterator<Plat> iterator) {
		iterator.forEachRemaining((plat) ->  {
			System.out.print(plat.getNom() + " -- ");
			System.out.print(plat.getPrix() + "� -- ");
			System.out.println(plat.getDescription());
		});
		
	}
	
	
}

package version1;
public class TestServeuse {

	public static void main(String[] args) {
		MenuCreperie menuCreperie = new MenuCreperie();
		MenuCafeteria menuCafeteria = new MenuCafeteria();

		Serveuse serveuse = new Serveuse(menuCreperie, menuCafeteria);
		serveuse.afficherMenu();
	}
	
}

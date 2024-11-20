package version4;
import java.util.Iterator;

public class IterateurMenuCafeteria implements Iterator<Plat> {
	Plat[] plats;
	int position = 0;
	
	public IterateurMenuCafeteria(Plat[] plats) {
		this.plats = plats;
	}
	
	@Override
	public boolean hasNext() {
		//return (position < plats.length && plats[position] != null)
		if (position >= plats.length || plats[position] == null) {
			return false;
		}
		return true;
	}

	@Override
	public Plat next() {
		Plat plat = plats[position];
		position++;
		return plat;
	}

	@Override
	public void remove() {
		// plus simple
		//throw new UnsupportedOperationException("Suppression impossible de plat");
		
		if (position <= 0) {
			throw new IllegalStateException("Suppression impossible � cette position");
		}
		if (plats[position-1] != null) {
			for (int i = position-1; i < (plats.length-1); i++) {
				plats[i] = plats[i+1];
			}
			plats[plats.length-1] = null;
		}
		
	}	
	
}

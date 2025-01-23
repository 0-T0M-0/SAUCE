package version4;

import java.util.HashMap;
import java.util.Iterator;

public class IterateurMenuBrasserie implements Iterator<Plat> {
    private final Iterator<Plat> iterator;

    public IterateurMenuBrasserie(HashMap<String, Plat> plats) {
        this.iterator = plats.values().iterator();
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }


    @Override
    public Plat next() {
        return iterator.next();
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException("Suppression de plat non supportée.");
    }
}

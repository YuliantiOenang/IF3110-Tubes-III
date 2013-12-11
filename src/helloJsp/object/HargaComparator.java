package helloJsp.object;

import helloJsp.model.ModelInventori;

import java.util.Comparator;

public class HargaComparator implements Comparator<ModelInventori> {
    @Override
    public int compare(ModelInventori o1, ModelInventori o2) {
        int a = o1.getHarga();
        int b = o2.getHarga();
    	if (a < b) return -1;
    	else if (a == b) return 0;
    	else return 1;
    }
}

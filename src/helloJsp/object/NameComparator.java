package helloJsp.object;

import helloJsp.model.ModelInventori;

import java.util.Comparator;

public class NameComparator implements Comparator<ModelInventori> {
    @Override
    public int compare(ModelInventori o1, ModelInventori o2) {
        return o1.getNama_inventori().compareTo(o2.getNama_inventori());
    }
}

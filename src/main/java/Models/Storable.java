package Models;

import utils.Imageable;

public interface Storable extends Imageable {
    int getQuantity();
    boolean isKey();

    Element getElement();

}

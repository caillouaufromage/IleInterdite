package Models;

public abstract class Item {
    protected int quantity;
    protected Element element;
    public Item(int quantity, Element element){
        this.quantity = quantity;
        this.element = element;
    }
}

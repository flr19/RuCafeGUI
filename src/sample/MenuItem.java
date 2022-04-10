package sample;

public abstract class MenuItem {

    private int numItems;

    public abstract double itemPrice();

    public abstract String toString();

    public MenuItem(int numItems){
        this.numItems = numItems;
    }

    public void setNumItems (int numItems){
        this.numItems = numItems;
    }

    public int getNumItems (){
        return numItems;
    }
}

package sample;

public class Coffee extends MenuItem implements  Customizable{

    private int coffeeSize;
    private boolean hasCream;
    private boolean hasSyrup;
    private boolean hasMilk;
    private boolean hasCaramel;
    private boolean hasWhippedCream;

    public Coffee (int size) {
        super(size);
    }

    public void setSize(String coffeeSize) {
        if(coffeeSize.equals("Short")) {
            this.coffeeSize = 1;
        }
        else if (coffeeSize.equals("Tall")) {
            this.coffeeSize = 2;
        }
        else if (coffeeSize.equals("Venti")) {
            this.coffeeSize = 3;
        }
        else if (coffeeSize.equals("Grande")) {
            this.coffeeSize = 4;
        }
    }


    @Override
    public void add (String addOn) {
        if(addOn.equals("Cream")) {
            hasCream=true;
        }
        else if(addOn.equals("Syrup")) {
            hasSyrup=true;
        }
        else if(addOn.equals("Milk")) {
            hasMilk=true;
        }
        else if(addOn.equals("Caramel")) {
            hasCaramel=true;
        }
        else if(addOn.equals("Whipped Cream")) {
            hasWhippedCream=true;
        }
    }

    @Override
    public void remove (String addOn) {
        if(addOn.equals("Cream")) {
            hasCream=false;
        }
        else if(addOn.equals("Syrup")) {
            hasSyrup=false;
        }
        else if(addOn.equals("Milk")) {
            hasMilk=false;
        }
        else if(addOn.equals("Caramel")) {
            hasCaramel=false;
        }
        else if(addOn.equals("Whipped Cream")) {
            hasWhippedCream=false;
        }
    }

    @Override
    public double itemPrice () {
        int numAddIns = 0;
        double price = 0;
        if(coffeeSize == 1) {
            price = 1.69;
        }
        else if(coffeeSize == 2) {
            price= 2.09;
        }
        else if (coffeeSize == 3) {
            price = 2.49;
        }
        else if (coffeeSize == 4) {
            price = 2.89;
        }
        if(hasCream) {
            numAddIns++;
        }
        if(hasSyrup) {
            numAddIns++;
        }
        if(hasMilk) {
            numAddIns++;
        }
        if(hasCaramel) {
            numAddIns++;
        }
        if(hasWhippedCream){
            numAddIns++;
        }
        price = price + (numAddIns*0.30);
        return price;
    }
}

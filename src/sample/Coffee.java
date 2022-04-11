package sample;


public class Coffee extends MenuItem implements  Customizable{

    private static final int ISSHORT = 1;
    private static final int ISTALL = 2;
    private static final int ISGRANDE = 3;
    private static final int ISVENTI = 4;

    private int coffeeSize;
    private boolean hasCream;
    private boolean hasSyrup;
    private boolean hasMilk;
    private boolean hasCaramel;
    private boolean hasWhippedCream;

    public Coffee (int coffeeSize, int numItems) {
        super(numItems);
        this.coffeeSize = 1; //Short
        hasCream = false;
        hasSyrup = false;
        hasMilk = false;
        hasCaramel = false;
        hasWhippedCream = false;
    }

    public void setSize(String coffeeSize) {
        if(coffeeSize.equals("Short")) {
            this.coffeeSize = ISSHORT;
        }
        else if (coffeeSize.equals("Tall")) {
            this.coffeeSize = ISTALL;
        }
        else if (coffeeSize.equals("Grande")) {
            this.coffeeSize = ISGRANDE;
        }
        else if (coffeeSize.equals("Venti")) {
            this.coffeeSize = ISVENTI;
        }
    }
    @Override
    public boolean add(Object obj) {
        if (obj instanceof String) {
            String addOn = (String) obj;
            if (addOn.equals("Cream")) {
                hasCream = true;
            } else if (addOn.equals("Syrup")) {
                hasSyrup = true;
            } else if (addOn.equals("Milk")) {
                hasMilk = true;
            } else if (addOn.equals("Caramel")) {
                hasCaramel = true;
            } else if (addOn.equals("Whipped Cream")) {
                hasWhippedCream = true;
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove (Object obj) {
        if (obj instanceof String) {
            String addOn = (String) obj;
            if (addOn.equals("Cream")) {
                hasCream = false;
            } else if (addOn.equals("Syrup")) {
                hasSyrup = false;
            } else if (addOn.equals("Milk")) {
                hasMilk = false;
            } else if (addOn.equals("Caramel")) {
                hasCaramel = false;
            } else if (addOn.equals("Whipped Cream")) {
                hasWhippedCream = false;
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double itemPrice () {
        int numAddIns = 0;
        double price = 1.69;
        price += 0.4*(coffeeSize-1);
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
        price += (numAddIns*0.30);
        return price*getNumItems();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Coffee){
            Coffee coffee = (Coffee)obj;
            if(coffeeSize == coffee.coffeeSize) {
                if(hasCream == coffee.hasCream  && hasSyrup == coffee.hasSyrup && hasMilk == coffee.hasMilk &&
                        hasCaramel == coffee.hasCaramel && hasWhippedCream == coffee.hasWhippedCream){
                    if(getNumItems() == coffee.getNumItems()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return  "Coffee - " + getCoffeeType() + getAddIns() + "(" + getNumItems() + ")" + " ---> $" + itemPrice();
    }

    public String getCoffeeType(){
        if (coffeeSize == ISSHORT){
            return "Short";
        }
        else if (coffeeSize == ISTALL){
            return "Tall";
        }
        else if (coffeeSize == ISGRANDE){
            return "Grande";
        }
        return "Venti";
    }

    public String getAddIns(){
        String result = " ";

        if(hasCream) {
            result = result + "Cream, ";
        }
        if(hasSyrup) {
            result = result + "Syrup, ";
        }
        if(hasMilk) {
            result = result + "Milk, ";
        }
        if(hasCaramel) {
            result = result + "Caramel, ";
        }
        if(hasWhippedCream){
            result = result + "Whipped Cream, ";
        }

        if (result.length() == 1) {
            return " ";
        }

        return " [" + result.substring(1, result.length()-2) + "] ";

    }
}

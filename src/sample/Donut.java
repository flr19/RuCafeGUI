package sample;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Extends MenuItem and has different types of Donuts that customers can order
 *
 * @author Prince Rawal
 * @author Farah Lubaba Rouf
 */

public class Donut extends MenuItem {

    private static final int ISYEAST = 1;
    private static final int ISCAKE = 2;
    private static final int ISHOLE = 3;

    private static final double YEASTCOST = 1.59;
    private static final double CAKECOST = 1.79;
    private static final double HOLECOST = 0.39;
//
//    private static ArrayList<String> usualTypeYeast= new ArrayList<String>(
//            Arrays.asList("Glazed Chocolate", "Vanilla Creme", "Strawberry Frosted", "Jelly"));
//
//    private static ArrayList<String> usualTypeCake= new ArrayList<String>(
//            Arrays.asList("Chocolate", "Mango", "Sugar", "Jelly"));
//
//    private static ArrayList<String> usualTypeHole= new ArrayList<String>(
//            Arrays.asList("Glazed", "Vanilla", "Jelly", "Sugar"));

    private int donutType; //1 yeast 2 cake donut 3 donut holes
    private String flavor;

    /**
     * Constructor to create Donut
     *
     * @param donutType tyoe of donut
     * @param flavor    of donut
     * @param numItems  number of items
     */

    public Donut(int donutType, String flavor, int numItems) {
        super(numItems);
        this.donutType = donutType;
        this.flavor = flavor;
    }

    /**
     * Method to rcalculate price of donut
     *
     * @return price of donut
     */

    @Override
    public double itemPrice() {
        if (donutType == ISYEAST) {
            return getNumItems() * YEASTCOST;
        } else if (donutType == ISCAKE) {
            return getNumItems() * CAKECOST;
        } else {
            return getNumItems() * HOLECOST;
        }
    }

    /**
     * Method to compare 2 donut items
     *
     * @return true if they are the same, false otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut donut = (Donut) obj;
            if (donutType == donut.donutType) {
                if (flavor.equals(donut.flavor)) {
                    if (getNumItems() == donut.getNumItems()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method to return donut order as string
     *
     * @return the order in string format
     */

    @Override
    public String toString() {
        return getDonutType() + " - " + flavor + " (" + getNumItems() + ")" + " ---> $" + String.format("%.2f" ,itemPrice());
    }

    /**
     * Method to show donut type
     *
     * @return type of donut
     */

    public String getDonutType() {
        if (donutType == ISYEAST) {
            return "Yeast Donut";
        } else if (donutType == ISCAKE) {
            return "Cake Donut";
        }
        return "Donut Holes";
    }

}

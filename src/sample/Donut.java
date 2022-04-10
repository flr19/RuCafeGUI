package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Donut extends MenuItem{

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

    public Donut (int donutType, String flavor, int numItems){
        super(numItems);
        this.donutType = donutType;
        this.flavor = flavor;
    }

    @Override
    public double itemPrice() {
        if(donutType == ISYEAST) {
            return getNumItems()*YEASTCOST;
        }
        else if (donutType == ISCAKE) {
            return getNumItems()*CAKECOST;
        }
        else {
            return getNumItems()*HOLECOST;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Donut) {
            Donut donut = (Donut)obj;
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

    @Override
    public String toString(){
        return getDonutType() + " - " + flavor + " (" + getNumItems() + ")" + " ---> $" + itemPrice();
    }

    public String getDonutType(){
        if (donutType == ISYEAST){
            return "Yeast Donut";
        }
        else if(donutType == ISCAKE){
            return "Cake Donut";
        }
        return "Donut Holes";
    }

//    @Override
//    public boolean add (Object obj) {
//        if(obj instanceof String){
//            String donut = (String)obj;
//            String flavor;
//            int quantity;
//            int currIndex = 0;
//            int commaIndex = 0;
//            while(currIndex < donut.length()){
//                if(donut.charAt(currIndex) == ','){
//                    commaIndex = currIndex;
//                }
//                currIndex++;
//            }
//            flavor = donut.substring(0, commaIndex);
//            quantity = Integer.parseInt(donut.substring(commaIndex+2));
//            donutTypesSelected.add(flavor + ", " + quantity);
//            donutQuantity += quantity;
//            return availableDonutTypes.remove(flavor);
//        }
//        else{
//            return false;
//        }
//    }
//
//    @Override
//    public boolean remove (Object obj) {
//        if(obj instanceof String){
//            String flavor = (String)obj;
//            for (int i = 0; i < donutTypesSelected.size(); i++){
//                int currIndex = 0;
//                int commaIndex = 0;
//                while(currIndex < donutTypesSelected.get(i).length()){
//                    if(donutTypesSelected.get(i).charAt(currIndex) == ','){
//                        commaIndex = currIndex;
//                    }
//                    currIndex++;
//                }
//                if((donutTypesSelected.get(i).substring(0, commaIndex)).equals(flavor)){
//                    availableDonutTypes.add(flavor);
//                    donutQuantity -= Integer.parseInt(donutTypesSelected.get(i).substring(commaIndex+2));
//                    //+2 because there's a space character after the comma
//                    donutTypesSelected.remove(i);
//                    return true;
//                }
//            }
//            return false;
//        }
//        return false;
//    }
}

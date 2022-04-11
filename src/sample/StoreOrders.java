package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StoreOrders implements Customizable{

    private ArrayList<Order> storeOrders;

    public StoreOrders() {
        storeOrders = new ArrayList<Order>();
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order) {
            Order order = (Order) obj;
            if(storeOrders.size() > 0){
                order.setOrderNum(storeOrders.get(storeOrders.size()-1).getOrderNum() + 1);
                //new order number is 1 + last Order Number
            }
            storeOrders.add(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Integer) {
            int orderNumber = (Integer)obj;
            for (int i = 0; i < storeOrders.size(); i++){
                if(storeOrders.get(i).getOrderNum() == orderNumber){
                    storeOrders.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> toStringList(){
        ArrayList<String> result = new ArrayList<String>();

        if(storeOrders.size() == 0){
            return result;
        }

        result.addAll(storeOrders.get(0).toStringList());

        for(int i = 1; i < storeOrders.size(); i++){
            result.add(" ");
            result.addAll(storeOrders.get(i).toStringList());
        }
        return result;
    }

    public String stringForExportingOrders (ArrayList<String> result) {
        String orderList = " ";
        int j=2;
        orderList+= "Order number 1:" + result.get(0) ;
        for(int i=1; i<  result.size(); i++) {
//            if(result.get(i).equals(" ")) {
//                continue;
//
//            }
//            orderList += "Order number "+ j + " " + result.get(i) + "\n";
//            j++;
            if(result.get(i).equals(" ")) {
                orderList += "\n" + "Order number " + j;
                j++;
            }
            orderList += result.get(i);
        }
        return orderList;
    }

    public ArrayList<String> getOrder(int orderNum){
        for(int i = 0; i < storeOrders.size(); i++){
            if(storeOrders.get(i).getOrderNum() == orderNum){
                return storeOrders.get(i).toStringList();
            }
        }
        return new ArrayList<String>(); //returning an empty list
    }

    public ArrayList<Integer> getOrderNumber(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < storeOrders.size(); i++){
            result.add(storeOrders.get(i).getOrderNum());
        }
        return result;
    }

    public double getCost(int orderNum) {
        for(int i = 0; i < storeOrders.size(); i++){
            if(storeOrders.get(i).getOrderNum() == orderNum){
                return storeOrders.get(i).getTotalPrice();
            }
        }
        return 0;
    }

    public int getSize() {
        return storeOrders.size();
    }

}

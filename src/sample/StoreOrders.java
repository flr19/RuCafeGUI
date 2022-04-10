package sample;

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
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order) {
            Order order = (Order) obj;
            storeOrders.remove(order);
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
}

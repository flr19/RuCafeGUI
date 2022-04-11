package sample;

import java.util.ArrayList;

public class Order implements Customizable{

    private int orderNum;
    private ArrayList<MenuItem> orders;

    public Order() {
        this.orderNum = 1;
        orders = new ArrayList<MenuItem>();
    }

    public void setOrderNum(int orderNum){
        this.orderNum = orderNum;
    }


    public int getOrderNum() {
        return orderNum;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(int i = 0; i < orders.size(); i++){
            totalPrice += orders.get(i).itemPrice();
        }
        return totalPrice;
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            orders.add(item);
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Integer) {
            int index = (Integer)obj;
            orders.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Coffee){
            Order order = (Order)obj;
            if(getOrderNum() == order.getOrderNum()){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> toStringList(){
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < orders.size(); i++) {
            result.add("Item " + (i+1) + ": " + orders.get(i).toString());
        }
        return result;
    }

}

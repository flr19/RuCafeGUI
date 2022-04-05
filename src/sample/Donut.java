package sample;

public class Donut extends MenuItem{
    private int donutTypeIndicator; //1 yeats 2 cake donut 3 donut holes

    @Override
    public double itemPrice() {
        if(donutTypeIndicator==1) {
            return 1.59;
        }
        else if (donutTypeIndicator == 2) {
            return 1.79;
        }
        else if (donutTypeIndicator == 3) {
            return 0.39;
        }
    }


}

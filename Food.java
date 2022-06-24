import java.io.Serializable;


public class Food implements Serializable{

    private int foodID;
    private String name;   
    private float price;
    
    Food(int foodID,String name , float price)
    {
        this.foodID=foodID;
        this.name=name;
        this.price = price;

        
        
    }

    public int getFoodID() {
        return foodID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    
    
}

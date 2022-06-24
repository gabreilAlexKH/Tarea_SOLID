public class Food_order {

    private float totalprice;
    private int quantity;
    private Food food;

    
    public Food_order(int quantity, Food food) {
        this.quantity = quantity;
        this.food = food;

        this.totalprice = food.getPrice() * quantity;

    }


    public float getTotalprice() {
        return totalprice;
    }


    public int getQuantity() {
        return quantity;
    }


    public Food getFood() {
        return food;
    }

    

    
    
}

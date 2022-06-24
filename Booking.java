import java.io.Serializable;
import java.util.ArrayList;

public class Booking implements Serializable{

    private ArrayList<Client> clients;
    private Room room;
    private ArrayList<Food_order> food_orders;

    public Booking(ArrayList<Client> clients, Room room) {

        this.clients = clients;
        this.room = room;
        food_orders = new ArrayList<Food_order>();
    }

    


    public void addFood_Order(Food_order roomService){

        food_orders.add(roomService);
        
    }




    public ArrayList<Client> getClients() {
        return clients;
    }




    public Room getRoom() {
        return room;
    }




    public ArrayList<Food_order> getFood_orders() {
        return food_orders;
    }

    
    

    
}

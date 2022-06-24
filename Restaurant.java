import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class Restaurant implements Serializable {

    static Scanner sc = new Scanner(System.in);

    private ArrayList<Food> foods;

    

    public Restaurant(ArrayList<Food> foods) {
        this.foods = foods;
    }


    /**
     * Requests the Food to order and adds them to the Booking of the entered Room.
     * @param room
     */
    void order(Room room)
    {
        int i,q;
        char wish;
         try{
             
            
            System.out.println("\n==========\n   Menu:  \n==========\n");

            for (int j = 0; j < foods.size() ; j++) {

                System.out.printf("\n%d. %s \t Rs.%.2f", j+1 ,foods.get(j).getName() , foods.get(j).getPrice());  
            } 
            System.out.println("\n");
            
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity- ");
            q=sc.nextInt();

            Food food = foods.get(i-1);
            Food_order roomService = new Food_order(q, food);

            Booking booking = room.getBooking();
            booking.addFood_Order(roomService);
            
           
            System.out.println("Do you want to order anything else ? (y/n)");
            wish=sc.next().charAt(0);


        }while(wish=='y'||wish=='Y');  
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        
         catch(Exception e)
         {
             System.out.println("Cannot be done");
         }
    }
    
}

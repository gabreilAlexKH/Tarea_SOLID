import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;


public class Reception implements Serializable{

    static Scanner sc = new Scanner(System.in);

    /**
     * Requests Client data and assigns the entered room to them
     * @param room
     */
    public void CustDetails(Room room)
    {
        
        ArrayList<Client> clientes = new ArrayList<Client>();
        for (int j = 0; j < room.getCapacity(); j++) {

            String name, contact, gender;

            System.out.println("\nCustumer "+ (j+1) + " ");

            System.out.print("Enter customer name: ");
            name = sc.next();
            System.out.print("Enter contact number: ");
            contact=sc.next();
            System.out.print("Enter gender (MALE or FEMALE): ");
            gender = sc.next();

            Client cliente = new Client(name, contact, Gender.valueOf(gender));
            clientes.add(j, cliente);
            
        }

            Booking booking = new Booking(clientes, room);
            room.setBooking(booking);

            

            for (int j = 0; j < room.getCapacity(); j++) {

                clientes.get(j).setBooking(booking);

            }
    }
    
    /**
     * Check in Client to the selected Room on the entered Floor.
     * @param floor
     */
    public void bookroom(Floor floor)
    {
        int rn;
        System.out.println("\nChoose room number from : ");

        for (int k = 0; k < floor.getTotalRooms(); k++) {

            Room room = floor.getnRoom(k);

            if(room.getBooking()==null)
                {
                    System.out.printf("%d," , room.getRoomNum());
                }
        }

        
        System.out.print("\nEnter room number: ");

        try{
        rn=sc.nextInt();
        rn = rn - 100*floor.getnFloor() - 1;
        System.out.println(rn);

        if(floor.getnRoom(rn).getBooking()!=null){
            throw new NotAvailable();
        }
            
        
        Room room = floor.getnRoom(rn);
        CustDetails(room);

        }
        catch(Exception e)
        {
            System.out.println("Invalid Option");
            return;
        }
    
    }
    
  
    /**
     * Prints the bill with the costs of stay and food service of the entered Room .
     * @param booking
     */
    public void bill(Booking booking)
    {
        double total=0;

        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        total+=booking.getRoom().getChargePerDay();

        System.out.println("\nRoom Charge - "+ total);
        System.out.println("\n===============");

        ArrayList<Food_order> food_orders = booking.getFood_orders();

        if(food_orders.size() > 0){

            System.out.println("Food Charges:- ");
            System.out.println("===============");
            System.out.println("ID \t Item \t Quantity \t Price");

            System.out.println("-------------------------");

            for (int i = 0; i < food_orders.size(); i++) {

                Food_order order = food_orders.get(i);
                total+= order.getTotalprice();
                String format = "%d \t %s \t %d \t %.2f\n";

                System.out.printf(format, i+1 , order.getFood().getName() , order.getQuantity() , order.getFood().getPrice() );
            }
        }
        
        System.out.println("\nTotal Amount- "+ total);
    }


    /**
     * Check in Client from the entered Room and prints its bill
     * @param room
     */
    public void deallocate(Room room)
    {
        char w;

        Booking booking = room.getBooking();

        if(booking == null){

            System.out.println("\nRoom not booked");
            return;
        }
        ArrayList<Client> clients = booking.getClients();

        if(room.getBooking()!=null)
                    System.out.println("Room used by " + clients.get(0).getName());                
        else 
        {    
            System.out.println("Empty Already");
                return;
        }
        System.out.println("Do you want to checkout ?(y/n)");
            w=sc.next().charAt(0);
        if(w=='y'||w=='Y')
        {
            bill(booking);
            room.setBooking(null);
            
            for (int i = 0; i < room.getCapacity(); i++) {

                clients.get(i).setBooking(null);
            }

            System.out.println("Deallocated succesfully");
        }
    }
}
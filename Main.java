import java.util.ArrayList;
import java.util.Scanner;




public class Main {


    /**
     * Inits a Hotel
     * @return
     */
    public static Hotel initHotel(){


        Room luxury_doublerrom[]=new Room[10]; //Luxury

        for (int index = 0; index < luxury_doublerrom.length; index++) {

            int nRoom = 100+index+1;
            Room room = new Room(true, 2, nRoom, 4000);
            luxury_doublerrom[index] = room;
            
        }

        Room deluxe_doublerrom[]=new Room[10]; 
        for (int index = 0; index < deluxe_doublerrom.length; index++) {

            int nRoom = 200+index+1;
            Room room = new Room(false, 2, nRoom, 3000);
            deluxe_doublerrom[index] = room;
            
        }

        Room luxury_singleerrom[]=new Room[10]; //Luxury
        for (int index = 0; index < luxury_singleerrom.length; index++) {

            int nRoom = 300+index+1;
            Room room = new Room(true, 1, nRoom, 2200);
            luxury_singleerrom[index] = room;
            
        }

        Room deluxe_singleerrom[]=new Room[10]; //Deluxe
        for (int index = 0; index < deluxe_singleerrom.length; index++) {

            int nRoom = 400+index+1;
            Room room = new Room(false, 1, nRoom, 1200);
            deluxe_singleerrom[index] = room;
            
        }
        
        Floor floors[] = new Floor[4];

        floors[0] = new Floor(1, luxury_doublerrom);
        floors[1] = new Floor(2, deluxe_doublerrom);
        floors[2] = new Floor(3, luxury_singleerrom);
        floors[3] = new Floor(4, deluxe_singleerrom);

        ArrayList<Food> foods = new ArrayList<Food>();

        foods.add(0, new Food(1, "Sandwich", 50) );
        foods.add(1, new Food(1, "Pasta", 60) );
        foods.add(2, new Food(1, "Noodles", 60) );
        foods.add(3, new Food(1, "Coke", 70) );

        Hotel hotel = new Hotel(floors, foods);
        
        
        return hotel;  
    }


    /**
     * Gets the floor of the Room using its room number
     * @param roomNum
     * @return
     */
    public static int getFloor(int roomNum){

        int floorNum = roomNum/100;

        return floorNum;
    }



    /**
     * Gets index from the Room in the Floor using the room number
     * @param floor
     * @param roomNum
     * @return
     */
    public static int getRoomIndex(Floor floor, int roomNum){

        int index = roomNum - 100*floor.getnFloor() - 1;
        System.out.println(floor.getnFloor());

        return index;
    }


    public static void main(String[] args){

        
        Hotel hotel = initHotel();
        Reception reception = hotel.reception;
        Restaurant restaurant = hotel.restaurant;

        
        Scanner sc = new Scanner(System.in);
        int ch , floorNum , index;
        char wish;

        Floor floor;
        Room room;

        x:
        
        do{

        System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
        ch = sc.nextInt();
        switch(ch){
            case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                    ch = sc.nextInt();
                    hotel.features(ch);

                break;
            case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                     ch = sc.nextInt();

                     int availableRooms = hotel.getFloorN(ch-1).floorAvailability();

                     System.out.println("Number of rooms available : "+availableRooms);

                break;
            case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                     ch = sc.nextInt();


                     reception.bookroom(hotel.getFloorN(ch-1)); 
                     
                     
                break;
            case 4:
                 System.out.print("Room Number -");
                ch = sc.nextInt();
                    
                floorNum = getFloor(ch);
                floor = hotel.getFloorN(floorNum-1);
                index = getRoomIndex(floor, ch);
                room = floor.getnRoom(index);

                restaurant.order(room);
                break;

            case 5:                 
                System.out.print("Room Number -");
                ch = sc.nextInt();

                floorNum = getFloor(ch);
                floor = hotel.getFloorN(floorNum-1);
                index = getRoomIndex(floor, ch);
                room = floor.getnRoom(index);

                reception.deallocate(room);
                
                break;
                     
            case 6:break x;
                
        }
           
            System.out.println("\nContinue : (y/n)");
            wish=sc.next().charAt(0); 
            if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
            {
                System.out.println("Invalid Option");
                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0); 
            }
            
        }while(wish=='y'||wish=='Y');    
        
    }
}

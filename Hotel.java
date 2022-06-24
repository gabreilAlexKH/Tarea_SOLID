
import java.util.ArrayList;


public class Hotel
{

    private Floor floors[];
    public Restaurant restaurant;
    public Reception reception;


    public Hotel(Floor[] floors, ArrayList<Food> foods) {

        this.floors = floors;
        this.restaurant = new Restaurant(foods);
        this.reception = new Reception();
    }


    /**
     * Returns n index of the Floor Array
     * @param n
     * @return
     */
    public Floor getFloorN(int n) {
        return floors[n];
    }

    public void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    
  
}

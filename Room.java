import java.io.Serializable;


public class Room implements Serializable{

    private boolean luxury;  
    private int capacity;
    private int roomNum;
    private float chargePerDay;
    private Booking booking = null;


    public Room(boolean luxury, int capacity, int roomNum, float chargePerDay) {
        this.luxury = luxury;
        this.capacity = capacity;
        this.roomNum = roomNum;
        this.chargePerDay = chargePerDay;
    }


    public boolean isLuxury() {
        return luxury;
    }


    public int getCapacity() {
        return capacity;
    }


    public int getRoomNum() {
        return roomNum;
    }

    public float getChargePerDay() {
        return chargePerDay;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }  

    
   
}

class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}
    

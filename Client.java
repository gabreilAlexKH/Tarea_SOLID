import java.io.Serializable;

public class Client implements Serializable{

    private String name;
    private String contact;
    private Gender gender;
    private Booking booking = null;


    public Client(String name, String contact, Gender gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;

        
    }


    public void setBooking(Booking booking) {
        this.booking = booking;
    }


    public String getName() {
        return name;
    }  

    
}

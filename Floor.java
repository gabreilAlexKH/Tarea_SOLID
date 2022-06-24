public class Floor {

    private int nFloor;
    private int TotalRooms;
    private Room rooms[];

    
    public Floor(int nFloor, Room[] rooms) {
        this.nFloor = nFloor;
        this.TotalRooms = rooms.length;
        this.rooms = rooms;
    }


    public int getnFloor() {
        return nFloor;
    }


    public int getTotalRooms() {
        return TotalRooms;
    }


    public Room getnRoom(int n) {

        return rooms[n];
    }

    public int floorAvailability()
    {
        int availableRooms = TotalRooms;

        for (int i = 0; i < TotalRooms; i++) {
            
            if(rooms[i].getBooking() != null){

                availableRooms--;
            }
        }
            
        return availableRooms;
    }
    

    


    
    
}

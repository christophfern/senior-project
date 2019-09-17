import java.util.ArrayList;

public class RoomList {
    ArrayList<Room> roomCollection=new ArrayList<Room>();
    private double score;

    RoomList(){

    }

    RoomList(RoomList old){
        this.roomCollection=old.getRoomCollection();
        this.score=old.getScore();
    }

    public void setRoomCollection(ArrayList<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    public ArrayList<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}

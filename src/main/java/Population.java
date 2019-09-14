import java.util.ArrayList;

public class Population{
    private float popScore;
    private int popNumber;

    private ArrayList<Room> classList;

    public void setPopNumber(int popNumber) {
        this.popNumber = popNumber;
    }

    public int getPopNumber() {
        return this.popNumber;
    }

    public void setPopScore(int score){
        this.popScore=score;
    }

    public float getPopScore() {
        return popScore;
    }


    public void setClassList(ArrayList<Room> classList) {
        this.classList = classList;
    }

    public void addClass(Room r){
        classList.add(r);

    }
}
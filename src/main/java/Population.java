import java.util.ArrayList;

public class Population{
    private double popScore;
    private int popNumber;
    private ArrayList<ArrayList<Room>> population=new ArrayList<ArrayList<Room>>();

    public void setPopNumber(int popNumber) {

        this.popNumber = popNumber;
    }

    public void increasePopNumber(){
        this.popNumber++;
    }

    public int getPopNumber() {
        return this.popNumber;
    }

    public void setPopScore(double score){
        this.popScore=score;
    }

    public double getPopScore() {
        return popScore;
    }


    public void setClassList(ArrayList<ArrayList<Room>> population) {
        this.population = population;
    }



    public ArrayList<ArrayList<Room>> getPopulation(){
        return population;
    }

    public void addClass(ArrayList<Room> r){
        population.add(r);

    }



}
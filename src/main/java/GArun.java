import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;


public class GArun{

    public static void initialPopulation(ArrayList<Student> students,   ArrayList<Room> classes, Population population){
       int numClass=classes.size()+1;
       int randomClass;

       population.setPopNumber(1);

       
       ArrayList<Integer> index=new ArrayList<Integer>();

        for (int i=0; i<classes.size(); i++) {
            index.add(i);
        }

       Random random = new Random();

       for (Student student : students) {

           for(int i=0; i<classes.size(); i++){

               if(classes.get(i).isFull()) {
                       int remove = index.indexOf(i);
                       if(remove>=0) {
                           System.out.println(remove);
                           index.remove(remove);
                       }
               }
           }

           while(true) {

               randomClass = random.nextInt(numClass);
                if(index.contains(randomClass)){
                    break;
                }
           }

            if(!classes.get(randomClass).isFull()){

                classes.get(randomClass).addStudent(student);

            }


       }



    }

    public static void selection(ArrayList<Room> classes, Population population){


    }


}
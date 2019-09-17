
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;


public class GArun {

    public static void initialPopulation(ArrayList<Student> students, ArrayList<Room> classList, Population population) {
        int numClass = classList.size();
        int randomClass;
        population.setPopNumber(1);


        for (int j = 0; j < 1000; j++) {
            ArrayList<Room> classes = new ArrayList<Room>();


            for (Room r : classList) {
                //    System.out.println(r);
                Room newRoom = new Room(r);

                classes.add(newRoom);
            }


            ArrayList<Integer> index = new ArrayList<Integer>();

            for (int i = 0; i < classes.size(); i++) {
                index.add(i);
            }
            //    System.out.println(index.size());
            Random random = new Random();

            for (Student student : students) {

                for (int i = 0; i < classes.size(); i++) {

                    if (classes.get(i).isFull()) {
                        int remove = index.indexOf(i);
                        if (remove >= 0) {
                            //    System.out.println(remove);
                            index.remove(remove);
                        }
                    }
                }

                while (true) {

                    randomClass = random.nextInt(numClass);
                    if (index.contains(randomClass) || index.isEmpty()) {
                        break;
                    }

                }

                if (!classes.get(randomClass).isFull()) {

                    classes.get(randomClass).addStudent(student);

                }


            }
            // System.out.println(classes.get(0).getStudentList());
            population.addClass(classes);

        }

    }


    public static ArrayList<RoomList> selection(Population population) {


        RoomList bestRoomList = new RoomList();
        RoomList secondBestRoomList = new RoomList();
        RoomList thirdBestRoomList =new RoomList();
        RoomList fourthBestRoomList=new RoomList();

        double currPopScore = 0.0;
        for (ArrayList<Room> currPop : population.getPopulation()) {
            currPopScore = 0.0;

            for (Room currRoom : currPop) {
                currRoom.calculateScore();
                currPopScore += currRoom.getScore();

            }


            if (currPopScore > bestRoomList.getScore()) {

                bestRoomList.setRoomCollection(currPop);
                bestRoomList.setScore(currPopScore);

            } else if (currPopScore > secondBestRoomList.getScore()) {
                secondBestRoomList.setRoomCollection(currPop);
                secondBestRoomList.setScore(currPopScore);
            }else if (currPopScore > thirdBestRoomList.getScore()){
                thirdBestRoomList.setRoomCollection(currPop);
                thirdBestRoomList.setScore(currPopScore);
            }else if(currPopScore > fourthBestRoomList.getScore()){
                fourthBestRoomList.setRoomCollection(currPop);
                fourthBestRoomList.setScore(currPopScore);
            }

        }
      ArrayList<RoomList> best= new ArrayList<RoomList>();
        best.add(bestRoomList);
        best.add(secondBestRoomList);
        best.add(thirdBestRoomList);
        best.add(fourthBestRoomList);

        return best;
    }


    public static Population mating(ArrayList<RoomList> parents) {
        RoomList best = parents.get(0);
        RoomList second = parents.get(1);
        RoomList third = parents.get(2);
        RoomList fourth = parents.get(3);
        Population childPop = new Population();


        for (int i = 0; i < 1000; i++) {
            if (i < 35) {
                RoomList rl = new RoomList();
                for (Room r : best.getRoomCollection()) {
                    Room copyRoom = new Room(r, true);
                    rl.getRoomCollection().add(copyRoom);
                }
                childPop.getPopulation().add(rl.getRoomCollection());
            } else if(i<60){
                RoomList rl = new RoomList();
                for (Room r : second.getRoomCollection()) {
                    Room copyRoom = new Room(r, true);
                    rl.getRoomCollection().add(copyRoom);
                }
                childPop.getPopulation().add(rl.getRoomCollection());
            }else if(i<80){
                RoomList rl = new RoomList();
                for (Room r : third.getRoomCollection()) {
                    Room copyRoom = new Room(r, true);
                    rl.getRoomCollection().add(copyRoom);
                }
                childPop.getPopulation().add(rl.getRoomCollection());
            }else if(i<100){
                RoomList rl = new RoomList();
                for (Room r : fourth.getRoomCollection()) {
                    Room copyRoom = new Room(r, true);
                    rl.getRoomCollection().add(copyRoom);
                }
                childPop.getPopulation().add(rl.getRoomCollection());
            }
        }


        return childPop;
    }


    public static Population mutation(Population childPop) {
        int percentMutation=15;

        Random random = new Random();
        int randNum;
        int randClass;
        int randStudent;
        int randStudent2;
        for(ArrayList<Room> list : childPop.getPopulation()){
          //  System.out.println(list.size());
            for(int i=0; i<list.size(); i++){
                randNum=random.nextInt(100);

                if(randNum<percentMutation) {
                    do {
                         randClass = random.nextInt(list.size());
                    }while(randClass==i);
                    randStudent=random.nextInt(list.get(i).getStudentList().size()-1);
                    randStudent2=random.nextInt(list.get(randClass).getStudentList().size()-1);
                    list.get(i).swapStudents(list.get(randClass), randStudent, randStudent2);
                }
                }
            }

        return childPop;
    }



    public static int terminate(Population population) {
        int targetScore = 17;

        for (int i = 0; i < population.getPopulation().size(); i++) {
            int score = 0;

            for (int j = 0; j < population.getPopulation().get(i).size(); j++) {
                score += population.getPopulation().get(i).get(j).getScore();
            }

            System.out.println(score);
            if (score >= targetScore) {

                return i;
            }
        }
        return -1;
    }

}





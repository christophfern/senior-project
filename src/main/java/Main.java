

import javafx.util.Pair;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
          Population population=new Population();
          Pair<ArrayList<Student>,ArrayList<Room>> firstGen=null;

           try {
               firstGen=ReadIn.readSheet(population);
           }catch(Exception e){

           }



        ArrayList<Student> studentsOrg = firstGen.getKey();
        ArrayList<Room> classesWmcGill = firstGen.getValue();
        ArrayList<Room> classes=new ArrayList<Room>();
        ArrayList<Integer> indexToDelete=new ArrayList<Integer>();
        ArrayList<Integer> mcGills=new ArrayList<Integer>();
        ArrayList<Student> students=new ArrayList<Student>();


       for(Room room : classesWmcGill){
           if(!room.getName().equalsIgnoreCase("mcgill-dan") && !room.getName().equalsIgnoreCase("mcgill-nancy"))
           classes.add(room);
       }

        int index=0;
        for(Student student : studentsOrg){
            if(student.getChoice1()==null || student.getChoice1().equals("")){
             indexToDelete.add(index);

            }
            if(student.getMcGill()){
                mcGills.add(index);
            }
            index++;
        }

        for(int i=0; i< studentsOrg.size(); i++){
           if(!indexToDelete.contains(i)){
               students.add(studentsOrg.get(i));
           }

        }
    System.out.println(students.size());

        int studentsPerClass = students.size() / classes.size();
        double maxScore=students.size()*5;

        population.setPopScore(maxScore);


        for(Room room : classes) {
            room.setSizeAllowed(studentsPerClass);
        }

        //System.out.println(students.size());

        Population parents=new Population();
        Population childPop = null;


        int generationCount=0;
        int end=-1;
    int curscore=0;
    do {
        if(generationCount==0){
            GArun.initialPopulation(students, classes, population);
            childPop=population;
        }

        System.out.println("----------------------");
        System.out.println("GEN: " + generationCount++);

        if(!GArun.selection(childPop)) {
            generationCount=0;
        }

        System.out.println("BEST "+childPop.getBestScore());

        childPop = GArun.mating(childPop);
        childPop=GArun.mutation(childPop);

        childPop.setPopScore(maxScore);

        end=GArun.terminate(childPop);
      //  System.out.println(childPop.getBestScore());
        System.out.println("----------------------");



    }while(end==-1 && generationCount<10000);
    if(generationCount>9999){
        end=childPop.getBestIndex();
    }
 ///       System.out.println(childPop.getPopulation().get(0).get(0).getScore());

        for(Room room: childPop.getPopulation().get(end)) {

               System.out.println(room.getName());
               System.out.println(room.getScore());
               for (Student s : room.getStudentList()) {
        //        if(s.getConditionalAdmit()) {
                    System.out.println(s.getName() + "   " + s.getChoice1() + "   " + s.getChoice2() + "    " + s.getChoice3() + " " + s.getChoice4() + " " + s.getChoice5() + "  " + s.getConditionalAdmit());
          //      }

            }
       }

        /*Population population = new Population();
        ArrayList<RoomList> parents=new ArrayList<RoomList>();


        Student student = new Student();
        student.setName("Chris");
        student.setChoice1("Math");
        Student student1 = new Student();
        student1.setName("Marc");
        student1.setChoice1("Math");
        Student student2 = new Student();
        student2.setName("Aaron");
        student2.setChoice1("English");
        Student student3 = new Student();
        student3.setName("Trevor");
        student3.setChoice1("English");
        Student student4 = new Student();
        student4.setName("Ross");
        student4.setChoice1("English");
        Student student5 = new Student();
        student5.setName("Luke");
        student5.setChoice1("English");
        Student student6 = new Student();
        student6.setName("Matt");
        student6.setChoice1("English");
        Student student7 = new Student();
        student7.setName("Tristan");
        student7.setChoice1("English");
        Student student8 = new Student();
        student8.setName("Will");
        student8.setChoice1("English");

        Student student9 = new Student();
        student9.setName("Kyle");
        student.setChoice1("Math");
        Student student10 = new Student();
        student10.setName("Zoe");
        student10.setChoice1("Math");
        Student student12 = new Student();
        student12.setName("George");
        student12.setChoice1("English");
        Student student13 = new Student();
        student13.setName("Jorge");
        student13.setChoice1("English");
        Student student14 = new Student();
        student14.setName("Henry");
        student14.setChoice1("English");
        Student student15 = new Student();
        student15.setName("Jenna");
        student15.setChoice1("Math");
        Student student16 = new Student();
        student16.setName("Jack");
        student16.setChoice1("Math");
        Student student17 = new Student();
        student17.setName("Justin");
        student17.setChoice1("Math");
        Student student18 = new Student();
        student18.setName("Joe");
        student18.setChoice1("Math");

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);

        students.add(student9);
        students.add(student10);
        students.add(student12);
        students.add(student13);
        students.add(student14);
        students.add(student15);
        students.add(student16);
        students.add(student17);
        students.add(student18);


        Room room = new Room();
        Room room1 = new Room();
        room.setName("Math");
        room1.setName("English");


        classes.add(room);
        classes.add(room1);
        int studentsPerClass = students.size() / classes.size();

        room.setSizeAllowed(studentsPerClass);
        room1.setSizeAllowed(studentsPerClass);



     /*   for(ArrayList<Room> r: population.getPopulation()){
            for(Room rm : r){
                System.out.println(rm.getName());
                for(Student s : rm.getStudentList()){
                  System.out.println(s.getName());
                }
            }
        }*/
      /*
        GArun.initialPopulation(students, classes, population);
        Population childPop=population;
        int generationCount=0;
        int end;
       do {
            parents = GArun.selection(childPop);
           // System.out.println(bestTwo.fst.getRoomCollection().get(0).getStudentList());
         //   System.out.println(bestTwo.fst.getRoomCollection().get(1).getStudentList());
        //   childPop = GArun.mating(parents);

            childPop = GArun.mutation(childPop);
            System.out.println(generationCount++);
           end=GArun.terminate(childPop);
        }while(end==-1);

       for(Room rooms: population.getPopulation().get(end)){
           System.out.println(rooms.getName());
        for(Student winningStudents: rooms.getStudentList()){
            System.out.println(winningStudents.getName());
        }
       }







      /* for(int i=0; i<100; i++) {
           for (int j = 0; j < childPop.getPopulation().get(i).size(); j++) {
               System.out.println(childPop.getPopulation().get(i).get(j));
               System.out.println(childPop.getPopulation().get(i).get(j).getStudentList());
           }

       }*/


    }

}
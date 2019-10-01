

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int sheetNum=0;
        while(sheetNum<5) {
            Population population = new Population();
            Pair<ArrayList<Student>, ArrayList<Room>> firstGen = null;

            try {
                firstGen = ReadIn.readSheet(population);
            } catch (Exception e) {

            }


            ArrayList<Student> studentsOrg = firstGen.getKey();
            ArrayList<Room> classesWmcGill = firstGen.getValue();
            ArrayList<Room> classes = new ArrayList<Room>();
            ArrayList<Student> nullStudents = new ArrayList<Student>();
            ArrayList<Integer> indexToDelete = new ArrayList<Integer>();
            ArrayList<Integer> mcGills = new ArrayList<Integer>();
            ArrayList<Student> students = new ArrayList<Student>();


            for (Room room : classesWmcGill) {
                if (!room.getName().equalsIgnoreCase("mcgill-dan") && !room.getName().equalsIgnoreCase("mcgill-nancy"))
                    classes.add(room);
            }

            int index = 0;
            for (Student student : studentsOrg) {
                if (student.getChoice1() == null || student.getChoice1().equals("")) {
                    nullStudents.add(student);
                    indexToDelete.add(index);
                }
                if (student.getMcGill()) {
                    mcGills.add(index);
                    indexToDelete.add(index);
                }
                index++;
            }

            for (int i = 0; i < studentsOrg.size(); i++) {
                if (!indexToDelete.contains(i)) {
                    students.add(studentsOrg.get(i));
                }

            }
            // System.out.println(students.size());

            int studentsPerClass = students.size() / classes.size();
            double maxScore = students.size() * 5;

            population.setPopScore(maxScore);


            for (Room room : classes) {
                room.setSizeAllowed(studentsPerClass);
            }

            //System.out.println(students.size());

            Population parents = new Population();
            Population childPop = null;


            int generationCount = 0;
            int end = -1;
            int curscore = 0;
            do {
                if (generationCount == 0) {
                    GArun.initialPopulation(students, classes, population);
                    childPop = population;
                }

                System.out.println("----------------------");
                System.out.println("GEN: " + generationCount++);

                if (!GArun.selection(childPop)) {
                    generationCount = 0;
                }

                System.out.println("BEST " + childPop.getBestScore());

                childPop = GArun.mating(childPop);
                childPop = GArun.mutation(childPop);

                childPop.setPopScore(maxScore);

                end = GArun.terminate(childPop);
                //  System.out.println(childPop.getBestScore());
                System.out.println("----------------------");


            } while (end == -1 && generationCount < 10000);

               end = childPop.getBestIndex();
               System.out.println(childPop.getBestIndex());


      /*     while (!nullStudents.isEmpty()) {
                for (Room room : childPop.getPopulation().get(end)) {
                    room.getStudentList().add(nullStudents.get(0));
                    nullStudents.remove(0);
                    if (nullStudents.isEmpty()) {
                        break;
                    }
                }
            }*/


            TreeMap<String,ArrayList<Integer>> roomResults;
            roomResults = new TreeMap<String,ArrayList<Integer>>();

           for (Room room : childPop.getPopulation().get(end)) {
               int firstCount=0;
               int secondCount=0;
               int thirdCount=0;
               int fourthCount=0;
               int fifthCount=0;

               int athleteCount=0;
               int conditionalNotin=0;
               int maleCount=0;
               int femaleCount=0;
               int totalNotIn=0;
               ArrayList<Integer> results=new ArrayList<Integer>();

                System.out.println(room.getName());
               // System.out.println(room.getScore());
                for (Student s : room.getStudentList()) {
                    boolean correctClass=false;
                    if(room.getName().equalsIgnoreCase(s.getChoice1())){
                        firstCount++;
                        correctClass=true;
                    }else if(s.getChoice2().equalsIgnoreCase(room.getName())){
                        secondCount++;
                        correctClass=true;

                    }else if(s.getChoice3().equalsIgnoreCase(room.getName())){
                        thirdCount++;
                        correctClass=true;


                    }else if(s.getChoice4().equalsIgnoreCase(room.getName())){
                        fourthCount++;
                        correctClass=true;


                    }else if(s.getChoice5().equalsIgnoreCase(room.getName())){
                        fifthCount++;
                        correctClass=true;
                    }

                    if("m".equalsIgnoreCase(s.getGender())){
                        maleCount++;
                    }else  if("f".equalsIgnoreCase(s.getGender())){
                        femaleCount++;
                    }
                    if(!s.getSportPlayed().equalsIgnoreCase("")){
                        athleteCount++;
                    }
                    if(s.getConditionalAdmit() && !correctClass){
                        conditionalNotin++;
                    }
                    if(!correctClass){
                        totalNotIn++;
                    }
                }
                results.add(firstCount);
                results.add(secondCount);
                results.add(thirdCount);
                results.add(fourthCount);
                results.add(fifthCount);
                results.add(maleCount);
                results.add(femaleCount);
                results.add(athleteCount);
                results.add(conditionalNotin);
                results.add(totalNotIn);
                roomResults.put(room.getName(),results);

            }


            try {
                WriteOut.writeOut(childPop.getPopulation().get(end), sheetNum,roomResults);
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
            sheetNum++;
        }

    }
}
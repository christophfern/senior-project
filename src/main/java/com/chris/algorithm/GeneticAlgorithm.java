package com.chris.algorithm;

import com.chris.entities.Population;
import com.chris.entities.Room;
import com.chris.entities.RoomList;
import com.chris.entities.Student;

import java.util.ArrayList;
import java.util.Random;


public class GeneticAlgorithm {

    public static void initialPopulation(ArrayList<Student> students, ArrayList<Room> classList, Population population) {
        int numClass = classList.size();
        int randomClass;
        population.setPopNumber(1);
        population.setClassList(new ArrayList<ArrayList<Room>>());

        for (int j = 0; j < 100; j++) {
            ArrayList<Room> classes = new ArrayList<Room>();


            for (Room r : classList) {

                Room newRoom = new Room(r);
                classes.add(newRoom);
            }


            ArrayList<Integer> index = new ArrayList<Integer>();

            for (int i = 0; i < classes.size(); i++) {
                index.add(i);
            }

            Random random = new Random();

            for (Student student : students) {

                for (int i = 0; i < classes.size(); i++) {

                    if (classes.get(i).isFull()) {
                        int remove = index.indexOf(i);
                        if (remove >= 0) {

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


            population.addClass(classes);

        }

    }


    public static Population mating(Population parents) {


        Population childPop = new Population();

        for (int i = 0; i < 100; i++) {
            RoomList roomList = new RoomList();
            int score = 0;
            if (i <= 50) {

                for (Room room : parents.getPopulation().get(parents.getBestIndex())) {
                    Room copyRoom = new Room(room, true);
                    copyRoom.setStudentList((ArrayList<Student>) room.getStudentList().clone());
                    roomList.getRoomCollection().add(copyRoom);
                    score += room.getScore();

                }


            } else if (i <= 80) {
                for (Room room : parents.getPopulation().get(parents.getSecondBestIndex())) {
                    Room copyRoom = new Room(room, true);
                    copyRoom.setStudentList((ArrayList<Student>) room.getStudentList().clone());
                    roomList.getRoomCollection().add(copyRoom);
                    score += room.getScore();
                }

            } else {
                for (Room room : parents.getPopulation().get(parents.getThirdBestIndex())) {
                    Room copyRoom = new Room(room, true);
                    copyRoom.setStudentList((ArrayList<Student>) room.getStudentList().clone());
                    roomList.getRoomCollection().add(copyRoom);
                    score += room.getScore();
                }
            }
            childPop.addClass(roomList.getRoomCollection());

        }


        childPop.setBestScore(parents.getBestScore());
        childPop.setSecondaryScore(parents.getSecondaryScore());
        childPop.setTertiaryScore(parents.getTertiaryScore());
        System.out.println(childPop.getBestScore());
        System.out.println(childPop.getSecondaryScore());
        System.out.println(childPop.getTertiaryScore());

        return childPop;
    }

    public static boolean selection(Population population) {

        double curscore = population.getBestScore();
        double secondBest = population.getSecondaryScore();
        double thirdBest = population.getTertiaryScore();

        int index = 0;
        for (ArrayList<Room> pop : population.getPopulation()) {
            int bestscore = 0;
            for (Room room : pop) {
                room.calculateScore();
                if (room.getScore() == 0) {
                    break;
                }
                bestscore += room.getScore();
            }

            if (bestscore > curscore) {
                curscore = bestscore;
                if (curscore != 0) {

                }
                population.setBestIndex(index);
                population.setBestScore(bestscore);

            } else if (bestscore > secondBest && (index > 50 && index <= 80)) {
                secondBest = bestscore;
                population.setSecondBestIndex(index);
                population.setSecondaryScore(bestscore);
            } else if (bestscore > thirdBest && index > 80) {
                thirdBest = bestscore;
                population.setThirdBestIndex(index);
                population.setTertiaryScore(bestscore);
            }
            index++;
        }
        return !(population.getBestScore() < -20);
    }


    public static Population mutation(Population childPop) {
        int percentMutation = 10;
        Population mutatedChildren = new Population();
        Random random = new Random();
        int randNum;
        int randClass;
        int randStudent;
        int randStudent2;


        for (ArrayList<Room> list : childPop.getPopulation()) {


            ArrayList<Room> temp = new ArrayList<Room>();

            for (int i = 0; i < list.size(); i++) {

                randNum = random.nextInt(100);


                if (randNum < percentMutation) {

                    do {
                        randClass = random.nextInt(list.size());
                    } while (randClass == i);

                    randStudent = random.nextInt(list.get(i).getStudentList().size() - 1);
                    randStudent2 = random.nextInt(list.get(randClass).getStudentList().size() - 1);

                    if (list.get(randClass).getStudentList().size() < list.get(randClass).getSizeAllowed()) {

                        int randomTwo = random.nextInt(100);

                        if (randomTwo < 50 && !list.get(randClass).isFull()) {
                            changeStudentClass(list.get(i), list.get(randClass), list.get(i).getStudentList().get(randStudent));
                        } else {
                            swapStudents(list.get(i), list.get(randClass), randStudent, randStudent2);
                        }
                    }

                }


            }

            mutatedChildren.addClass(list);
        }

        return mutatedChildren;
    }


    public static int terminate(Population population) {
        double percentCorrect = 0.70;
        double targetScore = population.getPopScore() * 6;
        System.out.println(targetScore);
        int bestScore = 0;
        int index = 0;

        for (ArrayList<Room> pop : population.getPopulation()) {
            int bestscore = 0;
            for (Room room : pop) {
                room.calculateScore();

                if (room.getScore() == 0) {
                    return -1;
                }
                bestscore += room.getScore();

            }

            if (bestscore > targetScore) {
                population.setBestIndex(index);
                return index;
            }
            index++;
        }

        return -1;
    }

    private static void swapStudents(Room room1, Room room2, int student1, int student2) {

        Student hold = new Student(room2.getStudentList().get(student2));
        Student hold2 = new Student(room1.getStudentList().get(student1));
        room2.getStudentList().set(student2, hold2);
        room1.getStudentList().set(student1, hold);

    }

    private static void changeStudentClass(Room room1, Room room2, Student student) {
        room2.addStudent(student);
        room1.getStudentList().remove(student);
    }
}





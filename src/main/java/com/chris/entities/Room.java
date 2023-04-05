package com.chris.entities;

import java.util.ArrayList;

public class Room {
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private String name;
    private double score = 0.0;
    private int sizeAllowed;
    private boolean isFull = false;

    public Room() {

    }

    public Room(Room r) {
        this.name = r.getName();
        this.score = 0.0;
        this.studentList = new ArrayList<Student>();
        this.sizeAllowed = r.getSizeAllowed();
        this.isFull = r.isFull();

    }

    public Room(Room r, boolean Copy) {
        this.name = r.getName();
        this.score = r.score;
        this.studentList = new ArrayList<Student>();
        this.sizeAllowed = r.getSizeAllowed();
        this.isFull = r.isFull();
    }

    public void addStudent(Student s) {
        studentList.add(s);
        if (studentList.size() >= sizeAllowed) {
            setFull(true);
        }
    }

    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public int getSizeAllowed() {
        return sizeAllowed;
    }

    public void setSizeAllowed(int sizeAllowed) {
        this.sizeAllowed = sizeAllowed;
    }

    public String getName() {

        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public void calculateScore() {
        //gotta do this
        this.score = 0;
        int numberInFirst = 0;
        int numberInSecond = 0;
        int numberInthird = 0;
        int numberInfourth = 0;
        int numberInfifth = 0;
        int noCorrectChoice = 0;
        int mGenderScore = 0;
        int fGenderScore = 0;
        int mSoccerCount = 0;
        int fSoccerCount = 0;
        int footballCount = 0;
        int mGolfCount = 0;
        int fGolfCount = 0;
        int mBasketballCount = 0;
        int fBasketballCount = 0;
        int mCrossCountry = 0;
        int fCrossCountry = 0;
        int popGenderScore = 0;
        int popSportScore = 0;
        int conditionalIncorrect = 0;
        int whiteCount = 0;
        int internationalCount = 0;


        boolean conditional = false;

        for (Student curr : studentList) {
            noCorrectChoice = 0;
            boolean one = false;
            boolean two = false;
            boolean three = false;
            boolean four = false;
            boolean five = false;

            if ("football".equalsIgnoreCase(curr.getSportPlayed())) {
                footballCount++;
            } else if ("soccer".equalsIgnoreCase(curr.getSportPlayed())) {
                if (curr.getGender().equalsIgnoreCase("m")) {
                    mSoccerCount++;
                } else if (curr.getGender().equalsIgnoreCase("f")) {
                    fSoccerCount++;
                }
            } else if ("basketball".equalsIgnoreCase(curr.getSportPlayed())) {
                if (curr.getGender().equalsIgnoreCase("m")) {
                    mBasketballCount++;
                } else if (curr.getGender().equalsIgnoreCase("f")) {
                    fBasketballCount++;
                }
            } else if ("golf".equalsIgnoreCase(curr.getSportPlayed())) {
                if (curr.getGender().equalsIgnoreCase("m")) {
                    mGolfCount++;
                } else if (curr.getGender().equalsIgnoreCase("f")) {
                    fGolfCount++;
                }
            } else if ("cross country".equalsIgnoreCase(curr.getSportPlayed())) {
                if (curr.getGender().equalsIgnoreCase("m")) {
                    mCrossCountry++;
                } else if (curr.getGender().equalsIgnoreCase("f")) {
                    fCrossCountry++;
                }


            }
            if (curr.getConditionalAdmit()) {
                conditional = true;
            }
            if (this.name.equalsIgnoreCase(curr.getChoice1())) {
                numberInFirst++;
                one = true;

            } else if (this.name.equalsIgnoreCase(curr.getChoice2())) {
                numberInSecond++;
                two = true;
            } else if (this.name.equalsIgnoreCase(curr.getChoice3())) {
                numberInthird++;
                three = true;
            } else if (this.name.equalsIgnoreCase(curr.getChoice4())) {
                numberInfourth++;
                four = true;
            } else if (this.name.equalsIgnoreCase(curr.getChoice5())) {
                numberInfifth++;
                five = true;
            }

            if (!(one || two || three || four || five)) {
                noCorrectChoice++;
                //  System.out.println("HERE 1");
            }
            if (curr.getIsInternational()) {
                internationalCount++;
            }
            if (curr.getRace().equalsIgnoreCase("white")) {
                whiteCount++;
            }

            if ((one || two || three || four || five) && conditional) {
                conditionalIncorrect++;
                //  System.out.println("HERE 2");
            }
            //     System.out.println(curr.getGender());
            if ("m".equalsIgnoreCase(curr.getGender())) {
                mGenderScore++;
            } else {
                fGenderScore++;
            }


        }

        this.score = 6 * numberInFirst + 5 * numberInSecond + 4 * numberInthird + 3 * numberInfourth + 3 * numberInfifth - (15 * noCorrectChoice) + (10 * conditionalIncorrect);

        if (fGenderScore > this.studentList.size() * .70 || mGenderScore > this.getStudentList().size() * .70) {

            this.score = 0;
        } else if (fGenderScore > this.studentList.size() * .60 || mGenderScore > this.getStudentList().size() * .60) {
            popGenderScore++;
        }
        if (whiteCount >= this.getStudentList().size() - 2) {
            this.score = 0;
        }

        if (internationalCount == 1) {
            this.score = 0;
        }

        if (fSoccerCount > 10 || mBasketballCount > 10 || mCrossCountry > 10 || mGolfCount > 10 || mSoccerCount > 10 || fCrossCountry > 10 || fBasketballCount > 10 ||
                fGolfCount > 5 || footballCount > 10) {
            this.score = 0;
        } else if (fSoccerCount > 4 || mBasketballCount > 4 || mCrossCountry > 4 || mGolfCount > 4 | mSoccerCount > 4 || fCrossCountry > 4 || fBasketballCount > 4 ||
                fGolfCount > 4 || footballCount > 4) {
            popSportScore++;
        }

        this.score = this.score - popGenderScore - popSportScore;

    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double s) {
        this.score = s;
    }

    public void removeAll() {
        studentList = new ArrayList<Student>();
        score = 0.0;
        isFull = false;

    }

    public void swapStudents(Room switchRoom, int student, int student2) {
        Student hold = new Student(switchRoom.getStudentList().get(student2));
        Student hold2 = new Student(this.studentList.get(student));

        switchRoom.getStudentList().set(student2, hold2);

        this.getStudentList().set(student, hold);


    }


}
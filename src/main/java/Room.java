import java.util.ArrayList;

public class Room{
        private ArrayList<Student> studentList =new ArrayList<Student>();
        private String name;
        private double score=0.0;
        private int sizeAllowed;
        private boolean isFull=false;
            Room(){

            }

         Room(Room r){
            this.name=r.getName();
            this.score=0.0;
            this.studentList=new ArrayList<Student>();
            this.sizeAllowed=r.getSizeAllowed();
            this.isFull=r.isFull();

        }

    Room(Room r,boolean Copy){
        this.name=r.getName();
        this.score=r.score;
        this.studentList=new ArrayList<Student>();
        this.sizeAllowed=r.getSizeAllowed();
        this.isFull=r.isFull();
    }

        public void addStudent(Student s){
            studentList.add(s);
            if(studentList.size() >sizeAllowed){
                setFull(true);
            }
        }

        public ArrayList<Student> getStudentList(){
            return this.studentList;
        }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void setSizeAllowed(int sizeAllowed) {
        this.sizeAllowed = sizeAllowed;
    }

    public int getSizeAllowed() {
            return sizeAllowed;
        }



    public String getName() {

            return name;
        }

        public void setName(String n){
            this.name=n;
        }

        public boolean isFull() {
            return isFull;
        }

    public void setFull(boolean full) {
        isFull = full;
    }

    public void calculateScore(){
            //gotta do this
        this.score=0;
        int numberInFirst=0;
        int numberInSecond=0;
        int numberInthird=0;
        int numberInfourth=0;
        int numberInfifth =0;
        int conditionalInFirst=0;
        int noCorrectChoice=0;
        boolean conditional=false;

            for(Student curr: studentList){
                noCorrectChoice=0;
                boolean one=false;
                boolean two=false;
                boolean three=false;
                boolean four=false;
                boolean five=false;

                if(curr.getConditionalAdmit()){
                    conditional=true;
                }
                if(this.name.equalsIgnoreCase(curr.getChoice1())){
                    numberInFirst++;
                    one=true;

                }else if(this.name.equalsIgnoreCase(curr.getChoice2())){
                    numberInSecond++;
                    two=true;
                }else if(this.name.equalsIgnoreCase(curr.getChoice3())){
                    numberInthird++;
                    three=true;
                }else if(this.name.equalsIgnoreCase(curr.getChoice3())){
                    numberInfourth++;
                    four=true;
                }else if(this.name.equalsIgnoreCase(curr.getChoice3())) {
                    numberInfifth++;
                    five=true;
                }

               if(!(one || two || three || four || five)){
                    noCorrectChoice=1;
                 //  System.out.println("HERE 1");
                }

                if(!(one || two || three || four || five) && conditional){
                    noCorrectChoice=7;
                  //  System.out.println("HERE 2");
                }
            }
        this.score=5*numberInFirst+4*numberInSecond+3*numberInthird+numberInfourth+numberInfifth-(4*noCorrectChoice);


        }

        public void setScore(double s){
            this.score=s;
        }

        public double getScore(){
            return this.score;
        }

        public void removeAll(){
            studentList =new ArrayList<Student>();
            score=0.0;
            isFull=false;

        }

        public void swapStudents(Room switchRoom, int student, int student2){
                Student hold=new Student(switchRoom.getStudentList().get(student2));
                Student hold2=new Student(this.studentList.get(student));
           //  System.out.println(hold);
             //   System.out.println(this.studentList.get(student));

            //    System.out.println(switchRoom.getStudentList());
              //  System.out.println(this.studentList);
                switchRoom.getStudentList().set(student2,hold2);
             //   System.out.println(switchRoom.getStudentList());
                this.getStudentList().set(student,hold);
             //   System.out.println(this.studentList);


        }

}
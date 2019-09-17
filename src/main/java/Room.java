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
        this.studentList=r.getStudentList();
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
        for(Student curr: studentList){
            if(this.name.equalsIgnoreCase(curr.getChoice1())){
                this.score+=1.0;
            }
        }

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
                Student hold;

                hold=switchRoom.getStudentList().get(student2);

                switchRoom.getStudentList().set(student2,this.studentList.get(student));

                this.studentList.set(student,hold);

        }

}
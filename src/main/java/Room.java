import java.util.ArrayList;

public class Room{
        private ArrayList<Student> StudentList=new ArrayList<Student>();
        private String name;
        private float score;
        private int sizeAllowed;
        private boolean isFull=false;

        public void addStudent(Student s){
            StudentList.add(s);
            if(StudentList.size() >sizeAllowed){
                setFull(true);
            }
        }

        public ArrayList<Student> getStudentList(){
            return this.StudentList;
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

        }

        public float getScore(){
            return this.score;
        }

}
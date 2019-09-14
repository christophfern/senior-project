import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students=new ArrayList<Student>();
        ArrayList<Room> classes=new ArrayList<Room>();
        Population population=new Population();


        Student student=new Student();
        student.setName("Chris");
        Student student1=new Student();
        student1.setName("Marc");
        Student student2=new Student();
        student2.setName("Aaron");
        Student student3=new Student();
        student3.setName("Trevor");
        Student student4=new Student();
        student4.setName("Ross");
        Student student5=new Student();
        student5.setName("Luke");
        Student student6=new Student();
        student6.setName("Matt");
        Student student7=new Student();
        student7.setName("Tristan");
        Student student8=new Student();
        student8.setName("Will");


        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);


        Room room=new Room();
        Room room1=new Room();
        room.setName("Math");
        room1.setName("English");
        classes.add(room);
        classes.add(room1);
        int studentsPerClass=students.size()/classes.size();
        room.setSizeAllowed(studentsPerClass);
        room1.setSizeAllowed(studentsPerClass);
        GArun.initialPopulation(students,classes,population);

    for(Room r : classes){
        System.out.println(r.getName());
        for (Student s: r.getStudentList()) {
            System.out.println(s.getName());
        }
    }
    }

}
public class Student{

    private String name;
    private boolean isMcGill;
    private boolean isConditionalAdmit;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;
    private String choice6;
    private String gender;
    private boolean isAthlete;


    Student(){

    }

    Student(Student s){
        this.isAthlete=s.getAthlete();
        this.choice1=s.getChoice1();
        this.choice2=s.getChoice2();
        this.choice3=s.getChoice3();
        this.choice4=s.getChoice4();
        this.choice5=s.getChoice5();
        this.choice6=s.getChoice6();
        this.isConditionalAdmit=s.getConditionalAdmit();
        this.gender=s.getGender();
        this.name=s.getName();
        this.isMcGill=s.getMcGill();

    }
        public void setName(String n){
            this.name=n;
        }

        public String getName(){
            return this.name;
        }

        public void setMcGill(boolean tf){
            this.isMcGill=tf;
        }

        public boolean getMcGill(){
            return this.isMcGill;
        }

        public void setConditionalAdmit(boolean tf){
            this.isConditionalAdmit=tf;
        }

        public boolean getConditionalAdmit(){
            return this.isConditionalAdmit;
        }

        public void setChoice1(String choice){
            this.choice1=choice;
        }

        public String getChoice1(){
            return this.choice1;
        }

        public void setChoice2(String choice){
            this.choice2=choice;
        }

        public String getChoice2(){
            return this.choice2;
        }

        public void setChoice3(String choice){
            this.choice3=choice;
        }

        public String getChoice3(){
            return this.choice3;
        }

        public void setChoice4(String choice){
            this.choice4=choice;
        }

        public String getChoice4(){
            return this.choice4;
        }

        public void setChoice5(String choice){
            this.choice5=choice;
        }

        public String getChoice5(){
            return this.choice5;
        }

        public void setChoice6(String choice){
            this.choice6=choice;
        }

        public String getChoice6(){
            return this.choice6;
        }

        public void setGender(String gen){
            this.gender=gen;
        }

        public String getGender(){
            return this.gender;
        }

        public void setAthlete(boolean tf){
            this.isAthlete=tf;
        }

        public boolean getAthlete(){
            return this.isAthlete;
        }
}
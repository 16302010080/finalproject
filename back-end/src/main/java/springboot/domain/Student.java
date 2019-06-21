package springboot.domain;

public class Student {
    private int studentID;
    private String studentName;
    private String studentNickName;
    private int gender;
    private String email;
    private String avatarURL;

    public Student(){}

//    public Student(int studentID,String studentName,int gender,String email,String avatarURL){
//        this.studentName=studentName;
//        this.studentID=studentID;
//        this.gender=gender;
//        this.avatarURL=avatarURL;
//        this.email=email;
//    }
    public Student(int studentID,String studentName,String studentNickName,int gender,String email,String avatarURL){
        this.studentName=studentName;
        this.studentID=studentID;
        this.studentNickName=studentNickName;
        this.gender=gender;
        this.avatarURL=avatarURL;
        this.email=email;
    }

    public Student(int studentID,String studentName,String email,String avatarURL){
        this.studentName=studentName;
        this.studentID=studentID;
        this.gender=gender;
        this.email=email;
    }

    public Student(String studentNickName){
        this.studentNickName=studentNickName;
    }


    public int getStudentID(){
        return studentID;
    }
    public void setStudentID(int number){
        this.studentID=number;
    }


    public String getEMail(){
        return email;
    }
    public void setEMail(String email){
        this.email=email;
    }

    public int getGender(){return gender;}
    public void setGender(int gender){this.gender=gender;}

    public String getAvatarURL(){
        return avatarURL;
    }
    public void setAvatarURL(String avatarURL){
        this.avatarURL=avatarURL;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNickName() {
        return studentNickName;
    }

    public void setStudentNickName(String studentNickName) {
        this.studentNickName = studentNickName;
    }
}

package springboot.request;

public class StudentRegister {
    /**
     * 学号
     */
    private int studentID;
    /**
     * 姓名
     */
    private String studentName;

    private boolean gender;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 班级
     */
    private String avatarURL;


    public int getStudentID(){
        return studentID;
    }
    public void setStudentID(int number){
        this.studentID=number;
    }

    public String getName(){
        return studentName;
    }
    public void setName(String name){
        this.studentName=name;
    }

    public String getEMail(){
        return email;
    }
    public void setEMail(String email){
        this.email=email;
    }

    public boolean getGender(){return gender;}
    public void setGender(boolean gender){this.gender=gender;}

    public String getAvatarURL(){
        return avatarURL;
    }
    public void setAvatarURL(String avatarURL){
        this.avatarURL=avatarURL;
    }

}
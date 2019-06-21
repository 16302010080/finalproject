package springboot.domain;

public class Course {
    private int courseID;
    private String courseName;
    private String instruction;
    private String courseImageURL;
    private String introduction;
    private int price;
    private String startTime;
    private int studentID;
    private String studentNickName;

    public Course(){}
    public Course(String courseName, String instruction, String courseImageURL, String introduction, int price, String startTime) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instruction = instruction;
        this.courseImageURL = courseImageURL;
        this.introduction = introduction;
        this.price = price;
        this.startTime = startTime;
    }

    public Course(int courseID, int studentID) {
        this.courseID=courseID;
        this.studentID=studentID;
    }



    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCourseImageURL() {
        return courseImageURL;
    }

    public void setCourseImageURL(String courseImageURL) {
        this.courseImageURL = courseImageURL;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentNickName() {
        return studentNickName;
    }

    public void setStudentNickName(String studentNickName) {
        this.studentNickName = studentNickName;
    }
}

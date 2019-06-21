package springboot.response;

/**
 * Created by 董达芬 on 2019/6/20.
 */
public class CourseResponse {
    private int courseID;
    private String courseName;
    private String instruction;
    private String courseImageURL;
    private String introduction;
    private int price;
    private String startTime;
    private int teacherID;
    private String techName;
    private String process;
    private int studentID;
    private String studentNickName;

    public CourseResponse (){}
    public CourseResponse(int courseID,String courseName,String instruction,String courseImageURL,
                          String introduction,int price,String startTime,int teacherID, String techName,int studentID,String studentNickName ){
        this.courseID = courseID;
        this.courseName = courseName;
        this.instruction = instruction;
        this.courseImageURL = courseImageURL;
        this.introduction = introduction;
        this.price = price;
        this.startTime = startTime;
        this.teacherID=teacherID;
        this.techName=techName;
        this.studentID=studentID;
        this.studentNickName=studentNickName;
    }

    public CourseResponse(int courseID, int studentID, int teacherID,String process) {
        this.courseID=courseID;
        this.studentID=studentID;
        this.teacherID=teacherID;
        this.process=process;

    }
    public CourseResponse(int courseID, int studentID, int teacherID) {
        this.courseID=courseID;
        this.studentID=studentID;
        this.teacherID=teacherID;

    }
    public CourseResponse(int courseID,int teacherID,String studentNickName,String process) {
        this.courseID=courseID;
        this.studentNickName=studentNickName;
        this.teacherID=teacherID;
        this.process=process;


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

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getStudentNickName() {
        return studentNickName;
    }

    public void setStudentNickName(String studentNickName) {
        this.studentNickName = studentNickName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
    public int getTeachID() {
        return teacherID;
    }

    public void setTeachID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}

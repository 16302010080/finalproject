package springboot.request;

public class UserRegisterRequest {
    /**
     * 学号
     */
    private String student_number;
    /**
     * 姓名
     */
    private String student_name;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 班级
     */
    private String class_name;

    /**
     * 院系
     */
    private String department;

    /**
     * 简介
     */
    private String description;
    /**
     * 入学年份
     */
    private String start_year;
    /**
     * 毕业年份
     */
    private String graduate_year;

    public String getNumber(){
        return student_number;
    }
    public void setNumber(String number){
        this.student_number=number;
    }

    public String getName(){
        return student_name;
    }
    public void setName(String name){
        this.student_name=name;
    }

    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail=mail;
    }

    public String getClassName(){
        return class_name;
    }
    public void setClassName(String className){
        this.class_name=className;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getStart_year(){
        return start_year;
    }
    public void setStart_year(String start_year){
        this.start_year=start_year;
    }

    public String getGraduate_year(){
        return graduate_year;
    }
    public void setGraduate_year(String graduate_year){
        this.graduate_year=graduate_year;
    }

}
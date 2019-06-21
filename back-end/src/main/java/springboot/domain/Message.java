package springboot.domain;

public class Message {

    private int messageID;
    private int teacherID;
    private int studentID;
    private String content;
    private String sendTime;
    private int sender;

    public Message(){}
    public Message(int messageID, int sender, int teacherID, int studentID, String content, String sendTime){
        this.messageID=messageID;
        this.sender = sender;
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.content = content;
        this.sendTime = sendTime;
    }
    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }
}

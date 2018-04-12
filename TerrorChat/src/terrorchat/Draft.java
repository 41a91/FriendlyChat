/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terrorchat;


public class Draft {
 private String[] toUsername;
 private String fromUsername;
 private String subject;
 private String body;
 private long timeStamp;

    public Draft() {
        this.toUsername = null;
        this.fromUsername = null;
        this.subject = null;
        this.body = null;
        this.timeStamp = 0;
    }

    public Draft(String[] toUsernames, String fromUsername, String subject, String body, long timeStamp) {
        this.toUsername = toUsernames;
        this.fromUsername = fromUsername;
        this.subject = subject;
        this.body = body;
        this.timeStamp = timeStamp;
    }

    public String[] getToUsername() {
        return toUsername;
    }

    public void setToUsername(String[] toUsername) {
        this.toUsername = toUsername;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Message{" + "toUsername=" + toUsername.length + ", fromUsername=" + fromUsername + ", subject=" + subject + ", body=" + body + ", timeStamp=" + timeStamp + "}";
    }
    
    
 
 
 
}

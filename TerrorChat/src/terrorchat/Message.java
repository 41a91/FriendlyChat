/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terrorchat;


public class Message {
 private String toUsername;
 private String fromUsername;
 private String subject;
 private String body;
 private long timeStamp;
 private boolean read;

    public Message() {
        this.toUsername = null;
        this.fromUsername = null;
        this.subject = null;
        this.body = null;
        this.timeStamp = 0;
        this.read = false;
    }

    public Message(String toUsernames, String fromUsername, String subject, String body, long timeStamp, boolean read) {
        this.toUsername = toUsernames;
        this.fromUsername = fromUsername;
        this.subject = subject;
        this.body = body;
        this.timeStamp = timeStamp;
        this.read = read;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        String s = "";
        s += "From: " + fromUsername + "\n" + 
                "Subject: " + subject + "\n" + 
                "Time: " + timeStamp + "\n" +
                "Body: " + body + "\n\n";
        
        return s;
    }
    
    
 
 
 
}

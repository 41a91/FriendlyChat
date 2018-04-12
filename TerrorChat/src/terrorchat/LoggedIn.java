
package terrorchat;

import java.util.Date;


public class LoggedIn {
    String username;
    boolean loggedIn;
    long timestamp;

    public LoggedIn() {
        this.username = null;
        this.loggedIn = false;
        this.timestamp = 0;
    }

    public LoggedIn(String username) {
        this.username = username;
        this.loggedIn = true;
        this.timestamp = new Date().getTime();
    }

    public String getUsername() {
        return username;
    }
    
    public long getTimestamp()
    {
        return timestamp;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedin) {
        this.loggedIn = loggedin;
    }
    
    public void setTimestamp(long date)
    {
        this.timestamp = date;
    }

    @Override
    public String toString() {
        return "LoggedIn{" + "username=" + username + ", loggedIn=" + loggedIn + ", timestamp=" + timestamp + '}';
    }
    
}

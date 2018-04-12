/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terrorchat;

import java.util.Date;


public class User {
    private String username;
    private String password;
    private Date dateJoined;

    public User() {
        this.username = null;
        this.password = null;
        this.dateJoined = null;
    }

    public User(String username, String password, Date dateJoined) {
        this.username = username;
        this.password = password;
        this.dateJoined = dateJoined;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", dateJoined=" + dateJoined + '}';
    }
    
    
}

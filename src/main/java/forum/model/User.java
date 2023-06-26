package main.java.forum.model;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    public Integer uID;
    public String Name;
    public String Password;
    public String Email;
    public String Sex;
    public Date Birthday;
    public Integer PostNumber = 0;
    public Integer Level = 0;
    public Integer Authority = 0;
}

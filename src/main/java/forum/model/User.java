package main.java.forum.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    public Integer UID = 0;
    public String Name;
    public String Password;
    public String Email;
    public String Sex;
    public LocalDate Birthday;
    public Integer PostNumber = 0;
    public Integer Level = 0;
    public Integer Authority = 0;
}

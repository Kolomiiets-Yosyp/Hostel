package com.hotel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;

@Data
@NoArgsConstructor
public class Users {
    int id;
    String Log;
    String Pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLog() {
        return Log;
    }

    public void setLog(String log) {
        Log = log;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }



    public Users (int id, String Log, String Pass) {
        this.id=id;
        this.Log=Log;
        this.Pass=Pass;
    }



}

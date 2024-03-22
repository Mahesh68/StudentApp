package com.share.studentapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int sid;
    private String sname;

    public Student(final int sid, final String sname) {
        super();
        this.sid = sid;
        this.sname = sname;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sname=" + sname + "]";
    }
}

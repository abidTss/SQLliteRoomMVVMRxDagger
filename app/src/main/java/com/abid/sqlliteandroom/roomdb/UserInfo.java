package com.abid.sqlliteandroom.roomdb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by abid on 5/1/18.
 */
@Entity(tableName = "userInfo")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    private int EmpId;
    @ColumnInfo(name = "emp_first_name")
    private String emp_first_name;
    @ColumnInfo(name = "emp_last_name")
    private String emp_last_name;
    @ColumnInfo(name = "designamtion")
    private String designamtion;
    @ColumnInfo(name = "age")
    int age;

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public String getEmp_first_name() {
        return emp_first_name;
    }

    public void setEmp_first_name(String emp_first_name) {
        this.emp_first_name = emp_first_name;
    }

    public String getEmp_last_name() {
        return emp_last_name;
    }

    public void setEmp_last_name(String emp_last_name) {
        this.emp_last_name = emp_last_name;
    }

    public String getDesignamtion() {
        return designamtion;
    }

    public void setDesignamtion(String designamtion) {
        this.designamtion = designamtion;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

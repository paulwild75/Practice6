package com.shiryaev.pavel.bsbo_08_19.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public int salary;
}

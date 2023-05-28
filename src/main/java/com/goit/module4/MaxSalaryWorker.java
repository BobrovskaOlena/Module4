package com.goit.module4;

public class MaxSalaryWorker {
    private long id;
    private String name;
    private String birthday;
    private String level;
    private int salary;
    public MaxSalaryWorker(long id, String name, String birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
        this.id=id;
    }
}

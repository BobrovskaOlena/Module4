package com.goit.module4;

public class MaxSalaryWorker {
    private long id;
    private String name;
    private String birthday;
    private String levels;
    private int salary;
    public MaxSalaryWorker(long id, String name, String birthday, String levels, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.levels = levels;
        this.salary = salary;
        this.id=id;
    }
}

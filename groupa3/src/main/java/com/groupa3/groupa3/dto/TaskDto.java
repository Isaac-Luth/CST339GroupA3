package com.groupa3.groupa3.dto;

public class TaskDto {

    private long id;
    private String name;
    private String description;
    private double manHoursExpected;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setManHoursExpected(double manHoursExpected) {
        this.manHoursExpected = manHoursExpected;
    }

    public double getManHoursExpected() {
        return manHoursExpected;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TaskDto [id=" + id + ", name=" + name + ", description=" + description + ", manHoursExpected="
                + manHoursExpected + "]";
    }

}

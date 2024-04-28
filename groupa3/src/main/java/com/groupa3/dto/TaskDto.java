package com.groupa3.dto;

/**
 * Data transfer object for the task
 */
public class TaskDto {

    private long id;
    private String name;
    private String description;
    private double manHoursExpected;

    
    /** 
     *  Set the name of the task
     * @param name The name of the task
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     *  Get the name of the task
     * @return String The name of the task
     */
    public String getName() {
        return name;
    }

    
    /** 
     *  Set the description of the task
     * @param description The description of the task
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /** 
     *  Set the id of the task
     * @param id The id of the task
     */
    public void setId(long id) {
        this.id = id;
    }

    
    /** 
     *  Get the description of the task
     * @return String The description of the task
     */
    public String getDescription() {
        return description;
    }

    
    /** 
     *  Set the expected hours to complete the task
     * @param manHoursExpected The expected hours to complete the task
     */
    public void setManHoursExpected(double manHoursExpected) {
        this.manHoursExpected = manHoursExpected;
    }

    
    /** 
     *  Get the expected hours to complete the task
     * @return double The expected
     */
    public double getManHoursExpected() {
        return manHoursExpected;
    }

    
    /** 
     *  Get the id of the task
     * @return long The id of the task
     */
    public long getId() {
        return id;
    }

    
    /** 
     *  Get the string representation of the task
     * @return String The string representation of the task
     */
    @Override
    public String toString() {
        return "TaskDto [id=" + id + ", name=" + name + ", description=" + description + ", manHoursExpected="
                + manHoursExpected + "]";
    }

}

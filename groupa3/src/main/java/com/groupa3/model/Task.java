package com.groupa3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a task in the system.
 */
@Entity
public class Task {

    // Basic representation of a task object model,
    // Changes can be made later depending on the task needed.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double manHoursExpected; // Updated to use double for manHoursExpected
    private double manHoursUtilized; // Updated to use double for manHoursUtilized
    private boolean completed;

    // Constructors, getters, and setters

    /**
     * Default constructor.
     *
     */
    public Task() {
        // Default constructor
    }

    /**
     * Constructor with parameters to initialize the Task object.
     *
     * @param name             The name of the task.
     * @param description      The description of the task.
     * @param completed        The completion status of the task.
     * @param manHoursExpected The expected man hours for the task.
     * @param manHoursUtilized The utilized man hours for the task.
     */
    public Task(String name, String description, boolean completed, double manHoursExpected, double manHoursUtilized) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.manHoursExpected = manHoursExpected;
        this.manHoursUtilized = manHoursUtilized;
    }

    /**
     * Constructor with parameters to initialize the Task object.
     *
     * @param name             The name of the task.
     * @param description      The description of the task.
     * @param manHoursExpected The expected man hours for the task.
     */
    public Task(String name, String description, double manHoursExpected) {
        this.name = name;
        this.description = description;
        this.manHoursExpected = manHoursExpected;
    }

    /**
     * Get the ID of the task.
     *
     * @return The ID of the task.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the task.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the task.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the task.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the expected man hours of the task.
     *
     * @return The expected man hours of the task.
     */
    public double getManHoursExpected() {
        return manHoursExpected;
    }

    /**
     * Set the expected man hours of the task.
     *
     * @param manHoursExpected The expected man hours to set.
     */
    public void setManHoursExpected(double manHoursExpected) {
        this.manHoursExpected = manHoursExpected;
    }

    /**
     * Get the utilized man hours of the task.
     *
     * @return The utilized man hours of the task.
     */
    public double getManHoursUtilized() {
        return manHoursUtilized;
    }

    /**
     * Set the utilized man hours of the task.
     *
     * @param manHoursUtilized The utilized man hours to set.
     */
    public void setManHoursUtilized(double manHoursUtilized) {
        this.manHoursUtilized = manHoursUtilized;
    }

    /**
     * Check if the task is completed.
     *
     * @return True if the task is completed, false otherwise.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Set the completion status of the task.
     *
     * @param completed The completion status to set.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Returns a string representation of the Task object.
     *
     * @return A string representation of the Task object.
     */
    @Override
    public String toString() {
        return String.format(
                "Task{id=%d, name='%s', description='%s', manHoursExpected=%.2f, manHoursUtilized=%.2f, completed='%s'}",
                id, name, description, manHoursExpected, manHoursUtilized, completed);
    }
}

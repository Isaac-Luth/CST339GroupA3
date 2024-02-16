package com.groupa3.groupa3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    //Basic representation of a task object model,
    //Changes can be made later depending on the task needed.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
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
     * @param name        The name of the task.
     * @param description The description of the task.
     * @param completed   The completion status of the task.
     */
    public Task(String name, String description, boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
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
                "Task{id=%d, name='%s', description='%s', completed='%s'}",
                id, name, description, completed);
    }
}

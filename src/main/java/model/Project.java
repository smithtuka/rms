package model;

public class Project {
    private int id;
    private String projectName;
    private double budget;
    private int supervisorId;
    private String  description;

    public Project() {
    }

    public Project(String projectName, int supervisorId, double budget, String  description) {
        this.projectName = projectName;
        this.budget = budget;
        this.supervisorId = supervisorId;
        this.description = description;
    }

    public Project(int id, String projectName, double budget, int supervisorId, String description) {
        this.id = id;
        this.projectName = projectName;
        this.budget = budget;
        this.supervisorId = supervisorId;
        this.description = description;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getSupervisor() {
        return supervisorId;
    }

    public void setSupervisor(int supervisorId) {
        this.supervisorId = supervisorId;
    }
}

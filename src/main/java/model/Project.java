package model;

public class Project {
    private int id;
    private String projectName;
    private double budget;
    private String supervisor;
    private String  description;

    public Project() {
    }

    public Project(String projectName, String supervisor, double budget, String  description) {
        this.projectName = projectName;
        this.budget = budget;
        this.supervisor = supervisor;
        this.description = description;
    }

    public Project(int id, String projectName, double budget, String supervisor, String description) {
        this.id = id;
        this.projectName = projectName;
        this.budget = budget;
        this.supervisor = supervisor;
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

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
}

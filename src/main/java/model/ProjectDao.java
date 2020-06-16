package model;

import java.util.HashMap;
import java.util.Map;

public class ProjectDao {

    Map<Integer, Project> projectDb = new HashMap<>();

    //    public Project(String id, String projectName, double budget, int supervisorId, String description) {
//        this.id = id;
//        this.projectName = projectName;
//        this.budget = budget;
//        this.supervisorId = supervisorId;
//        this.description = description;
    {
        projectDb.put(0, new Project(0, "ROM WASHINGTON", 23000.00, 1, "Apartments"));
        projectDb.put(1, new Project(1, "KING FAHAD PLAZA", 45000.00, 2, "Plaza construction"));
        projectDb.put(2, new Project(2, "ROM WASHINGTON", 27000.00, 1, "Residential Complex"));
    }

    public int generateID() {
        return projectDb.size() + 1;
    }
}

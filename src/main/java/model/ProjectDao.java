package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDao {

    Map<Integer, Project> projectDb = new HashMap<>();


    {
        projectDb.put(0, new Project(0, "ROM WASHINGTON", 23000.00, 1, "Apartments"));
        projectDb.put(1, new Project(1, "KING FAHAD PLAZA", 45000.00, 2, "Plaza construction"));
        projectDb.put(2, new Project(2, "HAM TOWERS", 27000.00, 1, "Residential Complex"));
        projectDb.put(3, new Project(3, "REED TOWER", 27000.00, 1, "Residential Complex"));
    }


    public int generateID() {
        return projectDb.size() + 1;
    }

    public List<Project> getProjects() {
//    return (List<Project>)projectDb.values();
        return new ArrayList<Project>(projectDb.values());
    }

    public void saveProject(Project project) {
        projectDb.put(project.getId(), project);
    }

    public Project getProjectById(int id) {
        return projectDb.get(id);
    }

    public Map<Integer, Project> getProjectDb() {
        return projectDb;
    }


}

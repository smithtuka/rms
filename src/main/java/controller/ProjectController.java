package controller;

import com.google.gson.Gson;
import model.Project;
import model.ProjectDao;
import model.UserDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/project", urlPatterns = "/project")
public class ProjectController extends HttpServlet {
    ProjectDao projectDao;
    Gson mapper;
    UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        projectDao = new ProjectDao();
        mapper = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Project> projectList = projectDao.getProjects();
        req.getSession().setAttribute("projectList", projectList);
        req.getRequestDispatcher("/projects.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectData = req.getParameter("projects");
        Project[] projects = mapper.fromJson(projectData, Project[].class);
        for (Project p : projects) {
            p.setId(projectDao.generateID());
            projectDao.saveProject(p);
            System.out.println(p);
        }


    }

}

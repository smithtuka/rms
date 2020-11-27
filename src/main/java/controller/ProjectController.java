package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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

@WebServlet(name = "/project", urlPatterns = {"/project", "/project/*"})
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ext = req.getPathInfo(); // System.out.println(req.getContextPath());
        System.out.println(req.getContextPath());
        System.out.println(ext);
        ext= ext.replace("/", "");
        if(ext!=null){
            projectDao.deleteProject(ext);
//            resp.sendRedirect(ext.substring(0, ext.lastIndexOf('/')));//
            System.out.println("Project " +ext + " successfully deleted.");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ext = req.getPathInfo();
        System.out.println(ext);
//
       try {
           String projectData = req.getParameter("project");
           System.out.println(projectData);
           Project pjt = mapper.fromJson(projectData, Project.class);
           System.out.println(pjt.toString());
           System.out.println(pjt.toString());

           if (ext != null) {
//               projectDao.editProject(pjt, retrieveProjectId(req));
               System.out.println("Project " + retrieveProjectId(req) + " successfully edited.");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
        private static int retrieveProjectId(HttpServletRequest req) {
            String pathInfo = req.getPathInfo();
            if (pathInfo.startsWith("/")) {
                pathInfo = pathInfo.substring(1);
            }
            return Integer.parseInt(pathInfo);

        }

}


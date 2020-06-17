package controller;

import com.google.gson.Gson;
import model.Project;
import model.ProjectDao;
import model.Requisition;
import model.RequisitionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/requisition", "/requisition/*", "/requisition-form"})
public class RequisitionController extends HttpServlet {

    private RequisitionDao requisitionDao;
    private ProjectDao projectDao;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        requisitionDao = new RequisitionDao();
        projectDao = new ProjectDao();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Requisition> requisitionList = requisitionDao.getRequisitions();
        req.setAttribute("projects", projectDao.getProjectDb());
        req.setAttribute("requisitions", requisitionList);
        if (req.getServletPath().equals("/requisition-form")) {
            req.getRequestDispatcher("requisition_form.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("requisitions.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String jsonData = req.getParameter("requisition");
        Requisition requisition = gson.fromJson(jsonData, Requisition.class);
        requisition.setId(requisitionDao.generateID());
        requisition.setStatus("PENDING");
        requisition.setUserId(1);
        requisitionDao.saveRequisition(requisition);
        System.out.println(requisition);
        resp.sendRedirect("/requisition");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String s = req.getPathInfo();
        if (s != null) {
            s = s.replace("/", "");
            int id = Integer.parseInt(s);
            requisitionDao.deleteRequisitionById(id);
            resp.getWriter().print("successfully deleted");
        }
    }
}

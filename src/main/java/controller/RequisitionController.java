package controller;

import com.google.gson.Gson;
import model.Requisition;
import model.RequisitionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/requisition"})
public class RequisitionController extends HttpServlet {

    private RequisitionDao requisitionDao;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        requisitionDao = new RequisitionDao();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Requisition> requisitionList = requisitionDao.getRequisitions();
        req.setAttribute("requisitions", requisitionList);
        req.getRequestDispatcher("requisitions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = req.getParameter("requisition");
        Requisition requisition = gson.fromJson(jsonData, Requisition.class);
        requisition.setId(requisitionDao.generateID());
        requisition.setStatus("PENDING");
        requisition.setUserId(1);
        requisitionDao.saveRequisition(requisition);
        System.out.println(requisition);
        resp.sendRedirect("/requisition");
    }
}

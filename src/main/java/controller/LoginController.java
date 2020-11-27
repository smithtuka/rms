package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.User;
import model.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private UserDao userDao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean toEdit  = mapper.fromJson(request.getParameter("edit"), Boolean.class);

        if(toEdit == true) {
            int updateId =  mapper.fromJson(request.getParameter("user"), User.class).getUserId();
            String updateEmail =  mapper.fromJson(request.getParameter("user"), User.class).getEmail();
            String updateUsername =  mapper.fromJson(request.getParameter("user"), User.class).getUsername();
            String updatePassword =  mapper.fromJson(request.getParameter("user"), User.class).getPassword();
                    for( User user: userDao.getUser()) {
                        if(user.getUserId() == updateId) {
                            user.setEmail(updateEmail);
                            user.setUsername(updateUsername);
                            user.setPassword(updatePassword);
                        }

            }
        } else if(toEdit == false) {
            System.out.println("Login ");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDao.findUserByEmail(email, password);
            if (user != null) {
                System.out.println("User: " + user.getEmail());
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("gm","greatt ...");
        request.getRequestDispatcher("/login.jsp").forward(request, response); // login.jsp
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson mapper = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        System.out.println("Here me say -1: " + reader.lines().collect(Collectors.joining()));
        String sample = reader.lines().collect(Collectors.joining());
        Pattern pattern1 = Pattern.compile("\\=(.+)(?=\\&)");
        Pattern pattern2 = Pattern.compile("d\\=(.+)");

        Matcher matcher1 = pattern1.matcher(sample);
        Matcher matcher2 = pattern2.matcher(sample);
        System.out.println("Password" + sample.replaceFirst("\\:\\\"(.+)(?=\\\")", "$1"));

        User james =  mapper.fromJson(reader.lines().collect(Collectors.joining()), User.class);
        System.out.println("Here me say 1: " + james.getEmail());


        ;

    }
}

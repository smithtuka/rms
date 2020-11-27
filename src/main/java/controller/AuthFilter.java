package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"", "/profile.jsp", "/projects.jsp", "/requisition",
        "/requisitions.jsp", "/requisition-form", "/project", "/project-form.jsp"})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest rq = (HttpServletRequest) req;
        HttpSession session = rq.getSession(false);

        if(session.getAttribute("user") != null) {
            chain.doFilter(req, resp);
        }else {
            HttpServletResponse bwana = (HttpServletResponse) resp;
            bwana.sendRedirect("/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

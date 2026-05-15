package Controllers;

import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;

@WebServlet("/main")
public class IndexController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        String page = req.getParameter("p");
        
        if (page == null || page.equals("home") || page.equals("details")) {
            req.getRequestDispatcher("/MainServlet").forward(req, res);
            return;
        }
        
        String viewToLoad = "";
        
        switch (page){
            case "category": 
                req.getRequestDispatcher("/CategoryServlet").forward(req, res);
                return;
            case "read": 
                req.getRequestDispatcher("/ReadServlet").forward(req, res);
                return;
            case "saved": 
                viewToLoad = "/WEB-INF/Views/Saved.jsp";
                break;
            case "downloaded": 
                viewToLoad = "/WEB-INF/Views/Downloaded.jsp";
                break;
            case "discover": 
                req.getRequestDispatcher("/DiscoverServlet").forward(req, res);
                return;
            case "login": 
                viewToLoad = "/WEB-INF/Views/Login.jsp";
                break;
            case "register": 
                viewToLoad = "/WEB-INF/Views/Register.jsp";
                break;
            default:
                req.getRequestDispatcher("/MainServlet").forward(req, res);
                return;
        }
        
        req.setAttribute("viewToLoad", viewToLoad);
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
}

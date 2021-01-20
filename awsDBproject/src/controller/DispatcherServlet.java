package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private RequestMapping rm;

    @Override
    public void init() throws ServletException {
        rm = new RequestMapping();
        rm.initMapping();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
    	
    	String contextPath = request.getContextPath();
    	String servletPath = request.getServletPath();
    	
        Controller controller = rm.findController(servletPath);
        try {
            String uri = controller.execute(request, response);
            System.err.println(uri);
            if (uri == null)
            	return;

            if (uri.startsWith("redirect:")) {	
            	String targetUri = contextPath + uri.substring("redirect:".length());
            	response.sendRedirect(targetUri);        
            }
            else {
            	RequestDispatcher rd = request.getRequestDispatcher(uri);
                rd.forward(request, response);
            }                   
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}

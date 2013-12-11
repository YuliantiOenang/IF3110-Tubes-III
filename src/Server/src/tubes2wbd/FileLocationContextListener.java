package tubes2wbd;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

 
public class FileLocationContextListener implements ServletContextListener {
 
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String rootPath = System.getProperty("catalina.home");
        ServletContext ctx = servletContextEvent.getServletContext();
        String relativePath = ctx.getInitParameter("tempfile.dir");
        File file = new File(rootPath + File.separator + relativePath);
        if(!file.exists()) file.mkdirs();
        System.out.println("File Directory created to be used for storing files");
        ctx.setAttribute("images", file);
        ctx.setAttribute("images", rootPath + File.separator + relativePath);
    }
 
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //do cleanup if needed
    }
     
}

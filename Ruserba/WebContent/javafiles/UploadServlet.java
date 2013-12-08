package javafiles;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

}

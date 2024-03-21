package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDao;
import model.Product;

@WebServlet("/ProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024
* 512)
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();

	}
	
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("addtoproduct")) 
		{
			String savePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\Advance JAVA (Assesment)\\src\\main\\webapp\\images";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\Advance JAVA (Assesment)\\src\\main\\webapp\\images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        
	        Product p = new Product();
	        p.setPname(request.getParameter("pname"));
	        p.setPcategory(request.getParameter("pcategory"));
	        p.setPmodel(request.getParameter("pmodel"));
	        p.setPprice(Long.parseLong(request.getParameter("pprice")));
	        p.setPdesc(request.getParameter("pdesc"));
	        p.setImage(fileName);
	        System.out.println(p);
	        ProductDao.addProduct(p);
	        response.sendRedirect("index.jsp");
		}
		
		else if(action.equalsIgnoreCase("update")) 
		{
			Product p = new Product();
			p.setPname(request.getParameter("pname"));
			p.setPcategory(request.getParameter("pcategory"));
			p.setPmodel(request.getParameter("pmodel"));
			p.setPprice(Long.parseLong(request.getParameter("pprice")));
			p.setPdesc(request.getParameter("pdesc"));
			ProductDao.updateProduct(p);
			response.sendRedirect("view-product.jsp");
		}
	}

}

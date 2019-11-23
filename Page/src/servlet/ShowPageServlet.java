package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PeopleService;
import pojo.PageInfo;
import serviceImpl.PeopleServiceImpl;
@WebServlet("/page")
public class ShowPageServlet extends HttpServlet{
	private PeopleService peopleService = new PeopleServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//第一次访问的验证，如果没有传递参数，设置默认值
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 2;
		if(pageSizeStr!=null&&pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(req.getParameter("pageSizeStr"));
		}
		
		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberStr!=null&&pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(req.getParameter("pageNumberStr"));
		}
		
		PageInfo pi = peopleService.showPage(pageSize, pageNumber);
		req.setAttribute("PageInfo", pi);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
	}
}

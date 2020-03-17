package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import atm.ATM;



/**
* 验证密码
* @author  何希
* @version 10/06/2018
*/
public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面密码
		int pwd = Integer.valueOf(req.getParameter("num"));
		//判断密码正确性
		ATM.getInstance().getSession().auth(pwd);
		
		String json = ATM.getInstance().getResponse();
		resp.setContentType("text/json");  
		resp.setCharacterEncoding("UTF-8"); 
		resp.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}

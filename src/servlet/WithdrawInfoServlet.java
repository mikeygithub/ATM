package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import atm.ATM;

/**
* 获取取款金额,执行扣款
* @author  何希
* @version 10/06/2018
*/
public class WithdrawInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面取款金额
		int num = Integer.parseInt(req.getParameter("num"));
		//设置即将取款金额
		ATM.getInstance().getSession().getTransaction().setAmount(num);
		//执行取款
		ATM.getInstance().getSession().getTransaction().execute(req);
		String json = ATM.getInstance().getResponse();
		resp.setContentType("text/json");  
		resp.setCharacterEncoding("UTF-8"); 
		resp.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}

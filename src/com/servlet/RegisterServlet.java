package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JDBCDemo;
import com.entity.User;
import com.test.MailDemo;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String verifycode = request.getParameter("code");
		String text = (String) request.getSession().getAttribute("text");
		if (!verifycode.equalsIgnoreCase(text)) {
			request.setAttribute("message", "验证码错误");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		JDBCDemo jdbcDemo = new JDBCDemo();
		try {
			boolean flag = jdbcDemo.findByName(user);
			if (flag == true) {
				request.setAttribute("message", "该用户名已被注册！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}

			int result = jdbcDemo.insertUser(user);
			if (result == 1) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				MailDemo.sendEmail(user);
			} else {
				request.setAttribute("message", "注册失败！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Register;
import model.RegisterLogic;

/** Controller */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Model[Register.java]からインスタンス生成
		// 引数のString型userIdとString型passを、リクエストパラメータから取得する
		String userId= request.getParameter("userId");
		String pass= request.getParameter("pass");
		String message= request.getParameter("message");
		int age=  Integer.parseInt(request.getParameter("age"));
		Register register= new Register(userId, pass, message, age);
		
		// DBと接続してログイン試行 BO[RegisterLogic.java]を呼び出す 引数：Register型インスタンス　戻り値：boolean
		RegisterLogic bo= new RegisterLogic();
		boolean result= bo.execute(register);
		
		// 画面遷移　boからの戻り値boolean型resultの値によって振り分ける
		if(result) {
			// セッションスコープに.setAttributeでString型userIdをを格納
			HttpSession session= request.getSession();
//			session.setAttribute("userId", userId);
			session.setAttribute("register", register);
			
			// View[loginOK.jsp]にforward
			RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/registerOK.jsp");
			dispatcher.forward(request, response);
		}else {
			// redirect
//			response.sendRedirect("Register");

			// View[loginNG.jsp]にforward
			RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/registerNG.jsp");
			dispatcher.forward(request, response);	
		}
	}

}

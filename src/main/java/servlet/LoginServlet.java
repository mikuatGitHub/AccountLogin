package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.LoginLogic;

/** Controller */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Model[Login.java]からインスタンス生成
		// 引数のString型userIdとString型passを、リクエストパラメータから取得する
		String userId= request.getParameter("userId");
		String pass= request.getParameter("pass");
		Login login= new Login(userId, pass);
		
		// DBと接続してログイン試行 BO[LoginLogic.java]を呼び出す 引数：Login型インスタンス　戻り値：boolean
		LoginLogic bo= new LoginLogic();
		boolean result= bo.execute(login);
		
		// 画面遷移　BOの戻り値boolean型resultの値によって振り分ける
		if(result) {
			// セッションスコープに.setAttributeでString型userIdをを格納
			HttpSession session= request.getSession();
			session.setAttribute("login", login);
			
			// View[loginOK.jsp]にforward
			RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
		}else {
			// redirect
			response.sendRedirect("Login");
		}

	}

}

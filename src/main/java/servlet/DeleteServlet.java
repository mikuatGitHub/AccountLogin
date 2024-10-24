package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Delete;
import model.DeleteLogic;

/** Controller */
@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/delete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Model[Delete.java]からインスタンス生成
		// 必要な引数をリクエストパラメータから取得
		String userId= request.getParameter("userId");
		Delete delete= new Delete(userId);
		
		// DBと接続してログイン試行 BO[RegisterLogic.java]を呼び出す 引数：Register型インスタンス　戻り値：boolean
		DeleteLogic bo= new DeleteLogic();
		boolean result= bo.execute(delete);
		
		// 画面遷移　BOの戻り値boolean型resultの値によって振り分ける
		if(result) {
			// セッションスコープに.setAttributeでString型userIdをを格納
			HttpSession session= request.getSession();
			session.setAttribute("delete", delete);
			
			// View[deleteOK.jsp]にforward
			RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/deleteOK.jsp");
			dispatcher.forward(request, response);
		}else {
			// redirect
			response.sendRedirect("Delete");
		}

	}

}

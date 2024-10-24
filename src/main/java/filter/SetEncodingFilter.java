package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Filter */
@WebFilter("/*") /* 全てのサーブレットクラスに適用 */
public class SetEncodingFilter extends HttpFilter {
	// HttpFilterが持つdoFilterメソッドは、対象のサーブレットがリクエストされた時に自動で実行する
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		// ↑前処理
		chain.doFilter(request, response);
		// ↓後処理
		
	}

}

package model;

import dao.AccountsDAO;

// BOビジネスオブジェクト
public class LoginLogic {
	
	// メソッドexecute() 引数：Login型インスタンス 戻り値：boolean
	public boolean execute(Login login) {
		AccountsDAO dao= new AccountsDAO();
		
		// DAOメソッドにLogin型インスタンスをsend
		// DAOメソッドからAccount型インスタンスをReceive
		Account account= dao.findByLogin(login);
		
		// booleanを戻す演算
		return account != null;
	}

}

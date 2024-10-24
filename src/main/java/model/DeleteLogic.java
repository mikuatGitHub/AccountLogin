package model;

import dao.AccountsDAO;

// BOビジネスオブジェクト
public class DeleteLogic {
	
	// メソッドexecute() 引数：Delete型インスタンス 戻り値：boolean
	public boolean execute(Delete delete) {
		AccountsDAO dao= new AccountsDAO();
		
		// DAOメソッドにDelete型インスタンスをsend
		// DAOメソッドからbooleanをReceive
		return dao.deleteAccount(delete);
		
	}

}

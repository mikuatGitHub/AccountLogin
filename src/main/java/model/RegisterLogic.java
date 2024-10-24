package model;

import dao.AccountsDAO;

// BOビジネスオブジェクト
public class RegisterLogic {
	
    // メソッドexecute() 引数：Register型インスタンス 戻り値：boolean
    public boolean execute(Register register) {
		AccountsDAO dao= new AccountsDAO();
		
		// DAOメソッドにRegister型インスタンスをSend
		// DAOメソッドからbooleanをReceive
        return dao.createAccount(register);
        
    }
}

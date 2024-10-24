package test;

import dao.AccountsDAO;
import model.Account;
import model.Delete;
import model.Login;
import model.Register;

// DAOの各メソッドの引数と戻り値が意図した通りのルーティングになっているかテストするためのクラス
public class AccountsDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK();
		testFindByLoginNG();
		testCreateAccountOK();
		testCreateAccountNG();
		testDeleteAccountOK();
		testDeleteAccountNG();
	}
	
	// 引数Login型インスタンスが適切なら、戻り値Account型インスタンスを適切に取得
	public static void testFindByLoginOK() {
		AccountsDAO dao= new AccountsDAO();
		Login login= new Login("miku", "1234");
		Account result= dao.findByLogin(login);
		
		if(
			result != null &&
			result.getUserId().equals("miku") &&
			result.getPass().equals("1234") &&
			result.getMessage().equals("hello") &&
			result.getAge() == 30
		) {
			System.out.println("testFindByLoginOK|成功");
		} else {
			System.out.println("testFindByLoginOK|失敗");			
		}
	}
	// 引数Login型インスタンスが不適切なら、戻り値Account型インスタンスはnull
	public static void testFindByLoginNG() {
		AccountsDAO dao= new AccountsDAO();
		Login login= new Login("miku", "12345");
		Account result= dao.findByLogin(login);
		
		if(result == null) {
			System.out.println("testFindByLoginNG|成功");
		} else {
			System.out.println("testFindByLoginNG|失敗");			
		}
	}
	
	// 引数Register型インスタンスが適切なら、戻り値はfalse
	public static void testCreateAccountOK() {
		AccountsDAO dao= new AccountsDAO();
		Register register= new Register("mikumiku", "1234", "hello", 30);
		boolean result= dao.createAccount(register);
		
		if(result) {
			System.out.println("testCreateAccountOK|成功");
		} else {
			System.out.println("testCreateAccountOK|失敗");			
		}
	}	
	// 引数Register型インスタンスが不適切なら、戻り値はfalse
	public static void testCreateAccountNG() {
		AccountsDAO dao= new AccountsDAO();
		Register register= new Register("miku", "1234", "", 30);
		boolean result= dao.createAccount(register);
		
		if(!result) {
			System.out.println("testCreateAccountNG|成功");
		} else {
			System.out.println("testCreateAccountNG|失敗");			
		}
	}
 
	//　引数Delete型インスタンスが適切なら、戻り値はtrue
	public static void testDeleteAccountOK() {
		AccountsDAO dao= new AccountsDAO();
		Delete delete= new Delete("mikumiku");
		boolean result= dao.deleteAccount(delete);
		
		if(result) {
			System.out.println("testDeleteAccountOK|成功");
		} else {
			System.out.println("testDeleteAccountOK|失敗");			
		}	
	}
	// 引数Delete型インスタンスが不適切なら、戻り値はfalse
	public static void testDeleteAccountNG() {
		AccountsDAO dao= new AccountsDAO();
		Delete delete= new Delete("mikku");
		boolean result= dao.deleteAccount(delete);
		
		if(!result) {
			System.out.println("testDeleteAccountOK|成功");
		} else {
			System.out.println("testDeleteAccountOK|失敗");			
		}	
	}
	
}



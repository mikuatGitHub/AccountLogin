package test;

import model.Login;
import model.LoginLogic;

// BOのメソッドexecute()　引数：Login型インスタンス　戻り値：boolean
public class LoginLogicTest {
	public static void main(String[] args) {
		testExecuteOK();
		testExecuteNG();
	}
	
	// 引数Login型インスタンスが適切なら、戻り値boolean型resultはtrueを持つ
	public static void testExecuteOK() {
		LoginLogic bo= new LoginLogic();
		Login login= new Login("miku", "1234");
		boolean result= bo.execute(login);
		
		if(result) {
			System.out.println("testExecuteOK|成功");
		}else {
			System.out.println("testExecuteOK|失敗");			
		}
	}
	
	//　引数Login型インスタンスが不適切なら、戻り値boolean型resultはfalseを持つ
	public static void testExecuteNG() {
		LoginLogic bo= new LoginLogic();
		Login login= new Login("miku", "12345");
		boolean result= bo.execute(login);
		
		if(!result) {
			System.out.println("testExecuteNG|成功");
		}else {
			System.out.println("testExecuteNG|失敗");			
		}
	}

}

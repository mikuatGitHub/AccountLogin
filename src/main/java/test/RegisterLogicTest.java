package test;

import model.Register;
import model.RegisterLogic;

// BO[RegisterLogic.java]のメソッドexecute　引数：Register型インスタンス　戻り値：boolean
public class RegisterLogicTest {
	public static void main(String[] args) {
		testExecuteOK();
		testExecuteNG();
	}
	
	// 引数Register型インスタンスが適切なら、戻り値boolean型resultはtrue
	public static void testExecuteOK() {
		RegisterLogic bo= new RegisterLogic();
		Register register= new Register("mikku", "1234", "goodnight", 30);
		boolean result= bo.execute(register);
		
		if(result) {
			System.out.println("testExecuteOK|成功");
		}else {
			System.out.println("testExecuteOK|失敗");			
		}
	}
	
	//　引数Register型インスタンスが不適切なら、戻り値boolean型resultはfalse
	public static void testExecuteNG() {
		RegisterLogic bo= new RegisterLogic();
		Register register= new Register("", "1234", "", 30);
		boolean result= bo.execute(register);
		
		if(!result) {
			System.out.println("testExecuteNG|成功");
		}else {
			System.out.println("testExecuteNG|失敗");			
		}
	}

}

package test;

import model.Delete;
import model.DeleteLogic;

// BOのメソッドexecute()　引数：Delete型インスタンス　戻り値：boolean
public class DeleteLogicTest {
	public static void main(String[] args) {
		testExecuteOK();
		testExecuteNG();
	}
	
	// 引数Delete型インスタンスが適切なら、
	public static void testExecuteOK() {
		DeleteLogic bo= new DeleteLogic();
		Delete delete= new Delete("mikku");
		boolean result= bo.execute(delete);
		
		if(result) {
			System.out.println("testExecuteOK|成功");
		}else {
			System.out.println("testExecuteOK|失敗");			
		}
	}
	
	//　引数Delete型インスタンスが不適切なら,
	public static void testExecuteNG() {
		DeleteLogic bo= new DeleteLogic();
		Delete delete= new Delete("mikkyu");
		boolean result= bo.execute(delete);
		
		if(!result) {
			System.out.println("testExecuteNG|成功");
		}else {
			System.out.println("testExecuteNG|失敗");			
		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Delete;
import model.Login;
import model.Register;

public class AccountsDAO {
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/login";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    // JDBCドライバをstaticで読み込み
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
        }
    }

    
    // findByLogin 引数：Login型インスタンス　戻り値：Account型インスタンス
    public Account findByLogin(Login login) {
    	// 戻り値をリセット
        Account account = null;

        // connection sql
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT USER_ID, PASS, MESSAGE, AGE FROM ACCOUNTS WHERE USER_ID=? AND PASS=?";
            try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
                pStmt.setString(1, login.getUserId());
                pStmt.setString(2, login.getPass());
                ResultSet rs = pStmt.executeQuery();

                if (rs.next()) {
                    account = new Account(
                        rs.getString("USER_ID"),
                        rs.getString("PASS"),
                        rs.getString("MESSAGE"),
                        rs.getInt("AGE")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return account;
    }

    // createAccount 引数：Register型インスタンス　戻り値：boolean
    public boolean createAccount(Register register) {
        // Connection
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
        	
            // UserIDの重複チェック
            String checkSql = "SELECT COUNT(*) FROM ACCOUNTS WHERE USER_ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, register.getUserId());
                
                ResultSet checkRs = checkStmt.executeQuery();

                if (checkRs.next() && checkRs.getInt(1) > 0) {
//                    throw new SQLException("User ID already exists.");
                    return false;
                }
            }

            // INSERT
            String insertSql = "INSERT INTO ACCOUNTS(USER_ID, PASS, MESSAGE, AGE) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, register.getUserId());
                insertStmt.setString(2, register.getPass());
                insertStmt.setString(3, register.getMessage());
                insertStmt.setInt(4, register.getAge());

                int result = insertStmt.executeUpdate();/* 更新された行数を格納 */
                if (result != 1) {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // deleteAccount 引数：Delete型インスタンス　戻り値：boolean
    public boolean deleteAccount(Delete delete) {
        // Connection
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            
            // UserIDの存在チェック
            String checkSql = "SELECT COUNT(*) FROM ACCOUNTS WHERE USER_ID = ?";
            
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, delete.getUserId());
                
                ResultSet checkRs = checkStmt.executeQuery();
                
                if (checkRs.next() && checkRs.getInt(1) > 0) {
                    // ユーザーIDが存在する場合、削除を実行
                    String deleteSql = "DELETE FROM ACCOUNTS WHERE USER_ID = ?";
                    try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                        deleteStmt.setString(1, delete.getUserId());
                        
                        int result = deleteStmt.executeUpdate();
                        
                        return result > 0; // 削除が成功した場合はtrueを返す
                    }
                } else {
                    // ユーザーIDが存在しない場合
                    return false;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラーが発生した場合もfalseを返す
        }
    }

}

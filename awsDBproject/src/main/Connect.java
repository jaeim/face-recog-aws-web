package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://face-recog-db-dev.ckeffyuykcfz.ap-northeast-2.rds.amazonaws.com:3306/management";
	private final String USER = "admin";
	private final String PW = "12345678";
	
	public void test() {
		try {
            Class.forName(DRIVER);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(URL, USER, PW)){
            
            // 연결이 성공하면 con 객체의 주소값이 찍힘
            System.out.println(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}

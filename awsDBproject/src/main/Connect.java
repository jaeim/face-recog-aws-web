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
            
            // ������ �����ϸ� con ��ü�� �ּҰ��� ����
            System.out.println(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}

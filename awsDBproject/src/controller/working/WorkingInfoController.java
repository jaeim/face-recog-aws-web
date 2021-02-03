package controller.working;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;
import controller.Controller;

public class WorkingInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String reqStr = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[2000];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		reqStr = stringBuilder.toString();
//		System.out.println(reqStr);
		
		JSONParser parser = new JSONParser(reqStr);
		LinkedHashMap obj = (LinkedHashMap) parser.parse();
		
		ArrayList<LinkedHashMap> workInfoList = (ArrayList<LinkedHashMap>) obj.get("working_info");
		String id = (String) obj.get("id");
		String logData = (String) obj.get("log_data");
		
		System.out.println(workInfoList);
		System.out.println(id);
		System.out.println(logData);
		
		// 근무정보 db 저장 테스트 (로그는 앞서 저장되어 db에 존재한다고 가정)
		// id를 통해 멤버 기본키를 알아냈다고 가정
		// *오류 : LinkedHashMap에서 키를 통해 값을 얻어내는 데 실패.. 
		for(LinkedHashMap list : workInfoList) {
			System.out.println(list.get("date_time"));
			System.out.println(list.get("work_type"));
			System.out.println(list.get("total_time"));
			System.out.println(list.get("work_time"));
			System.out.println(list.get("not_work_time"));
		}
	
		
		return "/working/getInfo.jsp";
	}

}

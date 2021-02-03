package controller.working;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;
import controller.Controller;
import model.LogInfo;
import model.Member;
import model.WorkingInfo;
import model.service.Manager;

public class GetClientInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
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
		String logCreated = (String) obj.get("log_created");
		
		System.out.println(workInfoList);
		System.out.println(id);
		System.out.println(logData);
		System.out.println(logCreated);
		
		Timestamp logTimeStamp = Timestamp.valueOf(logCreated);
		// 로그 db 저장 테스트
		Member member = manager.getOneMemberByLoginId(id);
		LogInfo logInfo = new LogInfo();
		logInfo.setCREATED_DT(logTimeStamp);
		logInfo.setCONTENT(logData.getBytes());
		logInfo.setTITLE(logCreated);
		logInfo.setUSR_ID(member.get_id());
		
		if(manager.insertLogInfo(logInfo)) {
			System.out.println("insert logInfo");
		}else {
			System.out.println("error with inserting logInfo");
		}
		
		System.out.println("logId : " + logInfo.getLOG_ID());
		
		for(LinkedHashMap workObj : workInfoList) {
			WorkingInfo workingInfo = new WorkingInfo();
			Timestamp workTimeStamp = Timestamp.valueOf((String) workObj.get("date_time"));
			workingInfo.setUsr_id(member.get_id());
			workingInfo.setDateTime(workTimeStamp);
			workingInfo.setWorkType((String) workObj.get("work_type"));
			workingInfo.setTotalTime(((BigInteger) workObj.get("total_time")).intValue());
			workingInfo.setWorkTime(((BigInteger) workObj.get("work_time")).intValue());
			workingInfo.setNotWorkTime(((BigInteger) workObj.get("not_work_time")).intValue());
			workingInfo.setLog_id(logInfo.getLOG_ID());
			
			if(manager.insertWorkingInfo(workingInfo)) {
				System.out.println("Insert WorkInfo");
			}else {
				System.out.println("Error with inserting logInfo");
			}
		}
	
		
		return "/working/getInfo.jsp";
	}

}

package controller.working;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;
import controller.Controller;
import model.LogInfo;
import model.Member;
import model.WorkingInfo;
import model.service.Manager;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
public class GetClientInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
//		request 정보 띄우기
		Enumeration<String> eHeader = request.getHeaderNames();
		while (eHeader.hasMoreElements()) {
		    String hName = (String)eHeader.nextElement();
		    String hValue = request.getHeader(hName);
		    System.out.println(hName + " : " + hValue + "");
		}
		
//		log file 받아서 서버에 저장
		//String path = "/home/ubuntu/log";
		
		String path = "C:\\project\\awsworkspace\\log";
		System.out.println(path);
		int maxFileSize = 1024 * 1024 * 2;
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxFileSize, "utf-8", new DefaultFileRenamePolicy());
		
//		그외의 근무정보 파라매터 전달 받기
		String logFileName = multipartRequest.getFile("log_file").getName();
		System.out.println(logFileName);
		String [] fileNameSplit = logFileName.split("_");
		String id = fileNameSplit[0];
		
		String date = multipartRequest.getParameter("log_created");
		Timestamp logTimeStamp = Timestamp.valueOf(date + ".0");
		
		String[] workingInfoList = multipartRequest.getParameterValues("working_info");
		
		Member member = manager.getOneMemberByLoginId(id);
		
		LogInfo logInfo = new LogInfo();
		logInfo.setCREATED_DT(logTimeStamp);
		logInfo.setPATH(path);
		logInfo.setTITLE(logFileName);
		logInfo.setUSR_ID(member.get_id());
		
		if(manager.insertLogInfo(logInfo)) {
			System.out.println("insert logInfo");
		}else {
			System.out.println("error with inserting logInfo");
		}
		
		System.out.println("logId : " + logInfo.getLOG_ID());
		
		for(String workInfoStr : workingInfoList) {
			JSONParser parser = new JSONParser(workInfoStr);
			LinkedHashMap workInfoJson = (LinkedHashMap) parser.parse();
			
			WorkingInfo workingInfo = new WorkingInfo();
			Timestamp workTimeStamp = Timestamp.valueOf(((String) workInfoJson.get("date_time")) + ".0");
			workingInfo.setUsr_id(member.get_id());
			workingInfo.setDateTime(workTimeStamp);
			workingInfo.setWorkType((String) workInfoJson.get("work_type"));
			workingInfo.setTotalTime(((BigInteger) workInfoJson.get("total_time")).intValue());
			workingInfo.setWorkTime(((BigInteger) workInfoJson.get("work_time")).intValue());
			workingInfo.setNotWorkTime(((BigInteger) workInfoJson.get("not_work_time")).intValue());
			workingInfo.setLog_id(logInfo.getLOG_ID());
			
			if(manager.insertWorkingInfo(workingInfo)) {
				System.out.println("Insert WorkingInfo");
			}else {
				System.out.println("Error with Inserting WorkingInfo");
			}
		}
		
		
		return "/working/getInfo.jsp";
	}

}

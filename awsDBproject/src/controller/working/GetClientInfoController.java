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
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;
import controller.Controller;
import model.ImageInfo;
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
//		String path = "/home/ubuntu/log";
		
		String path = "C:\\project\\awsworkspace\\log";
		System.out.println(path);
		int maxFileSize = 1024 * 1024 * 2;
		
//		전달 받은 파일 저장
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxFileSize, "utf-8", new DefaultFileRenamePolicy());
		
		String logFileName = "";
		ArrayList<String> imageFilesName = new ArrayList<String>();
		
//		전달 받은 파일처리
		Enumeration fileNames = multipartRequest.getFileNames();
		while(fileNames.hasMoreElements()) {
			String key = (String) fileNames.nextElement();
			String fileName = multipartRequest.getFile(key).getName();
//			
			if(key.equals("file")){ // 전달받은 파일이 로그파일일 때
				logFileName = fileName;
				System.out.println("로그파일 : " + logFileName);
			}else { // 전달받은 파일이 이미지 파일일 때
				imageFilesName.add(fileName);
				System.out.println("이미지파일 : " + fileName);
			}
		}
		
//		사용자 로그인 아이디 알아내기
		String [] fileNameSplit = logFileName.split("_");
		String id = fileNameSplit[0];
		System.out.println(id);
		
//		로그인 아이디로 사용자 정보 알아오기 (기본키 포함)
		Member member = manager.getOneMemberByLoginId(id);
		System.out.println(member.get_id());
		
//		로그파일 생성 시간 알아내기
		String date = multipartRequest.getParameter("log_created");
		Timestamp logTimeStamp = Timestamp.valueOf(date + ".0");
		System.out.println(logTimeStamp);
		
//		근무정보 가져오기
		String[] workingInfoList = multipartRequest.getParameterValues("working_info");

//		로그 정보 저장하기
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
		
//		
		HashMap<Integer, Integer> workImageMap = new HashMap(); 
//		근무 정보 저장히기
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
			
			int work_id = -1;
			if(workingInfo.getWorkType().equals("real")) {
				work_id = ((BigInteger) workInfoJson.get("id")).intValue();
			}
			if(manager.insertWorkingInfo(workingInfo)) {
				System.out.println("Insert WorkingInfo");
//				System.out.println("working Info primary key : " + workingInfo.getHistory_id());
//				work_id에 맞는 workingInfo의 primary key를 매칭
				workImageMap.put(work_id, workingInfo.getHistory_id());
			}else {
				System.out.println("Error with Inserting WorkingInfo");
			}
		}
		
//		이미지 파일 정보를 저장
		for(String imageFileName : imageFilesName) {
			String splitedName[] = imageFileName.split("_");
			int work_id = Integer.valueOf(splitedName[0]);
			System.out.println("image_work_id : " + work_id);
			int history_id = workImageMap.get(work_id);
			System.out.println("workInfo primaryKey : " + history_id);
			
			ImageInfo imageInfo = new ImageInfo();
			imageInfo.setPATH(path);
			imageInfo.setTITLE(imageFileName);
			imageInfo.setUSER_ID(member.get_id());
			imageInfo.setWORK_ID(history_id);
			
			if(manager.insertImageInfo(imageInfo)) {
				System.out.println("Insert ImageInfo");
			}else {
				System.out.println("Error with Inserting ImageInfo");
			}
		}
		
		return "/working/getInfo.jsp";
	}

}

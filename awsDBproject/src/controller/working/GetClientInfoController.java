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
		
		Enumeration<String> eHeader = request.getHeaderNames();
		while (eHeader.hasMoreElements()) {
		    String hName = (String)eHeader.nextElement();
		    String hValue = request.getHeader(hName);
		    System.out.println(hName + " : " + hValue + "");
		}
		String path = request.getServletContext().getRealPath("/logFolder/");
//		String path = getClass().getResource("/").toString();
//		String path = request.getContextPath() + "/logFolder/";
		System.out.println(path);
		int maxFileSize = 1024 * 1024 * 2;
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxFileSize, "utf-8", new DefaultFileRenamePolicy());
		String fileName = multipartRequest.getFile("log_file").getName();
		System.out.println(fileName);
		
		String[] workingInfoList = multipartRequest.getParameterValues("working_info");
		String id = multipartRequest.getParameter("id");
		
		Member member = manager.getOneMemberByLoginId(id);
		for(String workInfoStr : workingInfoList) {
			JSONParser parser = new JSONParser(workInfoStr);
			JSONObject workInfoJson = (JSONObject) parser.parse();
			
			WorkingInfo workingInfo = new WorkingInfo();
			Timestamp workTimeStamp = Timestamp.valueOf(((String) workInfoJson.get("date_time")) + ".0");
			workingInfo.setUsr_id(member.get_id());
			workingInfo.setDateTime(workTimeStamp);
			workingInfo.setWorkType((String) workInfoJson.get("work_type"));
			workingInfo.setTotalTime(((BigInteger) workInfoJson.get("total_time")).intValue());
			workingInfo.setWorkTime(((BigInteger) workInfoJson.get("work_time")).intValue());
			workingInfo.setNotWorkTime(((BigInteger) workInfoJson.get("not_work_time")).intValue());
//			workingInfo.setLog_id(logInfo.getLOG_ID());
		}
		System.out.println(id);

	
		
		return "/working/getInfo.jsp";
	}

}

package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Setting;
import model.service.Manager;

public class SettingController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		Setting setting = manager.getSetting();
		
		if(setting == null) {
			return "setting/sendFail.jsp";
		}
		
		request.setAttribute("setting", setting);
		return "/setting/sendSetting.jsp";
	}

}

package controller.setting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Setting;
import model.service.Manager;

public class ViewSettingController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Manager manager = Manager.getInstance();
		Setting stg = null;
		try {
			stg = manager.getSetting();
		} catch (Exception e) {
			request.setAttribute("exception", e);
			// 추후 다른 페이지로 이동하게 수정해야 함.
			return "/index.jsp";
		}
		request.setAttribute("stg", stg);
		return "/setting/settingPage.jsp";
	}

}

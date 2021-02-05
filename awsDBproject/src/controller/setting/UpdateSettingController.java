package controller.setting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;

import controller.Controller;
import model.Setting;
import model.service.Manager;
import model.service.NotFoundException;

public class UpdateSettingController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Manager manager = Manager.getInstance();
		if (request.getMethod().equals("GET")) {
			// GET 요청일 경우 수정폼을 전달한다.		
			Setting stg = manager.getSetting();
			request.setAttribute("stg", stg);
			if (stg != null) {
				return "/setting/updateSettingForm.jsp";
			}
			// 세팅 정보를 찾을 수 없는 경우 세팅 정보 페이지로 포워딩
			request.setAttribute("exception", new NotFoundException("설정 정보를 찾을 수 없습니다."));
			return "/setting/settingPage.jsp";
		} 
		// POST 요청일 경우 수정을 진행한다.
		Setting stg = new Setting();
		
		stg.setRECOV_LV(Integer.parseInt(request.getParameter("RECOG_LV")));
		stg.setNOD_SEC(Integer.parseInt(request.getParameter("NOD_SEC")));
		stg.setDETEC_SEC(Integer.parseInt(request.getParameter("DETEC_SEC")));
		stg.setVID_INTVL(Integer.parseInt(request.getParameter("VID_INTVL")));
		
		int result = manager.updateSetting(stg);
		// result <= 0 시 예외 발생?
		return "redirect:/setting/view";
	}

}

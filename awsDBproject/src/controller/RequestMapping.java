package controller;

import java.util.HashMap;
import java.util.Map;
import controller.*;
import controller.member.*;
import controller.setting.*;
import controller.setting.SettingController;


public class RequestMapping {
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	mappings.put("/", new ForwardController("index.jsp"));
    	// 사용자 
    	mappings.put("/user/test", new ForwardController("/user/test.jsp"));
    	mappings.put("/test/view", new ViewMemberController());
    	mappings.put("/user/login", new LoginCheckController());
    	// 세팅정보
    	mappings.put("/setting/client", new SettingController());
    	mappings.put("/setting/view", new ViewSettingController());
    	mappings.put("/setting/update/form", new UpdateSettingController());
    	mappings.put("/setting/update", new UpdateSettingController());

    	
    }

    public Controller findController(String uri) {
        return mappings.get(uri);
    }
}

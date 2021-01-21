package controller;

import java.util.HashMap;
import java.util.Map;
import controller.*;
import controller.member.*;


public class RequestMapping {
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	mappings.put("/", new ForwardController("index.jsp"));
    	
    	mappings.put("/user/test", new ForwardController("/user/test.jsp"));
    	mappings.put("/user/result", new ViewMemberController());
    	mappings.put("/user/login", new LoginCheckController());
    }

    public Controller findController(String uri) {
        return mappings.get(uri);
    }
}

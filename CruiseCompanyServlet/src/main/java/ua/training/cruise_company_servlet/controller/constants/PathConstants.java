package ua.training.cruise_company_servlet.controller.constants;

public interface PathConstants {
    String INDEX_PAGE_COMMAND = "";
    String SERVLET_PATH = "/app/";

    String LOGIN_COMMAND = "login";
    String LOGOUT_COMMAND = "logout";
    String LOGIN_JSP = "/login.jsp";

    String ADMIN_FOLDER = "admin";
    String TRAVEL_AGENT_FOLDER = "travel_agent";
    String TOURIST_FOLDER = "tourist";

    String MAIN_COMMAND = "main";
    String ADMIN_MAIN_COMMAND = ADMIN_FOLDER + "/main";
    String TRAVEL_AGENT_MAIN_COMMAND = TRAVEL_AGENT_FOLDER + "/main";
    String TOURIST_MAIN_COMMAND = TOURIST_FOLDER + "/main";
    String ADMIN_MAIN_JSP = "/WEB-INF/" + ADMIN_FOLDER + "/adminMain.jsp";
    String TRAVEL_AGENT_MAIN_JSP = "/WEB-INF/" + TRAVEL_AGENT_FOLDER + "/travelAgentMain.jsp";
    String TOURIST_MAIN_JSP = "/WEB-INF/" + TOURIST_FOLDER + "/touristMain.jsp";

    String TOURIST_CRUISES_COMMAND = "tourist/cruises";
    String TOURIST_CRUISES_JSP = "/WEB-INF/" + TOURIST_FOLDER + "/cruises.jsp";
}

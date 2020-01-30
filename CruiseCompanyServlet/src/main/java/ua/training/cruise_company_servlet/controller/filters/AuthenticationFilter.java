package ua.training.cruise_company_servlet.controller.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.entity.UserRole;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(AuthenticationFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        path = path.replaceAll(".*/app/" , "");

        if( !isUserLoggedIn(request.getSession())) {
            if (isAuthenticationNeeded(path)) {
                logger.warn("guest tried to access '" + path + "'");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            return;
        }
        UserRole role = (UserRole) request.getSession().getAttribute(AttributesConstants.USER_ROLE);

        if(isPathAllowedForUserRole(path,role)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String user = (String) request.getSession().getAttribute(AttributesConstants.USER_NAME);
        logger.error(user + "(" + role + ") tried to access forbidden path '" + path + "'");
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    public void destroy() {
    }

    private boolean isAuthenticationNeeded(String path){
        return  path.startsWith(PathConstants.ADMIN_FOLDER) ||
                path.startsWith(PathConstants.TOURIST_FOLDER) ||
                path.startsWith(PathConstants.TRAVEL_AGENT_FOLDER);
    }

    private boolean isUserLoggedIn(HttpSession session){
        return session != null &&
                session.getAttribute(AttributesConstants.USER_ROLE) != null;
    }

    private boolean isPathAllowedForUserRole(String path, UserRole role){
        if(path.startsWith(PathConstants.LOGOUT_COMMAND) || path.startsWith(PathConstants.LOGIN_COMMAND) ||
                path.startsWith(PathConstants.MAIN_COMMAND))
            return true;

        return (role.equals(UserRole.ROLE_ADMIN) && path.startsWith(PathConstants.ADMIN_FOLDER)) ||
                (role.equals(UserRole.ROLE_TRAVEL_AGENT) && path.startsWith(PathConstants.TRAVEL_AGENT_FOLDER)) ||
                (role.equals(UserRole.ROLE_TOURIST) && path.startsWith(PathConstants.TOURIST_FOLDER));
    }
}

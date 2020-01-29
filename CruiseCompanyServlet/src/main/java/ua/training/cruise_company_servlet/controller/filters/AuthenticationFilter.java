package ua.training.cruise_company_servlet.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        path = path.replaceAll(".*/app/" , "");

        if( isAuthenticationNeeded(path)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }

    private boolean isAuthenticationNeeded(String path){
        return path.startsWith("main") ||
                path.startsWith("admin") ||
                path.startsWith("tourist") ||
                path.startsWith("travel_agent");
    }
}

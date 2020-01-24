package ua.training.cruise_company_servlet.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionLocaleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter("lang") != null) {
            req.getSession().setAttribute("lang", req.getParameter("lang"));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}


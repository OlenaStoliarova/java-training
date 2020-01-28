package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.UserDao;
import ua.training.cruise_company_servlet.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        if( login == null || login.equals("") || password == null || password.equals("")  ){
            return "/login.jsp";
        }
        logger.info( login + ", " + password);

        UserDao userDao = DaoFactory.getInstance().createUserDao();
        //TODO: replace get() with orElseThrow()
        User userFromDB = userDao.findByEmail(login).get();
        logger.info( userFromDB );

        request.getSession().setAttribute("user_role", userFromDB.getRole().toString());

        return "redirect:/app/main";
    }
}

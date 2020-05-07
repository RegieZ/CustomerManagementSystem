package com.company.web;

import com.company.domain.User;
import com.company.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 1.接收请求参数map
            Map<String, String[]> parameterMap = request.getParameterMap();
            // 2.快速封装User实体
            User user = new User();
            BeanUtils.populate(user, parameterMap);
            // 3.调用service，添加User
            UserService userService = new UserService();
            userService.add(user);
            // 4.重定向FindAllServlet
            response.sendRedirect(request.getContextPath() + "/FindAllServlet");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

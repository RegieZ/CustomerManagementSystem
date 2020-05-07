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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.接收请求参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            // 2.快速封装到User实体
            User newUser = new User();
            BeanUtils.populate(newUser, parameterMap);
            // 3.调用service，更新
            UserService userService = new UserService();
            userService.update(newUser);
            // 4.重定向，FindAllServlet
            response.sendRedirect(request.getContextPath()+"/FindAllServlet");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

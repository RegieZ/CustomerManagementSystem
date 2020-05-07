package com.company.web;

import com.company.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求参数ID
        String id = request.getParameter("id");
        // 2.调用service删除
        UserService userService = new UserService();
        userService.delete(id);
        // 3.重定向到FindAllServlet
        response.sendRedirect(request.getContextPath() + "/FindAllServlet");
    }
}

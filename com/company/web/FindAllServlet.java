package com.company.web;

import com.company.domain.User;
import com.company.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindAllServlet")
public class FindAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用service查询
        UserService userService = new UserService();
        List<User> list = userService.findAll();
        // 2.将list存储到Request域
        request.setAttribute("list", list);
        // 3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}

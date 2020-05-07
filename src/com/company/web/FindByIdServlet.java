package com.company.web;

import com.company.domain.User;
import com.company.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收请求参数id
        String id = request.getParameter("id");
        // 2.调用service，根据id查询
        UserService userService = new UserService();
        User user = userService.findById(id);
        // 3.将user存储到request域
        request.setAttribute("user", user);
        // 4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}

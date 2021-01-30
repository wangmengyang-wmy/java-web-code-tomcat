package com.alibaba.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  // 将信息使用doPost方法执行对应jsp页面中的form表单中的method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //得到jsp页面传过来的参数
        String password = request.getParameter("password");

        UserDao ud = new UserDaoImplement();

        if (ud.login(name, password)) {
            request.setAttribute("hello", "欢迎用户" + name); //向request域中放置信息
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面
        } else {
            response.sendRedirect("login.jsp"); //重定向到首页
        }
    }
}

package com.alibaba.servlet;


import com.alibaba.dao.UserDao;
import com.alibaba.dao.impl.UserDaoImpl;
import com.alibaba.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("password");
        String id = request.getParameter("id");

        User user = new User(); //实例化一个对象，组装属性
        user.setName(name);
        user.setPassword(pwd);
        user.setId(id);

        UserDao ud = new UserDaoImpl();

        if(ud.register(user)){
            request.setAttribute("name", name);  //向request域中放置参数
            request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
        }else{
            response.sendRedirect("register.jsp");//注册失败则返回注册页面，但是缺少提示"注册失败"
        }
    }
}

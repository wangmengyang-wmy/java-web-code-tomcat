package com.alibaba.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImplement;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        String name = request.getParameter("name"); //获取jsp页面传过来的参数

        String password = request.getParameter("password");

        User user = new User();

        user.setName(name);

        user.setPassword(password);

        user.setId(id);

        UserDao ud = new UserDaoImplement();

        if(ud.update(user)){
            request.getRequestDispatcher("/addUpdateDeleteSuccess.jsp").forward(request, response);
        }else{
            response.sendRedirect("addUpdateDeleteFail.jsp");
        }
    }
}

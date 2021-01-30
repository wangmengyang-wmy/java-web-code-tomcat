package com.alibaba.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import javax.servlet.annotation.WebServlet;

//@WebServlet
public class DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        UserDao ud = new UserDaoImplement();

        if (ud.delete(id)) {
            request.getRequestDispatcher("addUpdateDeleteSuccess.jsp").forward(request, response);
        } else {
            response.sendRedirect("addUpdateDeleteFail.jsp");
        }
    }
}

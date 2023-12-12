package com.Xworkz.PasspoerProjectMngt.servlet;

import com.Xworkz.PasspoerProjectMngt.dto.UserDTO;
import com.Xworkz.PasspoerProjectMngt.service.UserService;
import com.Xworkz.PasspoerProjectMngt.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/getAllUsers")
public class UserGetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public UserGetServlet() {
        userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDTO> users = userService.getAllInfo();
        request.setAttribute("users", users);

        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}






















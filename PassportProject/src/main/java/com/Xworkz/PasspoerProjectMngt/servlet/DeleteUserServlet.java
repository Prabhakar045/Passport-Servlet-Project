package com.Xworkz.PasspoerProjectMngt.servlet;

import com.Xworkz.PasspoerProjectMngt.dto.UserDTO;
import com.Xworkz.PasspoerProjectMngt.service.UserService;
import com.Xworkz.PasspoerProjectMngt.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int userId = Integer.parseInt(req.getParameter("userId"));

        String userIdParam = req.getParameter("userID");
        int userId = Integer.parseInt(userIdParam);



        UserDTO deletedUser = userService.validateAndDeleteUserById(userId);

        if (deletedUser != null) {
            resp.sendRedirect("getAllUsers");
        }


//        RequestDispatcher dispatcher = req.getRequestDispatcher("deleteUserResult.jsp");
//        dispatcher.forward(req, resp);
    }
}


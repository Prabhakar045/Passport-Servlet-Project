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
@WebServlet(urlPatterns = "/updateUser")
public class EditUserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userIdParam = req.getParameter("userId");

        int userId = Integer.parseInt(userIdParam);

        String givenName = req.getParameter("givenName");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String loginId = req.getParameter("loginId");
        String passportOffice = req.getParameter("passportOffice");
        String dob = req.getParameter("dob");
        String password = req.getParameter("password");
        String hintQuestion = req.getParameter("hintQuestion");
        String hintAnswer = req.getParameter("hintAnswer");

        UserDTO updatedUser = new UserDTO();
        updatedUser.setUserId(userId);
        updatedUser.setGivenName(givenName);
        updatedUser.setSurname(surname);
        updatedUser.setEmail(email);
        updatedUser.setLoginId(loginId);
        updatedUser.setPassportOffice(passportOffice);
        updatedUser.setDob(dob);
        updatedUser.setPassword(password);
        updatedUser.setHintQuestion(hintQuestion);
        updatedUser.setHintAnswer(hintAnswer);

        UserDTO dto = userService.validateAndUpdateInfoById(userId, updatedUser);

        req.setAttribute("user", dto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("updateUser.jsp");
        dispatcher.forward(req, resp);

        if (dto != null) {
            resp.sendRedirect("getAllUsers");
        }
    }
}

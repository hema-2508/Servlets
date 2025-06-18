package com.xworkz.loginsystem.servlet;

import com.xworkz.loginsystem.dto.LoginDto;
import com.xworkz.loginsystem.service.LoginService;
import com.xworkz.loginsystem.service.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");
        String userPassword = req.getParameter("userPassword");

        //create a instance of dto
        LoginDto loginDto =  new LoginDto();
        loginDto.setUserName(userName);
        loginDto.setUserEmail(userEmail);
        loginDto.setUserPassword(userPassword);

        System.out.println("Login Dto is:"+loginDto);
        boolean saveResult = loginService.save(loginDto);
        if(saveResult==true)
        {
            req.setAttribute("result","Logged in successfully");

        }else {
            req.setAttribute("result", "not Logged in successfully");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
        resp.setContentType("text/html");
        req.setAttribute("result","Successfully logged in");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       LoginDto[] loginDtos = loginService.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        resp.setContentType("text/html");
        req.setAttribute("loginDtos",loginDtos);
        dispatcher.forward(req,resp);
    }
}

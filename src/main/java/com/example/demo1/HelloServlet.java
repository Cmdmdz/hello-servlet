package com.example.demo1;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String input1 = request.getParameter("input1");
        String input2 = request.getParameter("input2");
        Double result = Double.parseDouble(input1) + Double.parseDouble(input2);
        String res = String.valueOf(result);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.include(request, response);
        out.print("<p> 答案 ：");
        out.print("<label for=\"IDd\"></label>");
        out.print("<input name=\"result\" type=\"text\" value=" + res + " id=\"IDd\" size=\"15\" />");
        out.print("</p>");

    }

    public void destroy() {
    }
}

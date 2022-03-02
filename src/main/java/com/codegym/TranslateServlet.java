package com.codegym;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("how", "The nao");
        dictionary.put("book", "Quyen sach");
        dictionary.put("computer", "May tinh");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        writer.println("Word: " + search);
        writer.println("<br>");
        if(result != null){
            writer.println("Result: " + result);
        } else {
            writer.println("Result: not found!");
        }

        writer.println("<h2>Vietnamese Dictionary</h2>");
        writer.println("<form method=\"post\" action=\"/translate\">");
        writer.println("<input type=\"text\" name=\"txtSearch\" placeholder=\"Enter your word: \"/>");
        writer.println("<input type=\"submit\" id=\"submit\" value=\"Search\"/>");
        writer.println("</form>");

        writer.println("</html>");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 738409
 */
public class ShoppingListServlet extends HttpServlet {

    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String action = (String) request.getParameter("action");
            if (action.equals("logout")) {
                session.removeAttribute("username");
                items.clear();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                session.invalidate();
            }
        } catch (NullPointerException e1) {

            try {

                String username = (String) session.getAttribute("registereduser");

                if (!username.equals(""))//user logged in successfully
                {

                    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);

                }

            } catch (NullPointerException e) {

                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        String input = request.getParameter("iteminput");

        if (action.equals("add")) {

            if (!input.equals("")) {
                items.add(input);
                session.setAttribute("list", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Enter an item");
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                return;
            }

        }
        if (action.equals("delete")) {
            String deletethis = request.getParameter("added");

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(deletethis)) {
                    items.remove(i);

                }
            }
            session.setAttribute("list", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;

        }
        if (action.equals("register") && !username.equals("")) {
            session.setAttribute("registereduser", username);

            response.sendRedirect("shoppinglist");

        } else {
            request.setAttribute("error", "Enter a name");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        }
    }

}

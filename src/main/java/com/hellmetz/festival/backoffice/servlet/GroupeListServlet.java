package com.hellmetz.festival.backoffice.servlet;

import com.hellmetz.festival.backoffice.dao.GroupeDao;
import com.hellmetz.festival.backoffice.model.Groupe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/backoffice/groupes")
public class GroupeListServlet extends HttpServlet {

    private GroupeDao groupeDao = new GroupeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Groupe> groupes = groupeDao.findAll();
        req.setAttribute("groupes", groupes);

        // On délègue l’affichage à une JSP
        req.getRequestDispatcher("/WEB-INF/backoffice/groupes.jsp").forward(req, resp);
    }
}

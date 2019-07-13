package controllers;
import entities.Ticket;
import helpers.ErrorResponse;
import helpers.SuccessResponse;
import repositories.TicketsRepository;
import utils.JsonMapper;
import utils.ResponseWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/tickets")
public class GetTicketsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Ticket> tickets;
        Integer from = null, to = null, count = 0;
        String departDate = null;

        try {
            if (request.getParameter("from") != null) {
                from = Integer.parseInt(request.getParameter("from"));
            }

            if (request.getParameter("to") != null) {
                to = Integer.parseInt(request.getParameter("to"));
            }

            if (request.getParameter("count") != null) {
                count = Integer.parseInt(request.getParameter("count"));
            }

            if (request.getParameter("depart-date") != null) {
                departDate = request.getParameter("depart-date");
            }

            if (from == null || to == null) {
                ErrorResponse res = new ErrorResponse("Please provide source and destination cities.");
                ResponseWriter.write(response, JsonMapper.toJson(res));
            } else {
                tickets = TicketsRepository.find(from, to, count, departDate);
                SuccessResponse res = new SuccessResponse<ArrayList<Ticket> >(tickets, "OK");
                ResponseWriter.write(response, JsonMapper.toJson(res));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

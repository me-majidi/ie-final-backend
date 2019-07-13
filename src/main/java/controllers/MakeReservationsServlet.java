package controllers;

import dataLayer.dataMappers.user.UserMapper;
import entities.User;
import helpers.ErrorResponse;
import helpers.SuccessResponseWithoutData;
import repositories.TicketsRepository;
import repositories.TransactionsRepository;
import requestTypes.ReservationRequest;
import utils.JsonMapper;
import utils.ResponseWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/reserve")
public class MakeReservationsServlet  extends HttpServlet {
    private TransactionsRepository transactionsRepository = new TransactionsRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationRequest reqBody = (ReservationRequest) JsonMapper.parseRequestBody(ReservationRequest.class, request);

        String buyerNationalNumber = reqBody.getBuyerNationalNumber();
        String buyerFirsName = reqBody.getBuyerFirstName();
        String buyerLastName = reqBody.getBuyerLastName();
        String buyerMobile = reqBody.getBuyerMobileNumber();
        Integer ticketId = reqBody.getTicketId();
        Integer ticketsCount = reqBody.getTicketsCount();
        Date reservationDate = new Date();

        if (ticketsCount > TicketsRepository.getTicketLeftCapacity(ticketId)) {
            ErrorResponse res = new ErrorResponse("Dont have enough tickets");
            response.setStatus(422);
            ResponseWriter.write(response, JsonMapper.toJson(res));
        } else {
            User buyer = UserMapper.getUserByNationalNumber(buyerNationalNumber);

            if (buyer == null) {
                buyer = UserMapper.storeUser(buyerFirsName, buyerLastName, buyerMobile, buyerNationalNumber);
            }

            try {
                this.transactionsRepository.storeTransaction(reservationDate.toString(), buyer.getID(), ticketId, ticketsCount);
                TicketsRepository.updateTicketCapacity(ticketId, ticketsCount);

                SuccessResponseWithoutData res = new SuccessResponseWithoutData("OK", "reserved");
                ResponseWriter.write(response, JsonMapper.toJson(res));

            } catch (NullPointerException e) {
                ErrorResponse res = new ErrorResponse("something bad happened");
                response.setStatus(500);
                ResponseWriter.write(response, JsonMapper.toJson(res));
                e.printStackTrace();
            }
        }
    }
}

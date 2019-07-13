package repositories;

import dataLayer.dataMappers.ticket.TicketMapper;
import entities.Ticket;

import java.util.ArrayList;

public class TicketsRepository {
    private static TicketMapper ticketMapper = new TicketMapper();

    public TicketsRepository() {
    }

    public static ArrayList<Ticket> find(Integer from, Integer to, Integer count, String departDate) {
        return TicketsRepository.ticketMapper.find(from, to, count, departDate);
    }

    public static void updateTicketCapacity(Integer ticketId, Integer count) {
        TicketsRepository.ticketMapper.updateTicketCapacity(ticketId, count);
    }

    public static Integer getTicketLeftCapacity(Integer ticketId) {
        return ticketMapper.getTicketLeftCapacity(ticketId);
    }
}

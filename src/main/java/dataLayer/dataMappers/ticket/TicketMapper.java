package dataLayer.dataMappers.ticket;

import dataLayer.DBCPDataSource;
import entities.Ticket;

import java.sql.*;
import java.util.ArrayList;

public class TicketMapper {
    public TicketMapper() {
        try {
            Connection con = DBCPDataSource.getConnection();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS tickets (\n" +
                    "  ID INTEGER PRIMARY KEY,\n" +
                    "  depart_date TEXT,\n" +
                    "  price INTEGER,\n" +
                    "  capacity INTEGER,\n" +
                    "  company_id INTEGER,\n" +
                    "  from_city_id INTEGER,\n" +
                    "  to_city_id INTEGER,\n" +
                    "  FOREIGN KEY (company_id) REFERENCES companies(ID),\n" +
                    "  FOREIGN KEY (from_city_id) REFERENCES cities(ID),\n" +
                    "   FOREIGN KEY (to_city_id) REFERENCES cities(ID)\n" +
                    ")");

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ticket> find(Integer from, Integer to, Integer count, String departDate) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        String sql = "SELECT tickets.ID, tickets.price, tickets.capacity, tickets.depart_date, from_city.name AS from_city, to_city.name AS to_city, companies.name AS company\n" +
                "FROM tickets\n" +
                "       INNER JOIN cities from_city on (tickets.from_city_id = from_city.ID)\n" +
                "       INNER JOIN cities to_city on (tickets.to_city_id = to_city.ID)\n" +
                "       INNER JOIN companies on (tickets.company_id = companies.ID)\n" +
                "WHERE (tickets.from_city_id = ? AND tickets.to_city_id = ? AND tickets.capacity >= ?";


        if (departDate != null) {
            sql = sql + " AND tickets.depart_date = ?);";
        } else {
            sql = sql + ");";
        }




        try {
            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, from);
            st.setInt(2, to);
            st.setInt(3, count);

            if (departDate != null) {
                String s = "'" + departDate + "'";
                System.out.println(s);
                st.setString(4, departDate);
            }

            ResultSet resultSet;
            resultSet = st.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                return null;
            }

            while (resultSet.next()) {
                tickets.add(this.convertResultSetToDomainModel(resultSet));
            }

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    public void updateTicketCapacity(Integer ticketId, Integer count) {
        try {
            String sql = "UPDATE tickets SET capacity = capacity - ? WHERE ID = ?";
            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, count);
            st.setInt(2, ticketId);

            Integer updatedRows = st.executeUpdate();

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Ticket convertResultSetToDomainModel(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setID(rs.getInt(1));
        ticket.setPrice(rs.getInt(2));
        ticket.setcapaciy(rs.getInt(3));
        ticket.setDepartDate(rs.getString(4));
        ticket.setFrom(rs.getString(5));
        ticket.setTo(rs.getString(6));
        ticket.setCompany(rs.getString(7));

        return ticket;
    }

    public Integer getTicketLeftCapacity(Integer ticketId) {
        try {
            String sql = "SELECT capacity FROM tickets WHERE ID = ?";
            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, ticketId);

            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                Integer capacity = resultSet.getInt(1);
                resultSet.close();
                st.close();
                con.close();

                return capacity;
            } else {
                resultSet.close();
                st.close();
                con.close();
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
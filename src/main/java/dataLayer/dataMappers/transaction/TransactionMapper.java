package dataLayer.dataMappers.transaction;

import dataLayer.DBCPDataSource;
import entities.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionMapper {
    public TransactionMapper() {
        try {
            Connection con = DBCPDataSource.getConnection();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS transactions (\n" +
                    "                                          ID TEXT PRIMARY KEY,\n" +
                    "                                          time TEXT,\n" +
                    "                                          user_id TEXT,\n" +
                    "                                          ticket_id TEXT,\n" +
                    "                                          payment_status TEXT,\n" +
                    "                                          tickets_count INTEGER,\n" +
                    "                                          FOREIGN KEY (user_id) REFERENCES users(ID),\n" +
                    "                                          FOREIGN KEY (ticket_id) REFERENCES tickets(ID)\n" +
                    ");");

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void storeTransaction(Transaction transaction) {
        try {
            String sql = "INSERT INTO transactions (ID, time, user_id, ticket_id, payment_status, tickets_count) VALUES (?, ?, ?, ?, ?, ?);";
            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, transaction.getID());
            st.setString(2, transaction.getTime());
            st.setString(3, transaction.getUser_id());
            st.setInt(4, transaction.getTicket_id());
            st.setString(5, transaction.getPayment_status());
            st.setInt(6, transaction.getTickets_count());

            st.execute();

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

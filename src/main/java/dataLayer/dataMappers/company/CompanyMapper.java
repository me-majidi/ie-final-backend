package dataLayer.dataMappers.company;

import dataLayer.DBCPDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyMapper {
    private static final String COLUMNS = "ID, title";

    public CompanyMapper() {
        try {
            Connection con = DBCPDataSource.getConnection();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS companies (\n" +
                    "  ID INTEGER,\n" +
                    "  name TEXT\n" +
                    ")");

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

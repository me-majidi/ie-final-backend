package dataLayer;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSource {

    private static final BasicDataSource ds = new BasicDataSource();
    private final static String dbURL = "jdbc:sqlite:/D:\\Projects\\mrbilit\\mrbilit.db";


//    Projects
    static {
        ds.setUrl(dbURL);
        ds.setMinIdle(5);
        ds.setMaxIdle(1200);
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ds.getConnection();
    }

    private DBCPDataSource(){}
}
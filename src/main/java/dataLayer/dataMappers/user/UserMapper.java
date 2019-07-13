package dataLayer.dataMappers.user;

import dataLayer.DBCPDataSource;
import dataLayer.dataMappers.city.CityMapper;
import entities.User;

import java.sql.*;
import java.util.UUID;

public class UserMapper {
    public UserMapper() {
        try {
            Connection con = DBCPDataSource.getConnection();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                    "  ID TEXT PRIMARY KEY,\n" +
                    "  first_name TEXT,\n" +
                    "  last_name TEXT,\n" +
                    "  mobile TEXT,\n" +
                    "  national_number TEXT\n" +
                    ");");

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUserByNationalNumber(String nationalNumber) {
        User user = null;

        try {
            String sql = "SELECT * FROM users WHERE national_number = ?";

            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nationalNumber);

            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                user = UserMapper.convertResultSetToUserModel(resultSet);
            } else {
                user = null;
            }

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User storeUser(String firstName, String lastName, String mobile, String nationalNumber) {
        try {
            User user = new User(UUID.randomUUID().toString(), firstName, lastName, mobile, nationalNumber);
            String sql = "INSERT INTO users (ID, first_name, last_name, mobile, national_number)\n" +
                    "VALUES (?, ?, ?, ?, ?);";

            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getID());
            st.setString(2, firstName);
            st.setString(3, lastName);
            st.setString(4, mobile);
            st.setString(5, nationalNumber);

            st.execute();
            st.close();
            con.close();


            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static User convertResultSetToUserModel(ResultSet resultset) throws SQLException {
        User user = new User();
        user.setID(resultset.getString(1));
        user.setFirstName(resultset.getString(2));
        user.setLastName(resultset.getString(3));
        user.setMobile(resultset.getString(4));
        user.setNationalNumber(resultset.getString(5));

        return user;
    }
}

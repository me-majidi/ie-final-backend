package dataLayer.dataMappers.city;

import dataLayer.DBCPDataSource;
import entities.City;

import java.sql.*;
import java.util.ArrayList;

public class CityMapper {
    public CityMapper() {
        try {
            Connection con = DBCPDataSource.getConnection();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS cities (\n" +
                    "  ID INTEGER,\n" +
                    "  name TEXT\n" +
                    ")");

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<City> getCities() {
        ArrayList<City> cities = new ArrayList<City>();
        try {
            String sql = "SELECT * FROM cities";
            Connection con = DBCPDataSource.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                cities.add(CityMapper.convertResultSetToCityModel(resultSet));
            }

            resultSet.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return cities;
    }

    private static City convertResultSetToCityModel(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setID(resultSet.getInt(1));
        city.setName(resultSet.getString(2));

        return city;
    }
}

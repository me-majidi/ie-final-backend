package controllers;

import entities.City;
import helpers.SuccessResponse;
import repositories.CitiesRepository;
import utils.JsonMapper;
import utils.ResponseWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cities")
public class GetCitiesServlet extends HttpServlet {
    private CitiesRepository citiesRepository = new CitiesRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> cities;

        try {
            cities = this.citiesRepository.getActiveCities();
            SuccessResponse res = new SuccessResponse<ArrayList<City> >(cities, "OK");
            ResponseWriter.write(response, JsonMapper.toJson(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

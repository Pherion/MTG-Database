package carroll.franklin.d.mtgDatabase.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Franklin Carroll on 11/9/2014.
 */
@WebServlet(name = "TestServlet", urlPatterns = "/servlets/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        System.out.println("Begining doPost on TestServlet.");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=Super&password=Rambling!Depravity3");
            out.println("Connection successfully opened!");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Unable to open connection.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

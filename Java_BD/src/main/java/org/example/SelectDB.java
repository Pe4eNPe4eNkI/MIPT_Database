package org.example;

import org.example.entities.Client;

import javax.xml.crypto.Data;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDB {

    static void selectAllClient(Connection conn) throws SQLException {
        List<Client> result = new ArrayList<>();

        PreparedStatement preparedStatement = conn.prepareStatement("Select * from client");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            Client obj = new Client(
                    resultSet.getInt("client_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("hb_data"),
                    resultSet.getString("passport_number"),
                    resultSet.getString("phone_number")
            );
            result.add(obj);

        }
        System.out.println("List of clients: ");
        result.forEach(System.out::println);
    }

    static void selectMaxDeposit(Connection conn) throws SQLException {
        String clientIdQuery = "SELECT MAX(deposit_summ) AS max_deposit FROM deposit";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(clientIdQuery);
        resultSet.next();

        System.out.println("Max deposit sum is " + resultSet.getInt(1));
    }

    static void selectCountMultipleCredit(Connection conn) throws SQLException {
        String clientIdQuery = "SELECT COUNT(*) FROM (SELECT client_id FROM credit GROUP BY client_id HAVING COUNT(credit_id) > 1) AS multiple_credits;";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(clientIdQuery);
        resultSet.next();

        System.out.println("Count of clients with multiple credit is " + resultSet.getInt(1));
    }

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/pg_db", "postgres", "postgres");

        selectAllClient(conn);
        System.out.println();
        selectMaxDeposit(conn);
        System.out.println();
        selectCountMultipleCredit(conn);
    }
}

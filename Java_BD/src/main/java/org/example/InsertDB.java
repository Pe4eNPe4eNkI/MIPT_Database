package org.example;

import org.example.entities.Client;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertDB {

    static void insertClient(Client client, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(("INSERT INTO client(" +
                "first_name, " +
                "second_name, " +
                "last_name, " +
                "hb_data, " +
                "passport_number, " +
                "phone_number) " +
                "VALUES (?, ?, ?, ?, ?, ?)"));

        ps.setString(1, client.getFirstName());
        ps.setString(2, client.getSecondName());
        ps.setString(3, client.getLastName());
        ps.setDate(4, client.getHbData());
        ps.setString(5, client.getPassportNumber());
        ps.setString(6, client.getPhoneNumber());
        ps.executeUpdate();
    }

    static int getLastId(Connection conn) throws SQLException {
        String clientIdQuery = "Select max(client_id) from client";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(clientIdQuery);

        resultSet.next();

        return resultSet.getInt(1);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/pg_db", "postgres", "postgres");

        int lastClientId = getLastId(conn);


        Client firstPerson = new Client(
                lastClientId++,
                "Тиньков",
                "Олег",
                "Юрьевич",
                Date.valueOf("1967-12-25"),
                "1234567890",
                "88805553535"
        );

        Client secondPerson = new Client(
                lastClientId++,
                "Дуров",
                "Павел",
                "Валерьевич",
                Date.valueOf("1984-10-10"),
                "0134567890",
                "89929632123"
        );

        Client thirdClient = new Client(
                lastClientId++,
                "Маск",
                "Илон",
                "Иванович",
                Date.valueOf("1971-06-28"),
                "6740281059",
                "89075513795"
        );

        // insertClient(firstPerson, conn); уже в БД
        insertClient(secondPerson, conn);
        insertClient(thirdClient, conn);
    }

}

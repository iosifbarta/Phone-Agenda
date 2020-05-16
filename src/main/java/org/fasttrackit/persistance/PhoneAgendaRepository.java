package org.fasttrackit.persistance;

import org.fasttrackit.transfer.CreateNewPerson;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneAgendaRepository {

    public void addPerson (CreateNewPerson request) throws IOException, SQLException {

        String sql = "INSERT INTO phone_agenda (first_name, second_name, phone_number) VALUES(?, ?, ?)";
        try (
            Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

        preparedStatement.setString(1,request.getFirstName());
        preparedStatement.setString(2,request.getSecondName());
        preparedStatement.setInt(3,request.getPhoneNumber());

        preparedStatement.executeUpdate();
        }
    }
}

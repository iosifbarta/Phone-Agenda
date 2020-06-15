package org.fasttrackit.persistance;

import org.fasttrackit.domain.PhoneAgenda;
import org.fasttrackit.transfer.CreateContact;
import org.fasttrackit.transfer.UpdateAgenda;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneAgendaRepository {

    public void createContact(CreateContact request) throws IOException, SQLException, ClassNotFoundException {

        String sql = "INSERT INTO phone_agenda (first_name, second_name, phone_number, email) VALUES(?, ?, ?, ?)";
        try (
            Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

        preparedStatement.setString(1,request.getFirstName());
        preparedStatement.setString(2,request.getSecondName());
        preparedStatement.setInt(3,request.getPhoneNumber());
        preparedStatement.setString(4,request.getEmail());

        preparedStatement.executeUpdate();
        }
    }
    public void updateAgenda (long id, UpdateAgenda request) throws SQLException, IOException, ClassNotFoundException {

        String sql = "UPDATE phone_agenda SET first_name=?, second_name=?, phone_number=?, email=? WHERE id=?";

        try (
                Connection connection = DatabaseConfiguration.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
                ){
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2,request.getSecondName());
            preparedStatement.setInt(3,request.getPhoneNumber());
            preparedStatement.setString(4,request.getEmail());
            preparedStatement.setLong(5,id);

            preparedStatement.executeUpdate();
        }
    }
    public void deleteContact (long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM phone_agenda WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
        }
    }
    public List<PhoneAgenda> getContacts() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT id, first_name, second_name, phone_number, email FROM phone_agenda";

        List<PhoneAgenda> contacts = new ArrayList<>();

        try (
                Connection connection = DatabaseConfiguration.getConnection();
                Statement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                PhoneAgenda contact = new PhoneAgenda();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setSecondName(resultSet.getString("second_name"));
                contact.setPhoneNumber(resultSet.getInt("phone_number"));
                contact.setEmail(resultSet.getString("email"));

                contacts.add(contact);
            }
        }return contacts;
    }
}

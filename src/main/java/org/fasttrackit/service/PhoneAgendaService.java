package org.fasttrackit.service;

import org.fasttrackit.domain.PhoneAgenda;
import org.fasttrackit.persistance.PhoneAgendaRepository;
import org.fasttrackit.transfer.CreateContact;
import org.fasttrackit.transfer.UpdateAgenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PhoneAgendaService {
    private PhoneAgendaRepository phoneAgendaRepository = new PhoneAgendaRepository();

    public void createContact(CreateContact createContact) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating new entry: "+ createContact);

        phoneAgendaRepository.createContact(createContact);
    }

    public void updateAgenda(long id, UpdateAgenda request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating entry: "+id+": "+request);
        phoneAgendaRepository.updateAgenda(id, request);
    }
    public void deleteContact (long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting contact: "+ id);
        phoneAgendaRepository.deleteContact(id);
    }
    public List<PhoneAgenda> getContacts() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving contacts: ");
        return phoneAgendaRepository.getContacts();
    }
}

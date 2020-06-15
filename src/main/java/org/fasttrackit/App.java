package org.fasttrackit;


import org.fasttrackit.domain.PhoneAgenda;
import org.fasttrackit.persistance.PhoneAgendaRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
//        CreateContact request = new CreateContact();
//        request.setFirstName("Ema");
//        request.setSecondName("Hewit");
//        request.setPhoneNumber(745234906);

        PhoneAgendaRepository phoneAgendaRepository = new PhoneAgendaRepository();
//        UpdateAgenda updateAgenda = new UpdateAgenda();
//        updateAgenda.setFirstName("Robin");
//        updateAgenda.setSecondName("Hood");
//        updateAgenda.setPhoneNumber(756890232);
        List<PhoneAgenda> contacts = phoneAgendaRepository.getContacts();
        System.out.println(contacts);
    }
}

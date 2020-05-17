package org.fasttrackit;


import org.fasttrackit.domain.PhoneAgenda;
import org.fasttrackit.persistance.PhoneAgendaRepository;
import org.fasttrackit.transfer.CreateNewPerson;
import org.fasttrackit.transfer.UpdateAgenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
//        CreateNewPerson request = new CreateNewPerson();
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

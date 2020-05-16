package org.fasttrackit;


import org.fasttrackit.transfer.CreateNewPerson;

public class App
{
    public static void main( String[] args )
    {
        CreateNewPerson request = new CreateNewPerson();
        request.setFirstName("Billy");
        request.setSecondName("Joe");
        request.setPhoneNumber(724245198);
    }
}

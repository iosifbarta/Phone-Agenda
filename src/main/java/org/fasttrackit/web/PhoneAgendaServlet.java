package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.PhoneAgenda;
import org.fasttrackit.service.PhoneAgendaService;
import org.fasttrackit.transfer.CreateContact;
import org.fasttrackit.transfer.UpdateAgenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/contacts")
public class PhoneAgendaServlet extends HttpServlet {

    private PhoneAgendaService phoneAgendaService = new PhoneAgendaService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateContact createContact = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), CreateContact.class);

        try {
            phoneAgendaService.createContact(createContact);
        } catch (SQLException | ClassNotFoundException throwables) {
            resp.sendError(500, "There was an error while processing your request. "+ throwables.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        UpdateAgenda updateAgenda = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), UpdateAgenda.class);
        try {
            phoneAgendaService.updateAgenda(Long.parseLong(id), updateAgenda);
        } catch (SQLException | ClassNotFoundException throwables) {
            resp.sendError(500, "There was an error while processing your request. "+ throwables.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            phoneAgendaService.deleteContact(Long.parseLong(id));
        } catch (SQLException | ClassNotFoundException throwables) {
            resp.sendError(500, "There was an error while processing your request. "+ throwables.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<PhoneAgenda> contacts = phoneAgendaService.getContacts();

            ObjectMapperConfiguration.OBJECT_MAPPER.writeValue(resp.getWriter(), contacts);

        } catch (SQLException | ClassNotFoundException throwables) {
            resp.sendError(500, "There was an error while processing your request. "+ throwables.getMessage());
        }

    }
}


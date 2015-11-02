package com.vdzon.contactdb.contacts.rest;

import com.vdzon.contactdb.authenticatie.service.AuthenticationService;
import com.vdzon.contactdb.contacts.data.Contact;
import com.vdzon.contactdb.contacts.mapper.ContactModelMapper;
import com.vdzon.contactdb.contacts.model.ContactModel;
import com.vdzon.contactdb.contacts.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@RestController
@PreAuthorize("hasAuthority('USER')")
@RequestMapping("/rest/contacts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {
    @Inject
    ContactRepository contactService;

    @Inject
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getContacts", method = RequestMethod.GET)
    public ResponseEntity<List<ContactModel>> getContacts() throws Exception {
        long userId = authenticationService.getUserId();
        List<ContactModel> contacts = ContactModelMapper.toModel(contactService.listAll(userId));
        return new ResponseEntity<List<ContactModel>>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContactModel> getContact(@PathParam("id") Long id) {
        return new ResponseEntity<ContactModel>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<ContactModel>> saveContact(ContactModel contactModel) throws Exception {
        System.out.println("SAVE USer:" + contactModel.getName());
        Contact contact = contactService.getContact(contactModel.getUuid());
        ContactModelMapper.mergeModel(contactModel, contact);
        contactService.save(contact);

        long userId = authenticationService.getUserId();
        List<ContactModel> contactModels = ContactModelMapper.toModel(contactService.listAll(userId));
        return new ResponseEntity<List<ContactModel>>(contactModels, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<ContactModel>> addContact(ContactModel model) throws Exception {
        long userId = authenticationService.getUserId();
        System.out.println("ADD USer:" + model.getName());
        Contact contact = new Contact();
        ContactModelMapper.mergeModel(model, contact);
        contact.setUserId(userId);
        contact.setUuid(UUID.randomUUID().toString());
        contactService.save(contact);
        List<ContactModel> contactModels = ContactModelMapper.toModel(contactService.listAll(userId));
        return new ResponseEntity<List<ContactModel>>(contactModels, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<List<ContactModel>> deleteContact(@PathVariable("id") String uuid) {
        long userId = authenticationService.getUserId();
        contactService.deleteContact(uuid);
        List<ContactModel> contactModels = ContactModelMapper.toModel(contactService.listAll(userId));
        return new ResponseEntity<List<ContactModel>>(contactModels, HttpStatus.OK);
    }
}

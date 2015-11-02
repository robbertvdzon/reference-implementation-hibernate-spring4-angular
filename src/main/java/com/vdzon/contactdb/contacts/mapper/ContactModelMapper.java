package com.vdzon.contactdb.contacts.mapper;

import com.vdzon.contactdb.contacts.data.Contact;
import com.vdzon.contactdb.contacts.model.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class ContactModelMapper {


    public static void mergeModel(final ContactModel model, Contact contact) {
        contact.setEmail(model.getEmail());
        contact.setName(model.getName());
    }

    public static ContactModel toModel(final Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setUuid(contact.getUuid().toString());
        contactModel.setEmail(contact.getEmail());
        contactModel.setName(contact.getName());
        return contactModel;
    }

    public static List<ContactModel> toModel(final List<Contact> contacts) {
        List<ContactModel> contactModels = new ArrayList<ContactModel>();
        for (Contact contact : contacts) {
            contactModels.add(toModel(contact));
        }
        return contactModels;
    }


}

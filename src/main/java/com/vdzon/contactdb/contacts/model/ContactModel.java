package com.vdzon.contactdb.contacts.model;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ContactModel {
    private String uuid;
    private String name;
    private String email;

    private static ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller

    // the fromString is needed to convert json to object. This is needed for using this object as a PathParam in REST
    public static ContactModel fromString(String jsonRepresentation) throws IOException {
        return mapper.readValue(jsonRepresentation, ContactModel.class);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

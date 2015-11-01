package com.vdzon.contactdb.contacts.service;

import com.vdzon.contactdb.contacts.data.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ContactRepository extends CrudRepository<Contact, Long> {


    @Query("SELECT c FROM Contact c WHERE userId = :userID")
    List<Contact> listAll(@Param("userID") long userID);

    @Modifying
    @Query("DELETE FROM Contact c WHERE c.uuid = :uuid")
    void deleteContact(@Param("uuid") String uuid);

    @Query("SELECT c FROM Contact c WHERE uuid = :uuid")
    Contact getContact(@Param("uuid") String uuid);

}

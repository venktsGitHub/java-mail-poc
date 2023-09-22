package com.contact.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.contact.app.entity.Contact;


public interface ContactService {

	public Contact postContact(Contact contact) ;

	public List<Contact> getAllContacts();

	public Contact getJson(String contact, MultipartFile multipartImage) throws IOException;
}

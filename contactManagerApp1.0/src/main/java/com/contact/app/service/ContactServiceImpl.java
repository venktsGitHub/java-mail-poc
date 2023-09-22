package com.contact.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.contact.app.entity.Contact;
import com.contact.app.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	public  Contact postContact(Contact contact) {
		
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return contactRepository.findAll();
	}

	@Override
	public Contact getJson(String contact, MultipartFile multipartImage) throws IOException {
		
		Contact contactPojo = new Contact();
		System.out.println(contact);
		
		try {
			ObjectMapper objMapper = new ObjectMapper();
			
			contactPojo = objMapper.readValue(contact, Contact.class);
			System.out.println(contactPojo);
		}
		catch(Exception e) {
			System.out.println("There is error "+e);
		}
		
		contactPojo.setImage(multipartImage.getBytes());
		
		return contactPojo;
		
	}

}

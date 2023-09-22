package com.contact.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.contact.app.entity.Contact;
import com.contact.app.service.ContactService;

@RequestMapping("/contacts")
@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping
	public Contact addContact(@RequestParam("multipartImage") MultipartFile multipartImage,
			@RequestParam("contact") String contact) throws IOException {
		
		//System.out.println("Hello "+contact);
		
		Contact contactNew = contactService.getJson(contact, multipartImage);
		
		return contactService.postContact(contactNew);
		
	}
	
	
	@GetMapping
    public List<Contact> getContacts() {
		
		return contactService.getAllContacts();
	}
	
	@GetMapping("/greatings")
    public String greetings() {
		
		return "Happy New Year";
	}
	

}

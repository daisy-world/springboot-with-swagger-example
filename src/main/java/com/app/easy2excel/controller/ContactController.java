package com.app.easy2excel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.easy2excel.entity.Contact;
import com.app.easy2excel.service.ContactService;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {

	@Autowired
	ContactService contactService;

	@PostMapping("/")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {

		return ResponseEntity.ok(contactService.saveContact(contact));

	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> fetchContactById(@PathVariable("id") Long id) {

		return ResponseEntity.ok(contactService.getContactDetailsById(id));

	}

	@GetMapping("/")
	public ResponseEntity<List<Contact>> getAllContacts() {

		return ResponseEntity.ok(contactService.getAllContactList());

	}

	@PutMapping("/{id}")
	public ResponseEntity<Contact> updateContactById(@PathVariable("id") Long id,
			                                         @RequestBody Contact contact) {

		return ResponseEntity.ok(contactService.updateContactById(id, contact));
	}

	@DeleteMapping("/{id}")
	public void deleteContactById(@PathVariable("id") Long id) {

		contactService.deleteContactById(id);

	}
}

package com.app.easy2excel.controller;

import java.util.List;

import com.app.easy2excel.exception.EmailNotFoundException;
import com.app.easy2excel.exception.ErrorResponse;
import com.app.easy2excel.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.easy2excel.entity.Contact;
import com.app.easy2excel.service.ContactService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {

	@Autowired
	ContactService contactService;

	@PostMapping("/")
	public ResponseEntity<Contact> saveContact(@Valid  @RequestBody Contact contact) {
		if( null==contact.getEmail()){
		throw new EmailNotFoundException("email id not present");
		}
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


	/*@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> emailNotFoundException(RecordNotFoundException exception){
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}*/
}

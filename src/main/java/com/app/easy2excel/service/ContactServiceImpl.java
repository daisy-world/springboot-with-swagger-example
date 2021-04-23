package com.app.easy2excel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.easy2excel.entity.Contact;
import com.app.easy2excel.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ContactServiceImpl implements ContactService {
	
	@Autowired ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact contact) {
		
		log.debug("inside save contact method..");

		Contact newContact = new Contact();
		newContact.setFirstName(contact.getFirstName());
		newContact.setLastName(contact.getLastName());
		newContact.setEmail(contact.getEmail());
		newContact.setPhoneNo(contact.getPhoneNo());
		contactRepository.save(newContact);
		return newContact;
	}

	@Override
	public Contact getContactDetailsById(Long id) {
		log.debug("inside fetch contact by id method..");

		Optional<Contact> contact = contactRepository.findById(id);
		
		return contact.get();
	}

	@Override
	public List<Contact> getAllContactList() {
		log.debug("inside fetch all contacts method..");

		List<Contact> contactList = contactRepository.findAll();		
		return contactList;
	}

	@Override
	public Contact updateContactById(Long id, Contact contact) {
		
		log.debug("inside update  contact method..");

		Optional<Contact> dbContact = contactRepository.findById(id);
		Contact newContact =dbContact.get();

		if(dbContact.isPresent()) {
			newContact.setFirstName(contact.getFirstName());
			newContact.setLastName(contact.getLastName());
			newContact.setEmail(contact.getEmail());
			newContact.setPhoneNo(contact.getPhoneNo());
			contactRepository.save(newContact);	
			
		}
		
		return newContact;
	}

	@Override
	public void deleteContactById(Long id) {
		log.debug("inside delete  contact method..");

		Optional<Contact> dbContact = contactRepository.findById(id);
		if(dbContact.isPresent()) {
			contactRepository.delete(dbContact.get());
		}
		
	}

}

package com.app.easy2excel.service;

import java.util.List;
import com.app.easy2excel.entity.Contact;

public interface ContactService {

	public	Contact saveContact(Contact contact);

	public	Contact getContactDetailsById(Long id);

	public List<Contact> getAllContactList();

	public Contact updateContactById(Long id, Contact contact);

	public void deleteContactById(Long id);

}

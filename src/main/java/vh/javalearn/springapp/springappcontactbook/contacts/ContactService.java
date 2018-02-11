package vh.javalearn.springapp.springappcontactbook.contacts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public void addContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public List<Contact> getContacts(){
		List<Contact> contacts = new ArrayList<>();
		contactRepository.findAll().forEach(t->contacts.add(t));
		return contacts;
	}

}

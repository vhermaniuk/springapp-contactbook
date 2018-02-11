package vh.javalearn.springapp.springappcontactbook.contacts;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, String>{

}

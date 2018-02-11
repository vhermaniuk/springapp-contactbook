package vh.javalearn.springapp.springappcontactbook.contacts;

//import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contacts/create")
	public ModelAndView createContactView() {
		ModelAndView modelAndView = new ModelAndView("createcontact");
		modelAndView.addObject("contact", new Contact());
		modelAndView.addObject("allContacts", contactService.getContacts());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/contacts")
	public ModelAndView createContact(@Valid Contact contact, BindingResult result) {
		ModelAndView modelAndView= new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validating errors while submitting form.");
			modelAndView.setViewName("createcontact");
			modelAndView.addObject("contact", contact);
			modelAndView.addObject("allContacts", contactService.getContacts());
			return modelAndView;
		}
		contactService.addContact(contact);
		modelAndView.addObject("allContacts", contactService.getContacts());
		modelAndView.setViewName("contactinfo");
		logger.info("Contact info succesfully added.");
		return modelAndView;
	}
	
	@RequestMapping("/contacts")
	public ModelAndView getContacts() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allContacts", contactService.getContacts());
		modelAndView.setViewName("contactinfo");
		return modelAndView;
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/contacts")
//	public void postContact(@RequestBody Contact contact) {
//		contactService.addContact(contact);
//	}


}

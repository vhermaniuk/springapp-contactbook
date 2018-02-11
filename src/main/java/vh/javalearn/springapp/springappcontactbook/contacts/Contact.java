package vh.javalearn.springapp.springappcontactbook.contacts;

//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.IntStream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contact {
	
	@Id
//	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=13, max=13)
	private String number;
	@NotNull
	private String name;
	private String surname;
	private String lastname;
	
	public Contact(String id, String number, String name, String surname, String lastname) {
		super();
//		this.sequence = (String) IntStream.generate(new AtomicInteger()::getAndIncrement);
//		this.id = id;
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.lastname = lastname;
	}

	public void setId(Long id) {
		this.id = id;//IntStream.generate(new AtomicInteger()::getAndIncrement);
	}
	
	public Long getId() {
		return id;
	}

	public Contact() {
		
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}

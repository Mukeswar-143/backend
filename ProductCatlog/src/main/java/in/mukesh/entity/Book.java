package in.mukesh.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	private Long price;
	private String author;
	
	@EmbeddedId
	private BookPk bookpk;

}

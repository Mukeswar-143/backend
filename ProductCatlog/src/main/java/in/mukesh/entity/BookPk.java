package in.mukesh.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookPk {
	
	private Long bookId;
	
	private Long bookName;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getBookName() {
		return bookName;
	}

	public void setBookName(Long bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookPk [bookId=" + bookId + ", bookName=" + bookName + "]";
	}

}

package pl.sda.hibernate.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable // klase z kluczem zlozonym musimy oznaczyc jako embedaable
public class StudentId implements Serializable { // klasa z kluczem zlozonym musi implementowac interfejs Serializable

    private static final long serialVersionUID = 13L; // dobra praktyka - dla interfejsu Serializable dodoac unikalny serialVersionUUD

    private int documentId;
    private String indexNumber;

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }
}

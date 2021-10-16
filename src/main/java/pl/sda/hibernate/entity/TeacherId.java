package pl.sda.hibernate.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Zeby uzyc tej klasy jaki klucz zlozony, trzeba dodac adnotacje Embeddable
 */
@Embeddable
public class TeacherId implements Serializable { // wymagane dla EmbadableId

    private static final long serialVersionUID = 12L; // dobra praktyka - dla interfejsu

    private int documentId;
    private String licence;

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
}

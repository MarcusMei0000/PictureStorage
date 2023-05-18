package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Artist {
    private long idArtist;
    private String lastName;
    private String firstName;
    private String middleName;
    private String patronymicName;
    private long idCountry;

    public String toStringAttributes() {
        if (middleName != null)
            return idArtist + " "  + firstName + " " + middleName + " " + lastName + " ";
        if (patronymicName != null)
            return idArtist + " " + lastName + " " + firstName + " " + patronymicName + " ";

        return idArtist + " " + lastName;
    }
}

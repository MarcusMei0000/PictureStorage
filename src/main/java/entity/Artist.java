package entity;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder

public class Artist {
    private long idArtist;
    private String lastName;
    private String firstName;
    private String middleName;
    private String patronymicName;
    private String country;

    public String toStringAttributes() {
        if (middleName != null)
            return idArtist + " "  + firstName + " " + middleName + " " + lastName + " " + country;
        return idArtist + " " + lastName + " " + firstName + " " + patronymicName + " " + country;
    }
}

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
}

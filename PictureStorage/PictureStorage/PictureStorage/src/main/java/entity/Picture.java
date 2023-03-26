package entity;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class Picture {
    private long idPicture;
    private String name;
    private String country;
    private LocalDate dateOfPainting;
    private long idArtist;
}

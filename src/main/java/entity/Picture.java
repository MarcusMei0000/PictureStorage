package entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Picture {
    private long idPicture;
    private String name;
    private LocalDate dateOfPainting;
    private long idArtist;
    public Picture(long id, String pictureName) {
        idPicture = id;
        name = pictureName;
        dateOfPainting = null;
    }
    public String toStringAttributes() {
        return idPicture + " "  + name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Picture picture = (Picture) o;
        return idArtist == picture.getIdArtist() && name.equals(picture.getName());
    }
}

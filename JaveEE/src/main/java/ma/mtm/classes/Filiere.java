package ma.mtm.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filiere {
    private int idFil ;
    private String nomFil;
    public Filiere(String nomFil) {
        this.nomFil = nomFil;
    }
}

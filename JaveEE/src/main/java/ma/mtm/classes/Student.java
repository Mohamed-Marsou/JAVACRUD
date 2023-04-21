package ma.mtm.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int idEtu;
    private String nom, prenom;
    private String sexe;
    private String filiere;

    public Student(String nom, String prenom, String sexe, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.filiere = filiere;
    }
}

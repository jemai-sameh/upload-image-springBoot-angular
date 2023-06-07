package tn.teams.workshopuploadimage.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;
    @Column(name = "nom_prenom", nullable = false)
    private String fullName ;
    private Integer age ;
    private String image;
   //// private byte[] images;

}

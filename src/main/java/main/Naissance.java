package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Sébastien MARCHAND
 * Class qui représente une naissance
 *
 */
public class Naissance {
	
	/** annee de naissance*/
	private long annee;
	/** DateEvenement date complète de la naissance ( jour mois année)*/
	private Date DateEvenement;
	/** nombre Nombre de naissance dans la journée*/
	private long nombre;

	
	/**Constructeur de la classe Naissance
	 * @param annee
	 * @param DateEvenement
	 * @param nombre
	 */
	Naissance(long annee, String DateEvenement, long nombre)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.FRANCE);
		this.annee =annee;
		try {
			this.DateEvenement = sdf.parse(DateEvenement);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.nombre = nombre;
	}
										//---------------------Getter---------------------//
	/**Getter
	 * @return the annee l'année de naissance
	 */
	public long getAnnee() {
		return annee;
	}

	/**Getter
	 * @return the dateEvenement objet Date 
	 */
	public Date getDateEvenement() {
		return DateEvenement;
	}

	/**Getter
	 * @return the nombre de naissance
	 */
	public long getNombre() {
		return nombre;
	}
										//---------------------Redéfinition---------------------//

	/**
	 *Redéfinition de ToString permetant un affichage des informations plus clair
	 */
	@Override

	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		return "Année :" + annee + "\tDate de la naissance : " +  sdf.format(DateEvenement) + "\tNombre de naissance :" + nombre;
	}
}

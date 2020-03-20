package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author S�bastien MARCHAND
 * Class qui repr�sente une naissance
 *
 */
public class Naissance {
	
	/** annee de naissance*/
	private long annee;
	/** DateEvenement date compl�te de la naissance ( jour mois ann�e)*/
	private Date DateEvenement;
	/** nombre Nombre de naissance dans la journ�e*/
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
	 * @return the annee l'ann�e de naissance
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
										//---------------------Red�finition---------------------//

	/**
	 *Red�finition de ToString permetant un affichage des informations plus clair
	 */
	@Override

	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		return "Ann�e :" + annee + "\tDate de la naissance : " +  sdf.format(DateEvenement) + "\tNombre de naissance :" + nombre;
	}
}

package main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;


/**
 * @author Sébastien MARCHAND
 * 
 * Permet de lancer le programme
 * Utilise les expressions lambda
 *
 *Permet d'afficher des informations après lecture d'un fichier excel
 *
 *affichage de toute les naissance en 1900
 *afficher le total de naissance en 1900
 *afficher la moyenne de naissance en 1971( avec un mapToLong() et un autre avec collect() )
 *
 */
public class ProgrammeMain {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\atlantis\\eclipse-workspace\\Naissance\\Ressources\\naissances_depuis_1900.csv");
	    List<String> lignes = FileUtils.readLines(file, "UTF-8");
	    lignes.remove(0);
	    
		List<Naissance> naissances = new ArrayList<Naissance>();
		
	    for(String ligne : lignes)
		{
			String[] morceaux = ligne.split(";");
			Naissance nouvelleNaissance = new Naissance(Long.parseLong(morceaux[1]),morceaux[2],Long.parseLong(morceaux[3]));
			naissances.add(nouvelleNaissance);
		}
	    																		//affichage test sans lambda
		System.out.println("------------------Test------------------\n");

	    long nombre_Naissance_1900 = 0;
	    for(Naissance naissance : naissances)
		{
	    	if(naissance.getAnnee() == 1900)
	    	{
	    		System.out.println(naissance);
	    		nombre_Naissance_1900 += naissance.getNombre();
	    	}
		}
	    																				//affichage avec lambda
		System.out.println("------------------Affichage 1900------------------\n");

	    naissances.stream()																//on récupère la liste dans un stream
	    .filter(e-> e.getAnnee() == 1900)												//on filtre chaque naissance pour qu'elle soit en 1900
	    .forEach(System.out::println);;													//pour chacun des résultat on affiche l'objet, 
	    																				//avec la méthode ToString redéfinie pour l'affichage des informations

	    long result = 0;
	    
	    System.out.println("Nombre de naissance dans en 1900(sans lambda) :" + nombre_Naissance_1900);
	    
		System.out.println("------------------Affichage total 1900------------------\n");

	    
	    
	    result = naissances.stream()												//on récupère la liste dans un stream
	    		.filter(e-> e.getAnnee() == 1900)									//on filtre chaque naissance pour qu'elle soit en 1900
	    		.map(n -> n.getNombre())											//on retourne le nombre de naissance
	    		.reduce((n1 ,  n2)-> n1 + n2)										//chaque nouveau nombre est additionner avec l'ancien résultat
	    		.get();																//on retourne le résultat final

	    System.out.println("Nombre de naissance dans en 1900 :" + result);
	    
	    
		System.out.println("------------------Affichage moyenne( average() ) 1971------------------\n");

	    double resultmoyenne = 0;
	    resultmoyenne = naissances.stream()											//on récupère la liste dans un stream
	    		.filter(e-> e.getAnnee() == 1971)									//on filtre chaque naissance pour qu'elle soit en 1971
	    		.mapToLong(n -> n.getNombre())										//on retourne le nombre de naissance
	    		.average()															//retourne la moyenne du nombre de naissance par jou(nombre délément du stream)
	    		.getAsDouble();														//retourne un double
	    
	    System.out.println("Nombre moyenne de naissance en 1971 :" + resultmoyenne);

	    
		System.out.println("------------------Affichage moyenne( collect() ) 1971------------------\n");

	    resultmoyenne = naissances.stream()											//on récupère la liste dans un stream
	    		.filter(e->e.getAnnee() == 1970)									//on filtre chaque naissance pour qu'elle soit en 1971
	    		.collect(Collectors.averagingLong(Naissance::getNombre));			//retourn la moyenne de la collection(naissances si 1971) en long de chaque naissance
	    
	    System.out.println("Nombre moyenne de naissance en 1971(collectors :" + resultmoyenne);


	}
}

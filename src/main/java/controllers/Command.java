package controllers;

/**
 * Interface général de Command
 * @author Mathieu K
 *
 */
public interface Command {
	
	/**
	 * Procedure de calcul
	 * @param value paramètre à calculer
	 * @return nombre à display
	 */
	double redo(final double value);
	
	/**
	 * Méthode d'affichage
	 */
	String toString();
	
	/**
	 * Optention de la valeur de la commande
	 * @return double
	 */
	double getValue();
}

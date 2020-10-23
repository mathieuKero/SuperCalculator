package controllers;

/**
 * Interface g�n�ral de Command
 * @author Mathieu K
 *
 */
public interface Command {
	
	/**
	 * Procedure de calcul
	 * @param value param�tre � calculer
	 * @return nombre � display
	 */
	double redo(final double value);
	
	/**
	 * M�thode d'affichage
	 */
	String toString();
	
	/**
	 * Optention de la valeur de la commande
	 * @return double
	 */
	double getValue();
}

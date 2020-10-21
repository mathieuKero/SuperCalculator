package controllers;

public class Addition implements Command{
	
	/**
	 * First number to add
	 */
	private double nbr1;
	
	/**
	 * Second number to add
	 */
	private double nbr2;
	
	/**
	 * @return the nbr1
	 */
	public double getNbr1() {
		return nbr1;
	}

	/**
	 * @param nbr1 the nbr1 to set
	 */
	public void setNbr1(double nbr1) {
		this.nbr1 = nbr1;
	}

	/**
	 * @return the nbr2
	 */
	public double getNbr2() {
		return nbr2;
	}

	/**
	 * @param nbr2 the nbr2 to set
	 */
	public void setNbr2(double nbr2) {
		this.nbr2 = nbr2;
	}
	
	/**
	 * Create a new instance of Addition
	 * @param nbr1 First number to add
	 * @param nbr2 Second number to add
	 */
	public Addition(double nbr1, double nbr2) {
		super();
		this.nbr1 = nbr1;
		this.nbr2 = nbr2;
	}

	@Override
	public double calculate() {
		return nbr1 + nbr2;
	}
	
	@Override
	public void revert() {
		// TODO Auto-generated method stub
	}
}

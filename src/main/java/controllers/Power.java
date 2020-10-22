package controllers;

/**
 * Power Class
 * Allow user to power one or two number
 * @author Sofiane B
 */
public class Power implements Command {

	/**
	 * Global variables
	 * @param _nbr1 Number which is going to be powered
	 * @param _nbr2 Number which contain the number of the power
	 */
	private double _nbr1, _nbr2, _result;

	/**
	 * Get the _result value and return it
	 * @return _result Value of the operation result
	 */
	public double getResult() {
		return _result;
	}

	/**
	 * Set the _result object parameter value
	 * @param result Contain the value which is going to be set to the _result global
	 * variable
	 */
	public void setResult(double result) {
		this._result = result;
	}

	/**
	 * Get _nbr1 value and return it
	 * @return _nbr1 Value of the first Number
	 */
	public double getNbr1() {
		return _nbr1;
	}

	/**
	 * Set the _nbr1 object parameter value
	 * @param nbr1 Contain the value which is going to be set to the _nbr1 global variable
	 */
	public void setNbr1(double nbr1) {
		this._nbr1 = nbr1;
	}

	/**
	 * Get _nbr2 value and return it
	 * @return _nbr2 Value of the second Number
	 */
	public double getNbr2() {
		return _nbr2;
	}

	/**
	 * Set the _nbr2 object parameter value
	 * @param nbr2 Contain the value which is going to be set to the _nbr2 global variable
	 */
	public void setNbr2(double nbr2) {
		this._nbr2 = nbr2;
	}

	/**
	 * Create a new instance of Power
	 * @param nbr1 Number which is going to be powered
	 * @param nbr2 Number which contain the number of the power
	 */
	public Power(double nbr1, double nbr2){
		super();
		this._nbr1 = nbr1;
		this._nbr2 = nbr2;
		this._result = 0;
	}

	@Override
	public void calculate() {
		if(this._nbr1 !=0 && this._nbr2 != 0){
			this._result = (_nbr1 * _nbr1) * _nbr2;
		}
	}

	@Override
	public void revert() {
		// TODO: To Complete
	}

	@Override
	public String toString() { return String.format("(%s * %s) * %d", _nbr1, _nbr2, _result); }
}
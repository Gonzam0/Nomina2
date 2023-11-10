package model;

public class Nomina {
	private String dni; // DNI del empleado asociado a la nómina
	private double sueldo; // Sueldo correspondiente a la nómina

	// Array que contiene los sueldos base correspondientes a cada categoría.
	private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	/**
	 * Calcula el sueldo de un empleado en función de su categoría y años
	 * trabajados.
	 *
	 * @param emp El empleado del que se va a calcular el sueldo.
	 * @return El sueldo calculado para el empleado.
	 */
	public double sueldo(Empleado emp) {
		// El sueldo se calcula sumando el sueldo base correspondiente a la categoría
		// del empleado
		// y un adicional de 5000 por cada año trabajado.
		double sueldoCalculado = SUELDO_BASE[emp.getCategoria() - 1] + 5000 * emp.anyos;
		return sueldoCalculado;
	}

	/**
	 * Crea un nuevo objeto de tipo Nómina con un DNI y sueldo especificados.
	 *
	 * @param dni    El DNI del empleado asociado a la nómina.
	 * @param sueldo El sueldo correspondiente a la nómina.
	 */
	public Nomina(String dni, double sueldo) {
		super();
		this.dni = dni;
		this.sueldo = sueldo;
	}

	/**
	 * Crea un nuevo objeto de tipo Nómina sin valores iniciales.
	 */
	public Nomina() {
		// Constructor vacío
	}

	/**
	 * Obtiene el DNI del empleado asociado a la nómina.
	 *
	 * @return El DNI del empleado asociado a la nómina.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el DNI del empleado asociado a la nómina.
	 *
	 * @param dni El DNI del empleado asociado a la nómina.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtiene el sueldo correspondiente a la nómina.
	 *
	 * @return El sueldo correspondiente a la nómina.
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * Establece el sueldo correspondiente a la nómina.
	 *
	 * @param sueldo El sueldo correspondiente a la nómina.
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Genera una representación en forma de cadena de la Nómina, que incluye el DNI
	 * y el sueldo.
	 *
	 * @return Una cadena que representa la nómina.
	 */
	@Override
	public String toString() {
		return "Nomina [dni=" + dni + ", sueldo=" + sueldo + "]";
	}

}

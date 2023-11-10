package laboral;

/**
 * Clase Persona
 */
public class Persona {
	
	/**
	 * Declaracion de variables
	 */
	public String nombre;
	public String dni;
	public String sexo;
	
	
	/**
	 * Constructor Persona completo
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */
	public Persona(String nombre, String dni, String sexo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * Constructor Persona sin dni
	 * @param nombre
	 * @param sexo
	 */
	public Persona(String nombre, String sexo) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
	}
	
	public Persona() {
		
	}
	
	
	/**
	 * Setter de dni
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Salida por consola de nombre y dni de la persona
	 */
	public void imprime() {
		System.out.println("Nombre: " + nombre);
		System.out.println("DNI: " + dni);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}
	
	

}
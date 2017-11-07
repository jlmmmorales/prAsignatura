package prAsignatura;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String nombre,String dni,double nota) throws AlumnoException{
		if(nota<0){
			throw new AlumnoException("ERROR: Nota menos que cero.");
		}
		this.nombre = nombre;
		this.dni = dni;
		this.nota = nota;
	}
	public Alumno(String nombre, String dni) throws AlumnoException{
		this(nombre,dni,0.0);
	}
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public double getNota() {
		return nota;
	}
	
	@Override
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Alumno) {
			Alumno p = (Alumno) o;
			res = (nombre.equalsIgnoreCase(p.getNombre()) &&
					dni.equalsIgnoreCase(p.getDni()));
		}
		return res;
	}
	
	@Override
	public int hashCode(){
		return nombre.hashCode() + dni.hashCode();
	}
	
	@Override
	public String toString(){
		return dni + " " + nombre;
	}
}

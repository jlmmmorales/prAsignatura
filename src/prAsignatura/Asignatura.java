package prAsignatura;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Asignatura {
	private String nombre;
	private Map<Grupo, Set<Alumno>> grupos;
	private List<Alumno> alumnos;
	private List<String> erroneas;

	public static enum Grupo { A, B, C};

	public Asignatura(String n) {
		nombre = n;
		alumnos = new LinkedList<Alumno>();
		erroneas = new LinkedList<String>();
	}
	
	public void leerDatos(String nomFichero) throws IOException{
		try( Scanner fichero = new Scanner(new File(nomFichero)) )
		{
			while(fichero.hasNextLine()){
				StringAAlumno(fichero.nextLine());
			}
		}
		
	}
	
	private void StringAAlumno (String linea){
		String nombre = "";
		String dni = "";
		Double nota = 0.0;
		Alumno alumno;
		
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[-]");
			if(sc.hasNext()){
				dni = sc.next(); 
				//System.out.println(dni);
			}
			if(sc.hasNext()){
				nombre = sc.next();
				//System.out.println(nombre);
			}
			if(sc.hasNext()){
				nota = sc.nextDouble();
				//System.out.println(nota);
			}
			if(dni.matches("[0-9]{8}[A-Z]")){
				if(nombre.matches("[a-zA-Z, ]+")){
					alumno = new Alumno(nombre, dni, nota);
					if(!alumnos.contains(alumno)){
						alumnos.add(alumno);
						//System.out.println(alumno.toString());
					}
				}else{
					//System.out.println("Nombre con formato incorrecto "+nombre);
					erroneas.add(linea);
				}
			}else{
				//System.out.println("DNI con formato incorrecto "+dni);
				erroneas.add(linea);
			}
		}catch (InputMismatchException e){
			//throw new AlumnoException("ERROR: Se esperaba una nota numérica.");
			//System.out.println("Nota no numerica "+linea);
			erroneas.add(linea);
		}catch (AlumnoException e){
			//nota inferior a cero
			erroneas.add(linea);
		}
	}

	public List<Alumno> getAlumnos(){
		return alumnos;
	}
	
	public List<String> getErroneas(){
		return erroneas;
	}
	
	/**
	 * Devuelve la media de las calificaciones de los alumnos
	 * @return media
	 */
	public double getMedia(){
		double media = 0.0;
		
		if(alumnos.size() > 0){
			for( Alumno a : alumnos){
				media += a.getNota();
			}
			media = media / alumnos.size();
		}
		return media;
	}
	
	/**
	 * Devuelve un conjunto con los alumnos cuya nota es igual o superior a 5
	 * @return
	 */
	public Set<Alumno> getAlumnosAprobados(){
		Set<Alumno> conjuntoAlumnos = new HashSet<Alumno>();
		
		for( Alumno a : alumnos){
			if(a.getNota() >= 5.0){
				conjuntoAlumnos.add(a);
			}
		}
		return conjuntoAlumnos;
	}
	
	/**
	 * Elimina de la lista de alumnos aquellos alumnos que se encuentran
	 * en la colección de alumnos
	 */
	public void anularMatricula(Collection<Alumno> alumnosAnularMatricula){
		
		alumnos.removeAll(alumnosAnularMatricula);
		
		/*for( Alumno alumnoAnular : alumnosAnularMatricula){
			if(alumnos.contains(alumnoAnular)){
				alumnos.remove(alumnoAnular);
			}
		}*/
	}
	
	/**
	 * Devuelve la nota de un alumno o una excepción si el alumno no esta en la lista.
	 * @param al
	 * @return nota
	 * @throws AlumnoException
	 */
	public double getCalificacion(Alumno al) throws AlumnoException{
		double nota = 0.0;
		
		if (alumnos.contains(al)){
			for( Alumno a : alumnos){
				if(a.equals(al)){
					nota = a.getNota();
				}
			}
		}else{
			throw new AlumnoException("ERROR. Método getCalificacion. El alumno no esta en la lista de alumnos");
		}
		return nota;
	}

	/*
	public Set<Alumno> grupo(Grupo gr) {
		//Completar la implementación
	}

	public void addAlumno(Grupo gr, Alumno al) {
		//Completar la implementación
	    }

	    public boolean contiene(Alumno al){
			//Completar la implementación
	    }

	    public SortedSet<Alumno> alumnos1(){
			//Completar la implementación
	    }
	    
	    public SortedSet<Alumno> alumnos2(){
			//Completar la implementación
	    }
	    
	    public SortedSet<Alumno> alumnos3(){
			//Completar la implementación
	    }
*/	    
	
	/**
	 * “<Nombre asignatura>: \n” 
	 * seguida de toda la información contenida en la lista alumnos. Tras ello, la cadena “\n
	 * Errores\n” 
	 * y toda la información contenida en la lista erróneas.
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder(nombre+": \n");
		
		for(Alumno a : alumnos){
			cadena.append(a.toString()+"\n");
		}
		cadena.append("\nErrores:\n");
		for(String s : erroneas){
			cadena.append(s.toString()+"\n");
		}
		
		return cadena.toString();
	}


}

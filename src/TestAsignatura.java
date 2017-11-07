import prAsignatura.*;


public class TestAsignatura {
	
   
	public static void main(String[] args) {
		Asignatura poo = new Asignatura("Programaci�n en Java");
		System.out.println(poo);
		//N�tese c�mo se accede a los valores del tipo enumerado
		try{
			poo.addAlumno(Asignatura.Grupo.A, new Alumno("Juan Garc�a","25653443S",8.1) ); 
			poo.addAlumno(Asignatura.Grupo.B, new Alumno("Manuel L�pez","23322443K",4.3) );
			poo.addAlumno(Asignatura.Grupo.B, new Alumno("Petra Santana","53553421D",7.1) );
			poo.addAlumno(Asignatura.Grupo.C, new Alumno("Marina Godoy","55343442L",6.3) );
			poo.addAlumno(Asignatura.Grupo.B, new Alumno("Pedro Fern�ndez","34242442J") );
			poo.addAlumno(Asignatura.Grupo.A, new Alumno("Luisa L�pez","42424312G",8.1) );
			poo.addAlumno(Asignatura.Grupo.A, new Alumno("Juana Merlo", "24433522T",3.8));
			
			System.out.println(poo);
			
			if (poo.contiene(new Alumno("Juan Garc�a","25653443S",0)))
				System.out.println("El alumno  ha sido encontrado");;
			
			System.out.println("Grupo A:" + poo.grupo(Asignatura.Grupo.A));
			System.out.println("Listado de alumnos");
			System.out.println(poo.alumnos1());
			System.out.println(poo.alumnos2());
			System.out.println(poo.alumnos3());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}

package noodle.test;

import java.time.LocalDate;
import noodle.asignatura.ejercicio.*;

public class TestEjercicio {

	public static void main(String[] args) {
		LocalDate fIni = LocalDate.of(2017, 03, 30);
		LocalDate fFin = LocalDate.of(2017, 04, 15);
		//Creamos un ejercicio
		Ejercicio e = new Ejercicio(fIni, fFin, 1.5, true, 0);
		//Le añadimos preguntas
		Pregunta p1 = e.crearPregunta("Simple", 1, "Selecciona la respuesta correcta", 1, 0);
		Pregunta p2 = e.crearPregunta("Unica", 1.5, "Que fase del desarrollo del software requiere mayor esfuerzo", 0.8, 0.2);
		Pregunta p3 = e.crearPregunta("Multiple", 2, "Que diagramas son necesarios para el desarrollo de una aplicacion", 1, 0.1);
		Pregunta p4 = e.crearPregunta("Abierta", 1.25, "En que fase se programa la aplicacion", 1.3, 0);
		
		Respuesta r11 = p1.crearRespuesta("La primera fase en el desarrollo de software es la codificacion", false);
		Respuesta r12 = p1.crearRespuesta("La primera fase en el desarrollo de software es el estudio de viabilidad", true);

		Respuesta r21 = p2.crearRespuesta("Todas requieren el mismo", false);
		Respuesta r22 = p2.crearRespuesta("Codificacion", false);
		Respuesta r23 = p2.crearRespuesta("Pruebas", false);
		Respuesta r24 = p2.crearRespuesta("Mejoras", true);
		
		Respuesta r31 = p3.crearRespuesta("Ninguna", false);
		Respuesta r32 = p3.crearRespuesta("De uso", true);
		Respuesta r33 = p3.crearRespuesta("De estado", true);
		Respuesta r34 = p3.crearRespuesta("De construccion", false);
		
		Respuesta r41 = p4.crearRespuesta("Codificacion", true);
		Respuesta r42 = p4.crearRespuesta("codificacion", true);
		Respuesta r43 = p4.crearRespuesta("Codificación", true);
		Respuesta r44 = p4.crearRespuesta("codificación", true);
		
		e.verEjercicio();
		
		System.out.println("\nComprobamos si el ejercicio es correcto");
		System.out.println(e.acabarEjercicio());
		
		
	}

}

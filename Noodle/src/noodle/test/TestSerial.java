package noodle.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import noodle.asignatura.*;

import noodle.Noodle;
import noodle.usuario.*;

public class TestSerial {
	public static void main(String[] args){
		Curso c1 = new Curso("Calculo", "Marsden");
		Alumno al = new Alumno(2810, "pass", "name", "name2", "mail");
		al.addCursosMat(c1);
		Alumno al2 = null;
		c1.addAlumnos(al);
		Noodle.getInstance().addUsuario(al);
		System.out.println(Noodle.getInstance().getUsuarios());
		System.out.println(al.getCursosMat());
		System.out.println(c1.getAlumnos());
		
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try{
			fileOut = new FileOutputStream("txt/alumno.ser");
			out = new ObjectOutputStream(fileOut);
			out.writeObject(al);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				out.close();
				fileOut.close();
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		FileInputStream fileIn = null;
		ObjectInputStream ob = null;
		
		try{
			fileIn= new FileInputStream("txt/alumno.ser");
			ob = new ObjectInputStream(fileIn);
			al2 = (Alumno) ob.readObject();
			ob.close();
			fileIn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(al2);
		System.out.println(al.getCursosMat());
		System.out.println(c1.getAlumnos());
	}
}
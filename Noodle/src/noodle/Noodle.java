package noodle;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;
import noodle.asignatura.*;
import noodle.usuario.*;


public class Noodle implements java.io.Serializable {
	private static Noodle INSTANCE = new Noodle();
    /** usuarios */
	private ArrayList <Usuario> usuarios = new ArrayList <Usuario> ();
	/** cursos */
	private ArrayList <Curso> cursos = new ArrayList <Curso> ();
	/** usuario actual */
	private Usuario cur_usr = null;
	/** id para serialize */
	private static final long serialVersionUID = 1;

    /**
    * Constructor de la clase Noodle
    */
    private Noodle(){
    }

    public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void addUsuario(Usuario usuario) {
		Noodle.getInstance().getUsuarios().add(usuario);
	}

	public ArrayList<Curso> getCursos() {
		return this.cursos;
	}

	public void addCurso(Curso curso) {
		Noodle.getInstance().getCursos().add(curso);
	}
	
	public static void delCurso(Curso curso) {
		Noodle.getInstance().getCursos().remove(curso);
	}

	public Usuario getCur_usr() {
		return this.cur_usr;
	}

	public static void setCur_usr(Usuario cur_usr) {
		Noodle.getInstance().cur_usr = cur_usr;
	}


	/**
     * Obtiene la instancia de Noodle
     * @return INSTANCE de Noodle
     */
    public static Noodle getInstance() {
        return INSTANCE;
    }
    
    public static void setInstance(Noodle newNoodle) {
        INSTANCE = newNoodle;
    }
    
    public static void cargarAlumnos(){
    	FileReader fr = null;
    	BufferedReader br = null;
    	StringTokenizer strt = null;
    	String linea = null;
    	String nombre = null;
    	String apellido = null;
    	String email = null;
    	int numa = -1;
    	String password = null;
    	
    	
    	try{
    	File usuarios = new File ("txt/usuarios.txt");
    	fr = new FileReader (usuarios);
    	br = new BufferedReader(fr);
    	linea = br.readLine();
    	while((linea = br.readLine()) != null){
    		strt = new StringTokenizer(linea, ";", false);
	    	if(strt.countTokens()<5)
	    		continue;
	    	nombre = strt.nextToken(";");
	    	apellido = strt.nextToken(";");
	    	email = strt.nextToken(";");
	    	numa = Integer.parseInt(strt.nextToken(";"));
	    	password = strt.nextToken(";");
	    	Noodle.getInstance().addUsuario(new Alumno(numa, password, nombre, apellido, email));
    	}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		try{
    			fr.close();
    			br.close();	
    		}
    		catch(Exception e2){
    			e2.printStackTrace();
    		}
    	}
    }
    
    public static void cargarCursos(){
    	FileReader fr = null;
    	BufferedReader br = null;
    	StringTokenizer strt = null;
    	String linea = null;
    	String nombre = null;
    	String descripcion = null;
    	
    	
    	try{
    	File cursos = new File ("txt/cursos.txt");
    	fr = new FileReader (cursos);
    	br = new BufferedReader(fr);
    	linea = br.readLine();
    	while((linea = br.readLine()) != null){
    		strt = new StringTokenizer(linea, ";", false);
	    	if(strt.countTokens()<2)
	    		continue;
	    	nombre = strt.nextToken(";");
	    	descripcion = strt.nextToken(";");
	    	Noodle.getInstance().addCurso(new Curso(nombre, descripcion));
    	}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		try{
    			fr.close();
    			br.close();	
    		}
    		catch(Exception e2){
    			e2.printStackTrace();
    		}
    	}
    }
    	public static void cargarProfesor(){
        	FileReader fr = null;
        	BufferedReader br = null;
        	StringTokenizer strt = null;
        	String linea = null;
        	String email = null;
        	int numa = -1;
        	String password = null;
        	
        	
        	try{
        	File usuarios = new File ("txt/profesor.txt");
        	fr = new FileReader (usuarios);
        	br = new BufferedReader(fr);
        	linea = br.readLine();
        	while((linea = br.readLine()) != null){
        		strt = new StringTokenizer(linea, ";", false);
    	    	if(strt.countTokens()<3)
    	    		continue;
    	    	email = strt.nextToken(";");
    	    	numa = Integer.parseInt(strt.nextToken(";"));
    	    	password = strt.nextToken(";");
    	    	Profesor p = new Profesor(numa, password, email);
    	    	Noodle.getInstance().addUsuario(p);
        	}
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}finally{
        		try{
        			fr.close();
        			br.close();	
        		}
        		catch(Exception e2){
        			e2.printStackTrace();
        		}
        	}
    	}
    	
    	public static void cargarNoodle(){
    		Noodle.cargarAlumnos();
    		Noodle.cargarProfesor();
    		Noodle.cargarCursos();
    	}
    	
    	public static void cargar(){
    		FileInputStream fileIn = null;
    		ObjectInputStream ob = null;
    		
    		try{
    			fileIn= new FileInputStream("txt/Noodle.ser");
    			ob = new ObjectInputStream(fileIn);
    			INSTANCE = (Noodle) ob.readObject();
				ob.close();
				fileIn.close();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	public static Usuario login(int id, String password){
    		for(Usuario u : Noodle.getInstance().getUsuarios()){
    			if(u.getIdentificador() == id){
    				if(u.getPassword().equals(password)){
    					Noodle.setCur_usr(u);
    					return u;
    				}
    			}
    		}
    		return null;
    	}
    	
    	public static void logout(){
    		Noodle.setCur_usr(null);
    	}
    	
    	public static Curso crearAsignatura(String nombre, String descripcion){
    		if(Noodle.getInstance().getCur_usr() == null)
    			return null;
    		return Noodle.getInstance().getCur_usr().crearAsignatura(nombre, descripcion);
    	}
    	
    	public static void eliminarAsignatura(String nombre){
    		if(Noodle.getInstance().getCur_usr() == null)
    			return;
    		Noodle.getInstance().getCur_usr().eliminarAsignatura(nombre);
    	}
    	
    	public static void quit(){
    		/* Guarda todas las cosas*/
    		
    		Noodle.logout();
    		Noodle.guardar();
    		System.exit(0);
    	}
    	
    	public static void guardar(){
    		FileOutputStream fileOut = null;
    		ObjectOutputStream out = null;
    		try{
    			fileOut = new FileOutputStream("txt/Noodle.ser");
    			out = new ObjectOutputStream(fileOut);
    			out.writeObject(Noodle.getInstance());
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
    	}

		@Override
		public String toString() {
			return "Noodle [usuarios=" + usuarios + ", cursos=" + cursos + ", cur_usr=" + cur_usr + "]";
		}
    	
    	
}

package proyecto;

import java.util.Date;

public class Clientes {
	private int id;	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String cifNif;
	private String direccion;
	private String poblacion;
	private int cp;
	private boolean sexo;
	private int telefono;
	private int movil;
	private int fax;
	private String email;
	private String ncuenta;
	private String fechaNacimiento;
	private String fechaAlta;
	private String comentarios;

	public Clientes() {
		
	}
	public Clientes(int id, String nombre, String apellido1, String apellido2,String cifnif, String direccion, String poblacion, int cp, Boolean sexo, int telefono, int movil, int fax, String email, String ncuenta, String fechanacimiento, String fechalta, String comentarios) {
		this.id=id;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.cifNif=cifnif;
		this.direccion=direccion;
		this.poblacion=poblacion;
		this.cp=cp;
		this.sexo=sexo;
		this.telefono=telefono;
		this.movil=movil;
		this.fax=fax;
		this.email=email;
		this.ncuenta=ncuenta;
		this.fechaNacimiento=fechanacimiento;
		this.fechaAlta=fechalta;
		this.comentarios=comentarios;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCifNif() {
		return cifNif;
	}
	public void setCifNif(String cifNif) {
		this.cifNif = cifNif;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public boolean getSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNcuenta() {
		return ncuenta;
	}
	public void setNcuenta(String ncuenta) {
		this.ncuenta = ncuenta;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}

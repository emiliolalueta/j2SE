package paquetebeans;

public class Empleado 
{
	public int numempleado;
	public String apellido;
	public String oficio;
	public int directores;
	public String Fecha;
	public Double salario;
	public Double comision;
	public int departamento;
	public Empleado (int numempleado, String apellido, String oficio, int direcotores, String Fecha, Double salario, Double comision, int departamento)
	{
		this.numempleado=numempleado;
		this.apellido=apellido;
		this.oficio=oficio;
		this.directores=direcotores;
		this.Fecha=Fecha;
		this.salario=salario;
		this.comision=comision;
		this.departamento=departamento;
	}
	public Integer getNumempleado() {
		return numempleado;
	}
	public void setNumempleado(Integer numempleado) {
		this.numempleado = numempleado;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public Integer getDirectores() {
		return directores;
	}
	public void setDirectores(Integer directores) {
		this.directores = directores;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	public Integer getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}
}
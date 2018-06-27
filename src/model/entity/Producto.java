package model.entity;

public class Producto {
	
	private String name;
	private double pPrecio;

	
	public Producto(String name, double pPrecio) {
		this.name = name;
		this.pPrecio = pPrecio;
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getpPrecio() {
		return pPrecio;
	}
	public void setpPrecio(double pPrecio) {
		this.pPrecio = pPrecio;
	}
	
	
}

package despicableMe;

public class Mision {
	private String nombre;
	private String descripcion;
	private int puntuacionNecesaria;

	public Mision(String nombre, String description, int puntuacionNecesaria) {
		this.nombre = nombre;
		this.descripcion = description;
		if (puntuacionNecesaria >= 10 && puntuacionNecesaria <= 400) {
			this.puntuacionNecesaria = puntuacionNecesaria;
		}
		else if (puntuacionNecesaria < 10) {
			this.puntuacionNecesaria = 10;
		} else {
			this.puntuacionNecesaria = 400;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPuntuacionNecesaria() {
		return puntuacionNecesaria;
	}

	public void setPuntuacionNecesaria(int puntuacionNecesaria) {
		if (puntuacionNecesaria >= 10 && puntuacionNecesaria <= 400) {
			this.puntuacionNecesaria = puntuacionNecesaria;
		}
		else if (puntuacionNecesaria < 10) {
			this.puntuacionNecesaria = 10;
		} else {
			this.puntuacionNecesaria = 400;
		}
	}

	@Override
	public String toString() {
		return "Mision [nombre=" + nombre + ", descripcion=" + descripcion + ", puntuacionNecesaria="
				+ puntuacionNecesaria + "]";
	}
	
}

import java.util.Arrays;

public class Villano {
	private String nombre;
	private int nivelMaldad;
	private Minions[] minions;
	private int nivelVictorias;

	public Villano(String nombre, int nivelMaldad) {
		this.nombre = nombre;
		if (nivelMaldad >= 1 && nivelMaldad <= 4) {
			this.nivelMaldad = nivelMaldad;
		} else if (nivelMaldad < 1) {
			this.nivelMaldad = 1;
		} else if (nivelMaldad > 4) {
			this.nivelMaldad = 4;
		}
		this.minions = new Minions[getNivelMaldad() * 10];
		this.nivelVictorias = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelMaldad() {
		return nivelMaldad;
	}

	public Minions[] getMinions() {
		return minions;
	}

	public void setMinions(Minions[] minions) {
		this.minions = new Minions[nivelMaldad * 10];
	}

	public int getNivelVictorias() {
		return nivelVictorias;
	}

	public void setNivelVictorias(int nivelVictorias) {
		this.nivelVictorias = nivelVictorias;
	}

	public void reclutarMinions() {
		for (int i = 0; i < minions.length; i++) {
			if (minions[i] == null) {
				minions[i] = new Minions();

			}
		}

	}

	public void registrarVictorias() {
		nivelVictorias++;
	}

	@Override
	public String toString() {
		return "Villano [nombre=" + nombre + ", nivelMaldad=" + nivelMaldad + ", minions=" + Arrays.toString(minions)
				+ ", nivelVictorias=" + nivelVictorias + "]";
	}

}

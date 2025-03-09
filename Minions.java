
public class Minions {
	private int fuerza;
	private int torpeza;

	public Minions() {
		this.fuerza = (int) (Math.random() * 10) + 1;
		this.torpeza = (int) (Math.random() * 10) + 1;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getTorpeza() {
		return torpeza;
	}

	public void listarInfo() {
		System.out.printf("[ Fuerza: %d , Torpeza: %d ", fuerza, torpeza);

	}

	@Override
	public String toString() {
		return "Minions [fuerza=" + fuerza + ", torpeza=" + torpeza + "]";
	}

}

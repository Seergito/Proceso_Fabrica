package Ej01;


public class Montador extends Thread {

	private Almacen almacen;
	private String nombre;

	public Montador(String nombre,Almacen almacen) {
		this.nombre=nombre;
		this.almacen=almacen;
	}

	public String getNombre() {
		return nombre;
	}


	public void run() {
		for (int i = 0; i < 4; i++) {
			almacen.coger_piezas(nombre);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}
}

class Filosofo implements Runnable {
	RCompartido b = null;
	int i;
	public Filosofo( RCompartido initb, int i ) {

		b = initb;
		this.i=i;
		new Thread( this ).start();

	}
	public void run() {
		while( true ) {
			System.out.println("Fil�sofo "+i+" pensando");
			b.tomar_tenedores(i);
			Util.mySleep(2000);
			System.out.println("Fil�sofo "+i+" comiendo con tenedor "+i+" tenedor "+((i+1)%5));
			b.bajar_tenedores(i);
			System.out.println("Fil�sofo "+i+" bajando tenedor "+i+" tenedor "+((i+1)%5));
			
		}
	}
}

class Pensantes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RCompartido buffer = new RCompartido();
		Filosofo filos[]=new Filosofo[5];
		for(int i=0;i<5;i++)
			filos[i] = new Filosofo( buffer, i);		
	}
}


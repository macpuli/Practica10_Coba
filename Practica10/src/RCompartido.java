class RCompartido {
  //SemaforoBinario mutex=new SemaforoBinario(true);
  //SemaforoContador[] sinc=new SemaforoContador[5];
  String[] estadof=new String[5];
  CircularArrayList<String> estados=new CircularArrayList<String>();
  int count = 0;
  public RCompartido(){
    for(int i=0;i<5;i++){
      estados.add("PENSAR");
  //    sinc[i] = new SemaforoContador(0);
    }
    
  }
  public synchronized void tomar_tenedores(int i){//Método de ingreso
    
    //mutex.P();
    while(estados.get(i-1)=="COMER"
        ||estados.get(i+1)=="COMER")
    {//Condición de sincronización
      Util.myWait( this );//Variable de condición
    }
    estados.set(i, "HAMBRE");
    probar_bocado(i);
    //mutex.V();

  //  sinc[i].P();
  }
  public synchronized void probar_bocado(int i){//Método de ingreso
    if(estados.get(i)=="HAMBRE" && estados.get(i-1)!="COMER"
        &&estados.get(i+1)!="COMER")
    {
      estados.set(i, "COMER");
    //  sinc[i].V();
    }
  }
  public synchronized void bajar_tenedores(int i){//Método de ingreso
    //mutex.P();

    probar_bocado(i-1);
    probar_bocado(i+1);
    //mutex.V();
    estados.set(i, "PENSAR");
      notify();
  }
}
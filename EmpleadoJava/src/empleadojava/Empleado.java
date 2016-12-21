package empleadojava;       
    public class Empleado{
       private String Name;
       private String Apellido;
       private static int cuenta;
       public Empleado(){
          Name="";
          Apellido= "";
          cuenta=0;
       }
       
       public Empleado(String nom, String apell){
        Name=nom;
        Apellido= apell;
        ++cuenta;
       }
       protected void finalize(){
         --cuenta;
         System.out.println("Finalizador del objeto"+ Name + Apellido + "cuenta: "+ cuenta);
       }
       public String obName(){ return Name; }
       public String obApellido(){ return Apellido; }
       public static int obCuenta(){ return cuenta; }        
       public String obEm(){ return "Empleado"+cuenta+": "+Name+" "+ Apellido; }         
    }

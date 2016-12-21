package examen;
public class Examen {

    public static void main(String[] args) {
       Cuenta E1=new Cuenta();
       Cuenta E2, E3;
       E2=new Cuenta(002, "Bernardo", "San Pablo", "4451036065",4000.43);
       E3=new Cuenta(003, "Carlos", "paputino", "44510366628",1993.64);
       E1.setC(001, "Glopi", "Esteustenio", "4451085746", 2143.25);
       System.out.println(E1.toString());
       System.out.println(E2.toString());
       System.out.println(E3.toString());
       
       //Depositar 1000.57 a E2
       System.out.println(E2.toString());
       E2.depositar(1000.57);
       System.out.println(E2.toString());
       
       //Retirar 154.32 a E3
       System.out.println(E3.toString());
       E3.retiro(154.64);
       System.out.println(E3.toString());
       
       //casos error
       
        //Establecer un saldo negativo en E1
       System.out.println(E1.toString());
       E2.setC(001, "Glopi", "Esteustenio", "4451085746",-2143.25);
       System.out.println(E1.toString());
       
       //Retirar mas de lo hay en la cuenta a E3
       System.out.println(E3.toString());
       E3.retiro(1000000);
       System.out.println(E3.toString());
       
              

       
       
       
       
       
       
       
       
       
       
       
       
    }
    
}

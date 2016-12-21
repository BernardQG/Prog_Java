/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadolista;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author WQuintino
 */
public class mole {
    static String m;
    static Scanner in = new Scanner(System.in);
    static Eman E;
    static int d,s;
    public static void imp(ArrayList <Eman> Emp){
    for(int i=0;i<Emp.size(); i++){
           System.out.println(Emp.get(i).obEm(i));
        } 
    
    }
    public static void setM(ArrayList <Eman> Emp){
        String name, Ape;
        int edad;
        double saldo;    
              
        do{
        System.out.print("\tIngresar un empledo:\n"
                + "Nombre: "); name = in.next();
        System.out.print("Apellido: ");   Ape = in.next();
        System.out.print("Edad: ");   edad =  in.nextInt();
        System.out.print("Saldo: ");   saldo = in.nextDouble();
        
            E = new Eman(name, Ape, edad, saldo); 
            Emp.add(E);
         
         System.out.print("Desea Registrar otro empleado: si=1, no=0.\n R = ");
         d = in.nextInt();
        }while(d!=0);
    }
     public static void En(ArrayList <Eman> Emp){
     System.out.println("Eleminando: ");
    
         do{
             System.out.print("Numero de empleado que desea matar:");
            d = in.nextInt();
            Emp.remove(d-1);
            System.out.print("Desea eliminar otro empleado: si=1, no=0\n R = ");
            d = in.nextInt();
        }while(d!=0);
          imp(Emp);
     }
          public static void Em(ArrayList <Eman> Emp){
        System.out.print("\tEleminando por nombre "
                + "Nombre de empleado a matar: ");
        m = in.nextLine();        
        try{
          for(int i=0;i<Emp.size(); i++){
            if(Emp.get(i).obName().equalsIgnoreCase(m)){
                Emp.remove(i);
                
                System.out.println("Se encontro");
            }            
          }
        }
        catch(Exception e){
            System.out.println("No encontro");
        }
          }
        public static void menu(ArrayList <Eman> Emp){
         System.out.print("\tMenu\n"
                 + "===Opciones===\n"
                 + "0 = Salir\n"
                 + "1 = Ingresar Empleados.\n"
                 + "2 = Eliminar Empleado por su ID(numero).\n"
                 + "3 = Eliminar Empleado por su nombre.\n"
                 + "4 = Imprimir lista de empleados.\n"
                 + "5 = Modificar un Empleado\n  R = ");
         d = in.nextInt();
          switch(d){
            case 0:  System.exit(0); break;
            case 1:  setM(Emp); break;
            case 2:  En(Emp); break;
            case 3:  Em(Emp); break;
            case 4:  imp(Emp); break;
            case 5: menu2(Emp); break;
            default:
                System.out.println("\n\nNumero invalido\n\n");
                 menu(Emp); 
                 break;
          }
          System.out.println("Presione cualquer tecla para continuar...");
          new Scanner(System.in).nextLine();
          menu(Emp);
     }
     //ACTUALIZAR DATOS
     public static void menu2(ArrayList <Eman> Emp){        
         System.out.print("\tMenu Actualizar\n"
                 + "===Opciones==\n"
                 + "0 = Salir de menu actualizar\n"
                 + "1 = Cambiar Nombre\n"
                 + "2 = Cambiar Apellido.\n"
                 + "3 = Cambiar Edad.\n"
                 + "4 = Cambiar Sueldo.\n"
                 + "5 = Imprimir lista de empleados.\n R = "); 
         d = in.nextInt();
         if(d!=5 && d!=0) { System.out.print("\nNumero de empleado a modificar: "); 
         s=in.nextInt(); }
         switch(d){
             case 0: 
                 menu(Emp); break;
             case 1:
                 d = s-1;
                 System.out.print("\nNombre nuevo: ");   m=in.next();
                 E = Emp.get(d);
                 E.setN(m);
                 Emp.set(d, E);  break;
             case 2: 
                 d = s-1;
                 System.out.print("\nApellido nuevo: ");   m=in.next();
                 E = Emp.get(d);
                 E.setA(m);
                 Emp.set(d, E);  break;
             case 3: 
                 d = s-1;
                 System.out.print("\nEdad nuevo: ");   s=in.nextInt();
                 E = Emp.get(d);
                 E.setE(s);
                 Emp.set(d, E);   break;
             case 4: 
                 double r;
                 d = s-1;
                 System.out.print("\nSueldo nuevo: ");   r=in.nextDouble();
                 E = Emp.get(d);
                 E.setC(r);
                 Emp.set(d, E);  break;
             case 5:  imp(Emp); break;
             default:
                 System.out.println("\n\nNumero invalido\n\n");
                 menu2(Emp); 
                 break;
         }
         System.out.println("Presione cualquer tecla para continuar...");
         new Scanner(System.in).nextLine();
         menu2(Emp);
     }
     
     
     

}

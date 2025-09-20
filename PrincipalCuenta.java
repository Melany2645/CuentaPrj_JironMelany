import java.util.Scanner;
import java.util.ArrayList;

public class PrincipalCuenta{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<Cuenta> cuentas = new ArrayList<>();
    Cuenta cuentaActual = null;
    int opcion;
    
    do{
      System.out.println("\nMenú principal");
      System.out.println("1) Crear Cuenta");
      System.out.println("2) Conocer la cantidad de Cuentas Creadas");
      System.out.println("3) Listar Cuentas");
      System.out.println("4) Seleccionar Cuenta actual");
      System.out.println("5) Depositar");
      System.out.println("6) Retirar");
      System.out.println("7) Consultar Saldo");
      System.out.println("8) Consultar Estado (toString)");
      System.out.println("0) Salir");
      System.out.print("Seleccione una opción: ");
      opcion = sc.nextInt();
      
      switch(opcion) {
        case 1:
          System.out.println("Crear cuenta:");
          System.out.print("1) Con saldo inicial | 2) Con nombre y saldo: ");
          int tipo = sc.nextInt(); //Pedimos el dato
          if (tipo == 1) {
            System.out.print("Ingrese saldo inicial: ");
            double saldo = sc.nextDouble();
            Cuenta c = new Cuenta(saldo);
            sc.nextLine(); // limpiamos la variable
            System.out.print("Ingrese nombre del cuentaHabiente: ");
            String nombre = sc.nextLine();//De igual forma guardamos el dato
            c.setNombreCuentaHabiente(nombre);//Llamanos los metodos de la clase, intancia
            cuentas.add(c);//Concatenamos a al arreglo de listas que creamos
            System.out.println("Cuenta creada: " + c.toString());
          } else {
            sc.nextLine();
            System.out.print("Ingrese nombre del cuentaHabiente: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese saldo inicial: ");
            double saldo = sc.nextDouble();
            Cuenta c = new Cuenta(nombre, saldo);
            cuentas.add(c);
            System.out.println("Cuenta creada: " + c.toString());
          }
          break;

        case 2:
          System.out.println("Total cuentas creadas: " + Cuenta.getContador());
          break;
          
        case 3:
          for (Cuenta c : cuentas) { //Recorremos el arreglo e impriminos la información de las cuentas
          System.out.println(c.toString());
          }
          break;

        case 4:
          sc.nextLine();
          System.out.print("Ingrese código de cuenta (ej: cta-1): ");
          String codigo = sc.nextLine();
          cuentaActual = null;//Variable de almacenamiento
          for (Cuenta c : cuentas) {
            if (c.getCodCuenta().equals(codigo)) {
              cuentaActual = c;
              break;
            }
          }
          if (cuentaActual != null) {
            System.out.println("Cuenta seleccionada: " + cuentaActual.toString());
          } else {
            System.out.println("Cuenta no encontrada.");
          }
          break;

        case 5:
          if (cuentaActual != null) {
            System.out.print("Ingrese monto a depositar: ");
            double monto = sc.nextDouble();
            System.out.println("Saldo después del depósito: " + cuentaActual.depositar(monto));
          } else {
            System.out.println("Debe seleccionar una cuenta primero.");
          }
          break;

        case 6:
          if (cuentaActual != null) {
            System.out.print("Ingrese monto a retirar: ");
            double monto = sc.nextDouble();
            System.out.println("Saldo después del retiro: " + cuentaActual.retirar(monto));
          } else {
            System.out.println("Debe seleccionar una cuenta primero.");
          }
          break;

        case 7:
          if (cuentaActual != null) {
            System.out.println("Saldo actual: " + cuentaActual.getSaldo());
          } else {
            System.out.println("Debe seleccionar una cuenta primero.");
          }
          break;

        case 8:
          if (cuentaActual != null) {
            System.out.println(cuentaActual.toString());
          } else {
            System.out.println("Debe seleccionar una cuenta primero.");
          }
          break;
            }
    } while(opcion != 0);
    
    sc.close();
  }
}
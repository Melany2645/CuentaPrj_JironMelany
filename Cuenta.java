import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta
{
  private String codCuenta = "cta-";
  private double saldo;
  private String nombreCuentaHabiente;
  private String fechaCreacion;
  private int cantDepositosRealizados;
  private int cantRetirosExitososRealizados;
  private static int cantCuentasCreadas = 0;
    
  //Método constructor con dos paramétro
  public Cuenta(String nombreCuentaHabiente, double pSaldo){
      this.nombreCuentaHabiente = nombreCuentaHabiente;
      this.saldo = pSaldo;
      cantCuentasCreadas ++;
      codCuenta = codCuenta + cantCuentasCreadas;
      
      Date fecha = new Date(System.currentTimeMillis());
      DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      fechaCreacion = formato.format(fecha);
  }
    
  //Metódo constructor con un paramétro
  public Cuenta(double saldo){
      cantCuentasCreadas ++;
      codCuenta = codCuenta + cantCuentasCreadas;
      this.saldo = saldo;
      nombreCuentaHabiente = "Pendiente";
      
      Date fecha = new Date(System.currentTimeMillis());
      DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      fechaCreacion = formato.format(fecha);
  }
    
  //Metódo para depositar dinero
  public double depositar(double monto){
      if(monto > 0){
        saldo +=monto;
        cantDepositosRealizados ++;
      }
      return saldo;
  }
  
  //Metódo para retirar dinero
  public double retirar(double monto){
     if(saldo < monto || saldo <= 0){
       return saldo;
     } else {
       saldo -= monto; 
       cantRetirosExitososRealizados++;
       return saldo;
     }
  }
  
  //Metódo de la clase
  public static int getCantCuentasCreadas(){     
     return cantCuentasCreadas;
  }
  
  //Mostramos la información del objeto
  public String toString(){
    return "Código de cuenta: " + codCuenta +
           " | Nombre: " + nombreCuentaHabiente +
           " | Saldo " + saldo +
           " | Fecha creación: " + fechaCreacion +
           " | Depósitos: " + cantDepositosRealizados +
           " | Retiros: " + cantRetirosExitososRealizados;
  }
  
  //nombreCuentaHabiente
  public void setNombreCuentaHabiente(String nombreCuentaHabiente) {
      this.nombreCuentaHabiente = nombreCuentaHabiente;
  }

  //Conseguir para saldo
  public double getSaldo() {
      return saldo;
  }

  //Conseguir la cuenta codCuenta (útil en selección de cuentas)
  public String getCodCuenta() {
      return codCuenta;
  }
}

/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */

public class EstructurasDecision {

    public static void main(String[] args) {

        boolean cond1 = true, cond2 = false, cond3, cond4;
        int mesAño = 0;

        if (cond1) {
            cond3 = true;
        } else {
            cond3 = false;
        }

        //resumiendo codigo//
        //cond3 = cond1 ? true : false;
        
        if (cond2) {
            cond4 = true;
        } else {
            cond4 = false;
        }

        //resumiendo codigo//
        //cond4 = cond2 ? true : false;
        
        switch(mesAño){
            case 1:{
                //sentencia para el mes 1
                
                break;
            }
            
            case 2:{
                //sentencia para el mes 2
                
                break;
            }
            
            //posteriores case....
            
            default:{
                //sentencia en caso de que no se recoja el valor en los case
            }
        }
    }

}

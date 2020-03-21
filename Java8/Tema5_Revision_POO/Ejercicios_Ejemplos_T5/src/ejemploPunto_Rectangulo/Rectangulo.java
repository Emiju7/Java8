package ejemploPunto_Rectangulo;
/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */

public class Rectangulo {

    Punto pNE, pNO, pSE, pSO;

    public Rectangulo(Punto pNE, Punto pSO) {
        this.pSE = new Punto();
        this.pSO = new Punto(pSO);
        this.pNE = new Punto(pNE);
        this.pNO = new Punto();
        this.completarRectangulo();
    }

    private void completarRectangulo() {
        this.pNO.setX(this.pSO.getX());
        this.pNO.setY(this.pNE.getY());

        this.pSE.setX(this.pNE.getX());
        this.pSE.setY(this.pSO.getY());
    }

    public Punto getpNE() {
        return pNE;
    }

    public Punto getpNO() {
        return pNO;
    }

    public Punto getpSE() {
        return pSE;
    }

    public Punto getpSO() {
        return pSO;
    }

    @Override
    public String toString() {
        return "Punto NE:\n " + this.pNE.toString()
                + "\nPunto NO:\n " + this.pNO.toString()
                + "\nPunto SE:\n " + this.pSE.toString()
                + "\nPunto SO:\n " + this.pSO.toString();
    }

}

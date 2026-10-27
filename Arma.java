/**
 * Arma que cualquier criatura puede equiparse.
 * Aumenta el daño de los ataques de quien la porta.
 */
public class Arma {

    private String nombre;
    private int bonoDaño; // daño extra que suma al ataque

    /**
     * @param nombre   nombre del arma (ej: "Bastón de fuego")
     * @param bonoDaño daño adicional que aporta al atacar
     */
    public Arma(String nombre, int bonoDaño) {
        this.nombre = nombre;
        this.bonoDaño = bonoDaño;
    }

    public String getNombre() {
        return nombre;
    }

    public int getBonoDaño() {
        return bonoDaño;
    }
}

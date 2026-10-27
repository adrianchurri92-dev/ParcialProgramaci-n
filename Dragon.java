/**
 * Dragón: ataca con el doble de su fuerza y se defiende con sus escamas,
 * que absorben el 20% del daño recibido.
 */
public class Dragon extends Criatura {

    private String escamas; // tipo de escamas del dragón

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    /** El dragón ataca con fuerza * 2 (+ bono del arma si tiene). */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2 + getBonoArma(); // el arma suma su bono
        String conArma = tieneArma() ? " usando " + getArmaEquipada().getNombre() : "";
        System.out.println(getNombre() + " lanza un ataque de fuego y garra" + conArma
                + " con daño " + daño);
        objetivo.defender(daño);
    }

    /** Las escamas absorben el 20% del daño; siempre recibe al menos 1. */
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño - (daño * 20 / 100));
        System.out.println("   " + getNombre() + " se protege con sus escamas de " + escamas
                + " y recibe " + dañoReal + " de daño");
        recibirDaño(dañoReal);
    }
}

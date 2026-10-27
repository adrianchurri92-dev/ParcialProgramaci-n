/**
 * Clase principal: crea las criaturas y simula batallas entre ellas.
 */
public class Main {

    /**
     * Simula una batalla por turnos entre dos criaturas hasta que una muera.
     * Usa polimorfismo: solo conoce el tipo Criatura, no las subclases.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("=== BATALLA: " + criatura1.getNombre() + " vs "
                + criatura2.getNombre() + " ===");

        int turno = 1;
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("--- Turno " + turno + " ---");

            // Ataca la criatura 1
            criatura1.atacar(criatura2);
            mostrarSalud(criatura1, criatura2);

            // Si la criatura 2 sigue viva, contraataca
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
                mostrarSalud(criatura1, criatura2);
            }
            turno++;
        }

        // Resultado final
        Criatura ganador = criatura1.estaViva() ? criatura1 : criatura2;
        Criatura perdedor = criatura1.estaViva() ? criatura2 : criatura1;
        System.out.println(">>> " + perdedor.getNombre() + " ha muerto. ¡Gana "
                + ganador.getNombre() + " con " + ganador.getSalud() + " de salud!\n");
    }

    /** Muestra la salud actual de ambas criaturas. */
    private static void mostrarSalud(Criatura c1, Criatura c2) {
        System.out.println("   [Salud] " + c1.getNombre() + ": " + c1.getSalud()
                + " | " + c2.getNombre() + ": " + c2.getSalud());
    }

    public static void main(String[] args) {
        // Se crean criaturas distintas (se guardan como tipo Criatura)
        Criatura dragon = new Dragon("Smaug", 150, 20, "obsidiana");
        Criatura mago = new Mago("Merlín", 100, 25, "Bola de Fuego");
        Criatura guerrero = new Guerrero("Conan", 120, 18, "espada");

        // Se simulan varias batallas (se recrean las criaturas para tener salud completa)
        simularBatalla(dragon, mago);

        // Funcionalidad de armas: cualquier criatura puede equiparse una
        Criatura gandalf = new Mago("Gandalf", 100, 25, "Rayo Arcano");
        gandalf.equiparArma(new Arma("Bastón de fuego", 8));
        guerrero.equiparArma(new Arma("Hacha rúnica", 5));
        simularBatalla(gandalf, guerrero);
        simularBatalla(new Dragon("Drogon", 150, 20, "negras"),
                new Guerrero("Aragorn", 120, 18, "espada"));
    }
}

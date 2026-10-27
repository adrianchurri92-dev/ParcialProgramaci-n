# Parcial Programacion
Simulador de batallas por turnos entre criaturas, desarrollado en Java como parte del Parcial II – Programación II . El proyecto aplica clases abstractas y polimorfismo: cada criatura tiene su propia forma de atacar y defenderse, pero la batalla las trata a todas de manera genérica.

# Integrantes
Jhonatan Andres Morales Trochez
Adrian Andrade Ramirez

# Objetivos del ejercicio
Definir una clase abstracta Criatura con métodos abstractos.
Implementar al menos tres subclases concretas con comportamientos únicos.
Simular una batalla hasta que una de las criaturas muera.
Usar polimorfismo: la simulación solo conoce el tipo Criatura.
Trabajar en pareja con ramas, commits por integrante y merge requests aprobados.

# Diagrama de UML

classDiagram
    class Main {
        +simularBatalla(Criatura criatura1, Criatura criatura2)
    }
    class Criatura {
        <<abstract>>
        -String nombre
        -int salud
        -int fuerza
        +atacar(Criatura objetivo)
        +defender(int daño)
        +estaViva() boolean
    }
    class Dragon {
        -String escamas
    }
    class Mago {
        -String hechizos
    }
    class Guerrero {
        -String arma
    }

    Main --> Criatura : Utiliza
    Criatura <|-- Dragon
    Criatura <|-- Mago
    Criatura <|-- Guerrero

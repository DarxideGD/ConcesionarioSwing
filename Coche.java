public class Coche {
    String color;
    String marca;
    int km;

    public static void main(String[] args) {
        Coche miCoche = new Coche();
        miCoche.color = "Rojo";
        miCoche.marca = "Toyota";
        miCoche.km = 50000;

        System.out.println("Mi coche es un " + miCoche.marca + " de color " + miCoche.color + " con " + miCoche.km + " km.");
    }
}

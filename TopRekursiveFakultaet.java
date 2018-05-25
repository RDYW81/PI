
/**
 * Beschreiben Sie hier die Klasse TopFakultaet.
 * 
 * @author Roland Daidone, Michael Linn 
 * @version 1.0
 */

public class TopRekursiveFakultaet {
    /**
     * Rekursiver Aufruf, die Fakultät einer Zahl innerhalb eines Lambda-Ausdrucks zu berechnen
     * wurde ausgegraut. Stattdessen findet der Aufruf als Objekt Methoden-Referenz statt.
     * Beispiel: 5!
     */
    /*
    public static MyFunction fakultaet = (int x) -> {
    return (x == 0) ? 1 : x * TopRekursiveFakultaet.fakultaet.apply(x - 1);
    }; */

    public int apply(int x) {
        return (x == 0) ? 1 : x * this.apply(x - 1);        
    }

    public static void main( String[] args ) {
        new Mathefunktion().start();
    }
    
    public static void start() {
        TopRekursiveFakultaet top = new TopRekursiveFakultaet();
        
        Mathefunktion.applyAndPrint(top::apply, 1, 5); // Ergebnis: 120
    }
}
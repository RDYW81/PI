import java.util.function.IntPredicate;
/**
 * Beschreiben Sie hier die Klasse Mathefunktion.
 * 
 * @author Roland Daidone, Michael Linn
 * @version 1.0
 */
public class Mathefunktion {  

    //Instanzvariablen
    private int NULL = 0;
    MyFunction quadrat = x -> x*x;
    MyFunction fakultaet = (int x) -> {
            int ergebnis = 1;
            for(int in = 2 ; in <= x; in++){
                ergebnis = ergebnis * in;
            }
            return ergebnis;
        };

    //Initialisierung der Main-Methode
    public static void main(String args[]) {
        new Mathefunktion().start();
    }

    //Aufgabe 1a
    /**
     * Methode applyAndPrint nimmt zwei natürliche Zahlen i und j und eine Funktion myFunction entgegen und wiederholt
     * nachfolgende Berechnungsmethoden in den Aufgaben 1b mit allen Zahlen von den Grenzen i und j.
     * 
     * @param myFunction - Funktion wird wiedergegeben
     * @param i - natürliche Zahl i wird wiedergegeben
     * @param j - natürliche Zahl j wird wiedergegeben
     * 
     * @return - Berechnung aus entsprechender, anonymer Klasse der Aufgabe 1b
     */
    public static void applyAndPrint(final MyFunction myFunction, final int i, final int j) {
        final int beginn = Math.min(i, j);
        final int ende   = Math.max(i, j);
        for (int zahl = beginn; zahl <= ende; zahl++) {
            System.out.println (myFunction.apply(zahl));
        }
    }

    //Aufgabe 1b
    /**
     * Berechnung der quadratischen Potenzzahlen der Eingabeparameter i bis j mittels eines Lambda-Ausdrucks
     * Beispiel: x * x
     * 
     * @return x^2
     */
    public void anonymeKlasseQuadrat(final int i, final int j) {
        if (i < 0 || j < 0)
            throw new RuntimeException ("Etwas eingeben");

        Quadrat quadrat = new Quadrat() {
                public void berechneQuadrat() {
                    MyFunction quadrat = (int x) -> {
                            return x*x; 
                        };
                    applyAndPrint(quadrat, i, j);
                }     
            }; 
        quadrat.berechneQuadrat();    
    }

    /**
     * Berechnung der Fakultät in Form eines Lambda-Ausdrucks
     * Beispiel: x! = 1 * 2 * 3 ... * x
     * 
     * @return x!
     */

    public void anonymeKlasseFakultaet(final int i, final int j) {
        if (i < 0 || j < 0)
            throw new RuntimeException ("Etwas eingeben");

        Fakultaet fakultaet = new Fakultaet() {
                public void berechneFakultaet() {
                    MyFunction fakultaet = (int x) -> {
                            int res = 1;
                            for(int in = 2 ; in <= x; in++) {
                                res = res * in;
                            }
                            return res;
                        }; 
                    applyAndPrint(fakultaet, i, j);
                }
            };
        fakultaet.berechneFakultaet();
    }

    /**
     * Berechnung der Funktion x^(x+1) in Form eines Lambda-Ausdrucks
     * Beispiel: 1^2, 2^3, 3^4, 4^5, 5^6, 6^7,...
     * 
     * @return 1, 8, 81, 1024, 15625, 279936,...
     */

    public void anonymeKlasseXPlusXHochEins(final int i, final int j) {
        if (i < 0 || j < 0)
            throw new RuntimeException ("Etwas eingeben");

        XHochXPlusEins xhochxpluseins = new XHochXPlusEins() {
                public void berechneXHochXPlusEins() {
                    MyFunction xhochxpluseins = (int x) -> {
                            return (int) (Math.pow(x, x+1)); 
                        };
                    applyAndPrint(xhochxpluseins, i, j);
                }
            };
        xhochxpluseins.berechneXHochXPlusEins();   
    }    

    /**
     * Berechnung die Zahlenfolge nach Fibonacci in Form eines Lambda-Ausdrucks
     * Beispiel: 0+1=1; 1+1=2; 1+2=3; 2+3=5; 3+5=8; 5+8=13; 8+13=21;...
     * 
     * @return 1, 1, 2, 3, 5, 8, 13, 21,...
     */

    public void anonymeKlasseFibonacci(final int i, final int j) {
        if (i < 0 || j < 0)
            throw new RuntimeException ("Etwas eingeben");

        Fibonacci fibonacci = new Fibonacci() {
                public void berechneFibonacci() {
                    MyFunction fibonacci = (int x) -> {
                            if(x <= 1) 
                                return x;

                            int ergebnis = 1;
                            int prevFib  = 1;
                            for(int in = 2; in < x; in++) {
                                int temp = ergebnis;
                                ergebnis = ergebnis + prevFib;
                                prevFib = temp;
                            }
                            return ergebnis;
                        };
                    applyAndPrint(fibonacci, i, j);
                }
            };
        fibonacci.berechneFibonacci();
    }

    /**
     * Berechnung der Fakultät in Form einer statischen Methoden-Referenz als Static Nested Class
     * Beispiel: x! = 1 * 2 * 3 ... * x
     * 
     * @return x!
     */
    static class StaticNestedFakultaetClass {
        private static int apply(int x) {
            int res = 1;
            for (int in = 2; in <= x; in++) {
                res = res * in;
            }
            return res;
        }

        public void staticNestedFakultaet(final int i, final int j) {
            if (i < 0 || j < 0)
                throw new RuntimeException ("Etwas eingeben");

            MyFunction fakultaet = StaticNestedFakultaetClass::apply;
            applyAndPrint(fakultaet, i, j);
        }
    }

    // Aufgabe 1d
    /**
     * Methode zur Überprüfung, ob gegebenes Prädikat ungerade ist. Überprüfung erfolgt durch die 
     * gegebene anonyme Klasse IntPredicate odd, die Ausführung zu den Falkultaetsergebnissen über
     * den in der Methode gegebenen Lambda-Ausdruck der Aufgabe 1f.
     */
    public void odd() {
        int i = 0;  //Angabe der Zahlen zu Testzwecken
        int j = 5;  //Ergebnis: 1,1,0,0,0,0

        IntPredicate odd = new IntPredicate() {
                public boolean test(int i) {
                    return ((i % 2) == 01) ? true : false;
                }       
            };

        //Aufgabe 1f:
        MyConditionalFunction lambdaFakultaetNurUngeradeZahl = (int x) -> {
                if (odd.test(fakultaet.apply(x))) {
                    return fakultaet.apply(x);
                } else {
                    return 0;
                }
            };
        applyAndPrint(lambdaFakultaetNurUngeradeZahl, i, j);
    }

    /**
     * Lambda-Ausdruck zur Überprüfung, ob das gegebene Prädikat eine gerade Zahl ist.
     */
    IntPredicate even = (int i) -> {
            return ((i % 2) == 00) ? true : false;
        };

    //Aufgabe 1e
    /**
     * Ausführung, wenn die Zahl gerade ist, über den Lambda-Ausdruck in der Instanzvariablen,
     * da die eigentliche anonyme Klasse zur Berechnung von x*x nicht von außen erreibach ist.
     */
    MyConditionalFunction lambdaQuadratAusGeraderZahl = (int i) -> {
            if (even.test(i)) {
                return quadrat.apply(i);
            } else {
                return 0;
            }
        };

    //Aufgabe 2a
    /**
     * Methode iterate nimmt einen Startwert st entgegen und durchläuft mit 
     * n-Iterationsdurchläufen des Werts it die for-Schleife.
     * 
     * @param matheIterator - Iterator wird wiedergegeben
     * @param st - Startwert st wird wiedergegeben
     * @param it - Iterationszahl it wird wiedergegeben
     * 
     * @return - Berechnung aus entsprechender, anonymer Klasse der Aufgabe 2b
     * 
     */
    public static void iterate(final MatheIterator matheIterator, double st, final int it) {
        double neuerStartwert = 0;
        for (int i = 0+1; i <= it; i++) {
            neuerStartwert = matheIterator.apply(st);
            System.out.println(matheIterator.apply(st));
            st = neuerStartwert;
        }
    }

    //Aufgabe 2b
    /**
     * Berechnung der Formel 2x mit x als double Startwert und definierter Angabe an n-Iterationsdurchläufen
     * durch die Methode iterate. 
     * Beispiel: 2 * 1 = 2; 2 * 2 = 4; 2 * 4 = 8; 2 * 8 = 16; 2 * 16 = 32; ...
     * 
     * @return 2, 4, 8, 16, 32,...
     */

    public void zweiX(double st, final int it) {
        if (st < 0 || it < 0)
            throw new RuntimeException ("Etwas eingeben");

        ZweiX zweiX = new ZweiX() {
                public void berechneZweiX() {
                    MatheIterator zweiX = (double x) -> {
                            return 2*x;
                        }; 
                    iterate(zweiX, st, it);
                }
            };
        zweiX.berechneZweiX();
    }

    /**
     * Berechnung der Formel 0.5x mit x als double Startwert und definierter Angabe an n-Iterationsdurchläufen
     * durch die Methode iterate. 
     * Beispiel: 0.5 * 1 = 0.5; 0.5 * 0.5 = 0.25; 0.5 * 0.25 = 0.125; ...
     * 
     * @return 0.5, 0.25, 0.125, 0.0625, 0.03125,...
     */

    public void halbX(double st, final int it) {
        if (st < 0 || it < 0)
            throw new RuntimeException ("Etwas eingeben");

        HalbX halbX = new HalbX() {
                public void berechneHalbX() {
                    MatheIterator halbX = (double x) -> {
                            return 2*x;
                        }; 
                    iterate(halbX, st, it);
                }
            };
        halbX.berechneHalbX();
    }

    /**
     * Berechnung der Formel a*x*(x-1), für ein gegebenes a Element von ( 0 , 1 ), x als double Startwert 
     * und definierter Angabe an n-Iterationsdurchläufen durch die Methode iterate. 
     * Beispiel: 0*1*(1-1)
     * 
     * @return 0
     */

    public void aXMalXMinusEins(double st, final int it) {
        if (st < 0 || it < 0)
            throw new RuntimeException ("Etwas eingeben");

        AxX aXX = new AxX() {
                public void berechneAXX() {
                    double a = 0.0;
                    MatheIterator aXX = (double x) -> {
                            return a*x*(x-1);
                        }; 
                    iterate(aXX, st, it);
                }
            };
        aXX.berechneAXX();
    }

    /**
     * Main-Methode mit verschiedenen Test-Szenarien je nach Aufgabenstellung
     */
    public void start() {
        Mathefunktion mathe = new Mathefunktion();
        // Testzahlen für Aufgabe 1:
        int i       = 2;
        int j       = 5;
        // Testzahlen für Aufgabe 2
        double st   = 2.0;
        int it      = 5;
        int a       = NULL;
        double aa   = 0.5;
        int aaa     = 1;

        // Funktion: x*x
        MyFunction quadrat          = (int x) -> {
                return x*x;
            };
        System.out.println("Ausgabe der Quadratzahlen:");
        applyAndPrint(quadrat, i, j);

        // Funktion: x!
        MyFunction fakultaet        = (int x) -> {
                int ergebnis = 1;
                for(int in = 2 ; in <= x; in++){
                    ergebnis = ergebnis * in;
                }
                return ergebnis;
            }; 
        System.out.println("Ausgabe der Fakultätszahlen:");
        applyAndPrint(fakultaet, i, j);

        // Funktion: x^(x+1)
        MyFunction xhochxpluseins   = (int x) -> {
                return (int) (Math.pow(x, x+1)); 
            };
        System.out.println("Ausgabe der Zahlen nach x^(x+1):");
        applyAndPrint(xhochxpluseins, i, j);

        // Funktion: Fibonacci-Zahlen
        MyFunction fibonacci        = (int x) -> {
                if(x <= 1) 
                    return x;

                int ergebnis = 1;
                int prevFib  = 1;
                for(int in = 2; in < x; in++) {
                    int temp = ergebnis;
                    ergebnis = ergebnis + prevFib;
                    prevFib = temp;
                }
                return ergebnis;
            };
        System.out.println("Ausgabe der Zahlen nach Fibonacci:");
        applyAndPrint(fibonacci, i, j);

        // Tests der Aufgaben 1e und 1f
        System.out.println("Ausgabe quadratischer Zahlen mit even, sonst 0:");
        mathe.applyAndPrint(mathe.lambdaQuadratAusGeraderZahl, i, j);

        System.out.println("Ausgabe ungerader Fakultätszahlen mit odd, sonst 0:");
        mathe.odd();

        System.out.println("Ausgabe der Fakultätszahlen in der Static Nested Class:");
        StaticNestedFakultaetClass nested = new StaticNestedFakultaetClass();
        nested.staticNestedFakultaet(i, j);

        // Funktion: 2*x
        MatheIterator zweiX             = (double x) -> {
                return 2*x;
            };
        System.out.println("Ausgabe (iteriert) für 2*x:");
        iterate(zweiX, st, it);

        // Funktion: 0.5*x
        MatheIterator halbX             = (double x) -> {
                return 0.5*x;
            };
        System.out.println("Ausgabe (iteriert) für 0.5*x:");
        iterate(halbX, st, it);

        // Funktion: a*x*(x-1):
        MatheIterator aXXMitA   = (double x) -> {
                return a*x*(x-1);
            };
        System.out.println("Ausgabe a = 0.0 (iteriert) für a*x*(x-1):");
        iterate(aXXMitA, st, it);

        // Funktion: a*x*(x-1):
        MatheIterator aXXMitAA   = (double x) -> {
                return aa*x*(x-1);
            };
        System.out.println("Ausgabe a = 0.5 (iteriert) für a*x*(x-1):");
        iterate(aXXMitAA, st, it);

        // Funktion: a*x*(x-1):
        MatheIterator aXXMitAAA   = (double x) -> {
                return aaa*x*(x-1);
            };
        System.out.println("Ausgabe a = 1.0 (iteriert) für a*x*(x-1):");
        iterate(aXXMitAAA, st, it);

    }
}
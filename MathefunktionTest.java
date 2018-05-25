

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse MathefunktionTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MathefunktionTest
{

    @Test
    public void testIteratorMitFunktionStartwertIterationszahl()
    {
        Mathefunktion.iterate(x -> 2*x, 2.0, 8);
    }

    @Test
    public void testApplyAndPrintMitFunktionUndNatuerlichenZahlenIJ()
    {
        Mathefunktion.applyAndPrint(x -> x*x, 2, 10);
    }

    }







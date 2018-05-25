

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse MathefunktionTest.
 *
 * @author Roland Daidone, Michael Linn
 * @version 1.0
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







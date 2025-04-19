package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Operatii;
import model.Polinom;


import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testAdunare()
    {   Polinom p1= new Polinom("4x^2+3x+4");
        Polinom p2= new Polinom("-x^2+2x");
        Polinom rezultat=new Polinom();
        rezultat= Operatii.adunaPolinoame(p1,p2);
        String rezultatString=rezultat.toString();

        assertEquals( "4+5x+3x^2", rezultatString );
    }
    public void testScadere()
    {   Polinom p1= new Polinom("4x^2+3x+4");
        Polinom p2= new Polinom("-x^2+2x");
        Polinom rezultat=new Polinom();
        rezultat= Operatii.scadePolinoame(p1,p2);
        String rezultatString=rezultat.toString();

        assertEquals( "4+x+5x^2", rezultatString );
    }

    public void testDerivare()
    {   Polinom p1= new Polinom("4x^2+3x+4");
        Polinom rezultat=new Polinom();
        rezultat= Operatii.deriveazaPolinom(p1);
        String rezultatString=rezultat.toString();

        assertEquals( "3+8x", rezultatString );
    }

    public void testIntegrare()
    {   Polinom p1= new Polinom("4x^2+4");
        Polinom rezultat=new Polinom();
        rezultat= Operatii.integreazaPolinom(p1);
        String rezultatString=rezultat.toString();

        assertEquals( "4x+1.33x^3", rezultatString );
    }

    public void testInmultire()
    {   Polinom p1= new Polinom("2x+2");
        Polinom p2= new Polinom("2x+1");
        Polinom rezultat=new Polinom();
        rezultat= Operatii.inmultestePolinoame(p1,p2);
        String rezultatString=rezultat.toString();

        assertEquals( "2+6x+4x^2", rezultatString );
    }
    public void testImmpartire()
    {   Polinom p1= new Polinom("x^3+x+1");
        Polinom p2= new Polinom("x-1");
        List<Polinom> rezultat=new ArrayList<>();
        rezultat= Operatii.impartePolinoame(p1,p2);
        String rezultatCat=rezultat.get(0).toString();
        String rezultatRest=rezultat.get(1).toString();

        assertEquals( "2+x+x^2", rezultatCat );
        assertEquals( "3", rezultatRest );
    }
}

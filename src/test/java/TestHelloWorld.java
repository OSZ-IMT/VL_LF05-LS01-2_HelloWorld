
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TestHelloWorld {

    private PrintStream originalOut;
    private ByteArrayOutputStream bos;

    @Before
    public void InitPrintStream(){
        //bind the system
        originalOut = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    @After
    public void EndPrintStream(){
        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testStrukturierteProgrammierung()
    {

        // action
        HelloWorld.main(null);

        // assertion
        assertTrue(bos.toString().contains("Willkommen in der Veranstaltung \"Strukturierte Programmierung\"."));

    }

    @Test
    public void testNotFirstName()
    {

        // action
        HelloWorld.main(null);

        // assertion
        assertFalse(bos.toString().contains("Ihr Vorname"));

    }

    @Test
    public void testNotBrackets()
    {

        // action
        HelloWorld.main(null);

        // assertion
        assertFalse(bos.toString().contains("<"));
        assertFalse(bos.toString().contains(">"));

    }
}

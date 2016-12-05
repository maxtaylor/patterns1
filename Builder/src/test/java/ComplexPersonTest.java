import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 05/12/16.
 */
public class ComplexPersonTest {

    private static final Logger log = Logger.getLogger(ComplexPersonTest.class);

    private final String title = "Mr",
            name        = "James",
            middename   = "Andrew",
            surname     = "Bond",
            login       = "007",
            email       = "007@mi5.com",
            address     = "MI5";

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
    }

    @Test
    public void testEmptyPerson() {
        final ComplexPerson person = new ComplexPerson.Builder().build();
        log.info(String.format("Empty Person : %s", person));
        verify(person, null, null, null, null, null, null, null);
    }

    @Test
    public void testNonEmptyPerson() {
        final ComplexPerson person = new ComplexPerson.Builder()
                .name(name)
                .title(title)
                .surname(surname)
                .middlename(middename)
                .address(address)
                .email(email)
                .login(login)
                .build();
        log.info(String.format("Non empty Person : %s", person));
        verify(person, title, name, middename, surname, login, email, address);
    }


    @Test
    public void testMultiplePerson() {
        final ComplexPerson person = new ComplexPerson.Builder()
                .name(name)
                .title(title)
                .surname(surname)
                .middlename(middename)
                .address(address)
                .email(email)
                .login(login)
                .build();
        final ComplexPerson emptyPerson = new ComplexPerson.Builder().build();

        log.info(String.format("Non empty Person : %s", person));
        log.info(String.format("Empty Person : %s", emptyPerson));

        verify(person, title, name, middename, surname, login, email, address);
        verify(emptyPerson, null, null, null, null, null, null, null);
    }

    private void verify(ComplexPerson person, String title, String name, String middlename, String surname, String login, String email, String address) {
        assertEquals(title, person.getTitle());
        assertEquals(name, person.getName());
        assertEquals(middlename, person.getMiddlename());
        assertEquals(surname, person.getSurname());
        assertEquals(login, person.getLogin());
        assertEquals(email, person.getEmail());
        assertEquals(address, person.getAddress());
    }
}
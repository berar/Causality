package causality;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.berar.causality.Causation;
import io.berar.causality.exception.UnrecognizedMatcher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleks_000 on 1/8/2016.
 */
public class TestCausation {

    @Test
    @SuppressWarnings("unchecked")
    public void test01() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/01.json"), Causation.class);
        causation.put("a", 0.005);
        causation.put("b", "test");
        assertEquals(causation.getEffect(), "Test");
    }

    @Test(expected = UnrecognizedMatcher.class)
    @SuppressWarnings("unchecked")
    public void test02() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/02.json"), Causation.class);
        causation.put("a", 0.005);
        causation.put("b", "test");
        causation.getEffect();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCustomClass() {
        Causation<Person> c = Causation.create(TestCausation.class.getResourceAsStream("/custom-class.json"), Person.class);
        c.put("a", 0.005);
        c.put("b", "test");
        assertEquals(new Person("A", 1), c.getEffect());
    }

    @Test(expected = ClassCastException.class)
    @SuppressWarnings("unchecked")
    public void test03() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/03.json"), Causation.class);
        causation.put("a", "as");
        causation.put("b", "test");
        causation.getEffect();
    }

    @Test(expected = ClassCastException.class)
    @SuppressWarnings("unchecked")
    public void test04() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/04.json"), Causation.class);
        causation.put("a", 0.05);
        causation.put("b", 0.5);
        causation.getEffect();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test05IntToNumerical() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/05.json"), Causation.class);
        causation.put("a", 0.05);
        causation.put("b", "test");
        assertEquals("Test2", causation.getEffect());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test06() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/06.json"), Causation.class);
        causation.put("a", 0.05);
        causation.put("b", "test");
        assertEquals("test", causation.getEffect());
    }

    @Test(expected = JsonMappingException.class)
    @SuppressWarnings("unchecked")
    public void test07() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/07.json"), Causation.class);
        causation.put("a", 0.05);
        causation.put("b", "test");
        causation.getEffect();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test08() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/08.json"), Causation.class);
        causation.put("a", 0.05);
        causation.put("b", "test");
        assertEquals("test", causation.getEffect());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test09() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/09.json"), Causation.class);
        causation.put("a", 0.9);
        causation.put("b", "tested");
        causation.put("c", "tester");
        assertEquals("Test2", causation.getEffect());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test010() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/10.json"), Causation.class);
        causation.put("a", 0.0);
        causation.put("b", "");
        causation.put("c", "");
        assertEquals("Test2", causation.getEffect());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test11SuperClauseAnd() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/11.json"), Causation.class);
        causation.put("a", 0.0);
        causation.put("b", "");
        causation.put("c", "");
        assertEquals("Test2", causation.getEffect());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test12SuperClauseAnd() throws Exception {
        Causation<String> causation = new ObjectMapper().readValue(TestCausation.class.getResourceAsStream("/12.json"), Causation.class);
        causation.put("a", "");
        causation.put("b", "");
        causation.put("c", "");
        causation.put("d", "");
        assertEquals("test", causation.getEffect());
    }
}

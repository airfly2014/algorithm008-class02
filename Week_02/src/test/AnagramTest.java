package test;

import org.junit.Before;
import org.junit.Test;

import training.Anagram;

public class AnagramTest {


    private Anagram anagram;

    @Before
    public void setUp() throws Exception {
       anagram = new Anagram();
    }

    @Test
    public void isAnagram() {
        anagram.isAnagram("ddd","faf");
    }

    @Test
    public void isAnagram2() {
    }
}

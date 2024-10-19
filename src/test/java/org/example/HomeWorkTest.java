package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    public void testDecode() {
        Assertions.assertEquals("HELLO WORLD", homeWork.morseTranslator().decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
        Assertions.assertEquals("SOS", homeWork.morseTranslator().decode("... --- ..."));
        Assertions.assertEquals("EASY PEASY LEMON SQUEEZY", homeWork.morseTranslator().decode(". .- ... -.-- / .--. . .- ... -.-- / .-.. . -- --- -. / ... --.- ..- . . --.. -.--"));
    }

    @Test
    public void testEncode(){
        Assertions.assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", homeWork.morseTranslator().encode("HELLO WORLD"));
        Assertions.assertEquals("... --- ..." , homeWork.morseTranslator().encode("SOS"));
        Assertions.assertEquals(". .- ... -.-- / .--. . .- ... -.-- / .-.. . -- --- -. / ... --.- ..- . . --.. -.--", homeWork.morseTranslator().encode("EASY PEASY LEMON SQUEEZY"));

    }

}
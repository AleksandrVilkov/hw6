package org.example;

public class MorseTranslatorImpl implements MorseTranslator {

    private static final Character SPASE = ' ';
    private static final Character SLASH = '/';

    private final Morse morse = new Morse();


    @Override
    public String decode(String morseCode) {
        var stringBuilder = new StringBuilder();
        for (String word : morseCode.split(String.valueOf(SLASH))) {//Разделяем по словам
            for (String letter : word.split(String.valueOf(SPASE))) {  //Разделяем по буквам
                stringBuilder.append(morse.findCharByCode(letter));
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String encode(String source) {
        var letters = source.toCharArray(); //Разделяем по буквам
        var result = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == SPASE) { //Если проблел - добавляем разделитель слов
                result.append(SLASH);
                result.append(SPASE);
                continue;
            }
            result.append(morse.findCodeByChar(letters[i]));
            if (i != letters.length - 1) result.append(SPASE); //Если не конец строки - разделяем коды букв пробелом
        }
        return result.toString();
    }
}

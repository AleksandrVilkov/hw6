package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Morse {

    //Для decode - бинарное дерево
    private Node morseBinaryTree = new Node();

    //Для  encode - мапа
    private Map<Character, String> alphabet = new HashMap<>();

    public Morse() {
        //Заполняем поля класса
        addByCode('A', ".-");
        addByCode('B', "-...");
        addByCode('C', "-.-.");
        addByCode('D', "-..");
        addByCode('E', ".");
        addByCode('F', "..-.");
        addByCode('G', "--.");
        addByCode('H', "....");
        addByCode('I', "..");
        addByCode('J', ".---");
        addByCode('K', "-.-");
        addByCode('L', ".-..");
        addByCode('M', "--");
        addByCode('N', "-.");
        addByCode('O', "---");
        addByCode('P', ".--.");
        addByCode('Q', "--.-");
        addByCode('R', ".-.");
        addByCode('S', "...");
        addByCode('T', "-");
        addByCode('U', "..-");
        addByCode('V', "...-");
        addByCode('W', ".--");
        addByCode('X', "-..-");
        addByCode('Y', "-.--");
        addByCode('Z', "--..");

        //Заполняем мапу
        alphabet.put('A', ".-");
        alphabet.put('B', "-...");
        alphabet.put('C', "-.-.");
        alphabet.put('D', "-..");
        alphabet.put('E', ".");
        alphabet.put('F', "..-.");
        alphabet.put('G', "--.");
        alphabet.put('H', "....");
        alphabet.put('I', "..");
        alphabet.put('J', ".---");
        alphabet.put('K', "-.-");
        alphabet.put('L', ".-..");
        alphabet.put('M', "--");
        alphabet.put('N', "-.");
        alphabet.put('O', "---");
        alphabet.put('P', ".--.");
        alphabet.put('Q', "--.-");
        alphabet.put('R', ".-.");
        alphabet.put('S', "...");
        alphabet.put('T', "-");
        alphabet.put('U', "..-");
        alphabet.put('V', "...-");
        alphabet.put('W', ".--");
        alphabet.put('X', "-..-");
        alphabet.put('Y', "-.--");
        alphabet.put('Z', "--..");
    }

    //Метод поиска символа по коду морзе
    public Character findCharByCode(String code) {
        if ("".equals(code)) return ' ';
        var chars = code.toCharArray(); //Разбиваем код морзе на символы
        var node = morseBinaryTree; //Искомая нода. Изначально корневая
        //Если точка - идем влево, если тире - вправо
        for (char c : chars) {
            if (c == '.') {
                node = node.left;
            }
            if (c == '-') {
                node = node.right;
            }
        }
        //Когда прошли все символы кода морзе - в node искомаая нода. Отдаем ее значение
        return node.value;
    }

    //Метод поика кода морзе по символу
    public String findCodeByChar(Character character) {
        //Отдаем из мапы код по симоволу
        return alphabet.get(character);
    }

    //Метод добавления символа в бинарное дерево по коду морзе
    private void addByCode(Character value, String code) {
        var chars = code.toCharArray();
        var node = morseBinaryTree; //Искомая нода. Изначально корневая
        for (Character c : chars) {  //Перебираем все символы кода морзе
            if (c == '.') { //Если символ кода точка - идем влево
                if (node.left == null) node.left = new Node();
                node = node.left;
            } else if (c == '-') { //Если символ тире - идем вправо
                if (node.right == null) node.right = new Node();
                node = node.right;
            }
        }
        //Если дошли до конца кода морзе - то в node находится нужная нам нода. Сохраняем значение
        node.value = value;
    }
}

@Getter
@Setter
@NoArgsConstructor
class Node {
    Character value;
    Node left;
    Node right;
}

package com.ylluberes.hipernoba;


import java.util.Stack;

public class HipernobaApplication {


    /*
    Verificar si cadena está balanceada

        Casos validos
         ()
         {}
         []
         {}[]()
         ([]{}){}
         (([]))

        Casos invalidos
         [])(
         }{}
         (
         [({}])


     */


    //Valid usecase  (([
    //invalid usecase [])(

    private static boolean isValid(String input) {
		if(input.length() % 2 != 0) return false;
        Stack<Character> validator = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                validator.push(current);
            } else {
                char last = validator.pop();
                if (current == ')') {
                    if (last != '(') {
                        return false;
                    }
                } else if (current == ']') {
                    if (last != '[') {
                        return false;
                    }
                } else if (current == '}') {
                    if (last != '{') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String validTestCase = "(([]))";
        boolean result = isValid(validTestCase);
        System.out.println(result);

		String invalidUseCase = "[({}])";
		result = isValid(invalidUseCase);
		System.out.println(result);

		String edgeCase = "(";
		result = isValid(edgeCase);
		System.out.println(result);

		String last = "()(";
		result = isValid(last);
		System.out.println(result);
    }
}

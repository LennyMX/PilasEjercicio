public class PruebaMain {

    public static void main(String[] args) {

        PruebaMain prueba = new PruebaMain();
        Pila<String> pila = new Pila<>(5);

        pila.push("C");
        pila.push("z");
        pila.push("Y");
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        String cadena = "Czy";
        String invertido = prueba.invierteCadena(cadena);
        System.out.println("Invertido: " + invertido);

        String prueba1 = "{[()]}";
        String prueba2 = "{[(])}";
        String prueba3 = "{[()]]";

        System.out.println(prueba1 + " → " + prueba.revisarSintaxis(prueba1));
        System.out.println(prueba2 + " → " + prueba.revisarSintaxis(prueba2));
        System.out.println(prueba3 + " → " + prueba.revisarSintaxis(prueba3));

        int[] datos = {10, 2, 1, 20, 5};
        Pila<Integer> ordenada = prueba.ordenarConPila(datos);

        System.out.println("Pila ordenada:");
        while (!ordenada.pilaVacia()) {
            System.out.println(ordenada.pop());
        }
    }

    public String invierteCadena(String cadena) {
        Pila<Character> pila = new Pila<>(cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            pila.push(cadena.charAt(i));
        }
        String invertida = "";
        while (!pila.pilaVacia()) {
            invertida += pila.pop();
        }
        return invertida;
    }

    public boolean revisarSintaxis(String cadena) {
        Pila<Character> pila = new Pila<>(cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                pila.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (pila.pilaVacia()) {
                    return false;
                }
                char ultimo = pila.pop();
                if (!coinciden(ultimo, c)) {
                    return false;
                }
            }
        }
        return pila.pilaVacia();
    }
    private boolean coinciden(char apertura, char cierre) {
        if (apertura == '{' && cierre == '}') return true;
        if (apertura == '[' && cierre == ']') return true;
        if (apertura == '(' && cierre == ')') return true;
        return false;
    }

    public Pila<Integer> ordenarConPila(int[] vector) {
        Pila<Integer> pila = new Pila<>(vector.length);
        Pila<Integer> aux = new Pila<>(vector.length);
        for (int num : vector) {
            while (!aux.pilaVacia() && aux.peek() > num) {
                pila.push(aux.pop());
            }
            aux.push(num);
            while (!pila.pilaVacia()) {
                aux.push(pila.pop());
            }
        }
        return aux;
    }
}

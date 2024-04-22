package infos.util;

import java.util.Scanner;

public class TecladoUtil {

    public static String lerString(String mensagem) {
        return  inicializaTeclado(mensagem).next();

    }

    public static  Integer lerInteiro(String mensagem) {

        return  inicializaTeclado(mensagem).nextInt();

    }

    private static Scanner inicializaTeclado(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }
}

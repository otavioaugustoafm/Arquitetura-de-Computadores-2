import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Compilador {
    public static void main(String[] args) {
        
        try {

        BufferedReader arq = new BufferedReader(new FileReader("dados/dados.txt"));
        FileWriter saida = new FileWriter("dados/saida.txt");
        String linha, W = "", X = "", Y = "";
        int x = 0, y = 0;

        while((linha = arq.readLine()) != null) {
            if(linha.equals("inicio:")) {
                // Pula a primeira linha;
            } else if (linha.charAt(0) == 'X') {
                X = linha.split("=")[1].replace(";","");
            } else if (linha.charAt(0) == 'Y') {
                Y = linha.split("=")[1].replace(";","");
            } else if (linha.charAt(0) == 'W') {
                if(X == "" || Y == "") {
                    System.out.println("Erro, X ou Y não foram definidos antes da primeira operação.");
                } else {
                    W = linha.split("=")[1].replace(";","");
                    try {
                        if(X.matches("[0-9]+")) {
                            x = Integer.parseInt(X);
                            saida.write(Integer.toHexString(x).toUpperCase());
                        } else {
                            saida.write(X);
                        }
                        if(Y.matches("[0-9]+")) {
                            y = Integer.parseInt(Y);
                            saida.write(Integer.toHexString(y).toUpperCase());
                        } 
                        else {
                            saida.write(Y);
                        }
                        saida.write(ProcurarMnemonico(W) + "\n");
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (linha.equals("fim.")) {
                break;
            }
        }

        arq.close();
        saida.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String ProcurarMnemonico(String string) {
        if(string.equals("zeroL")) {
            return "0";
        } else if (string.equals("umL")) {
            return "1";
        } else if (string.equals("copiaA")) {
            return "2";
        } else if (string.equals("copiaB")) {
            return "3";
        } else if (string.equals("nA")) {
            return "4";
        } else if (string.equals("nB")) {
            return "5";
        } else if (string.equals("AenB")) {
            return "6";
        } else if (string.equals("nAeB")) {
            return "7";
        } else if (string.equals("AxB")) {
            return "8";
        } else if (string.equals("nAxnB")) {
            return "9";
        } else if (string.equals("nAxnBn")) {
            return "A";
        } else if (string.equals("AeB")) {
            return "B";
        } else if (string.equals("AeBn")) {
            return "C";
        } else if (string.equals("AoBn")) {
            return "D";
        } else if (string.equals("AoB")) {
            return "E";
        } else if (string.equals("nAonBn")) {
            return "F";
        } else {
            return "Erro";
        }
    }
}
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length - 1; i += 2) {
            arguments.put(args[i].substring(1), args[i + 1]);
        }

        String mode = arguments.containsKey("mode") ? arguments.get("mode") : "enc";
        String alg = arguments.containsKey("alg") ? arguments.get("alg") : "shift";
        int key = arguments.containsKey("key") ? Integer.parseInt(arguments.get("key")) : 0;
        String outPath = arguments.containsKey("out") ? arguments.get("out") : "";

        String data = "";
        if (arguments.containsKey("data")) {
            data = arguments.get("data");
        } else if (arguments.containsKey("in")) {
            String inputPath = arguments.get("in");
            File file = new File(inputPath);
            if (file.exists() && file.isFile() && file.canRead()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    data += scanner.nextLine();
                }
                scanner.close();
            } else {
                System.out.println("Error while reading file");
                return;
            }
        }
        EncDec encDec = null;
        switch (alg.toLowerCase()) {
            case "unicode":
                encDec = new UnicodeAlg();
                break;
            case "shift":
                encDec = new ShiftAlg();
                break;
            default:
                System.out.println("No such algorithm");
                return;

        }


        switch (mode) {
            case "enc":
                if ("".equals(outPath)) {
                    System.out.println(encDec.encrypt(data, key));
                } else {
                    File file = new File(outPath);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(encDec.encrypt(data, key).getBytes());
                    fileOutputStream.close();
                }
                break;
            case "dec":
                if ("".equals(outPath)) {
                    System.out.println(encDec.decrypt(data, key));
                } else {
                    File file = new File(outPath);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(encDec.decrypt(data, key).getBytes());
                    fileOutputStream.close();
                }
                break;
            default:
                System.out.println("Wrong operation");
        }

    }

}

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

//        List<String> commands = Arrays.asList
//        (
//            "ADD PERSON(Tomasz_Romański)",
//            "ADD PERSON(Rafał_Adamczuk)",
//            "ADD PERSON(Tomasz_Romański)",
//            "ADD PERSON(Mariusz_Wilczek)",
//            "ADD PERSON(Zbigniew_Ratownik,VIP)",
//            "PROCESS",
//            "LEAVE PERSON(Tomasz_Romański_2)",
//            "LEAVE PERSON(Mariusz_Wilczek)",
//            "PROCESS",
//            "PROCESS",
//            "PROCESS"
//        );

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            CustomQueue customQueue = new CustomQueue();
            customQueue.processAllCommands(sc.nextLine());
        }


    }


}

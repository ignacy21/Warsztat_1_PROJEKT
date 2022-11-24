import java.util.*;

public class CustomQueue {

    public void processAllCommands(String command) {
        Deque<Person> personQueue = new ArrayDeque<>();
        List<Person> uniquePersons = new LinkedList<>();
            if (command.contains("ADD PERSON")) {
                addingToQueue(command, personQueue, uniquePersons);
            } else if (command.contains("LEAVE PERSON")) {
                leavePerson(command, personQueue);
            } else if ("PROCESS".contains(command)) {
                process(personQueue);
            } else {
                System.out.println("O co Ci chodzi?");
            }
        }
    private static void addingToQueue(String command, Deque<Person> queue, List<Person> personList) {
        String person = command.substring(command.indexOf("(") + 1, command.length() - 1);
        if (person.contains("VIP")) {
            addingVIP(person, queue, personList);
        } else {
            String[] name_Surname = person.split("_");
            String name = name_Surname[0];
            String surname = name_Surname[1];
            Person finalPerson = new Person(name, surname, 1);
            checkCounter(finalPerson, personList);
            personList.add(finalPerson);
            queue.add(finalPerson);
            boolean cameToTheQueue = true;
            System.out.printf("%s came to the queue: %s %n", finalPerson, cameToTheQueue);
            System.out.printf("Queue: %s %n%n", queue);
        }
    }
    private static void addingVIP(String command, Deque<Person> queue, List<Person> personList) {
        String VIP = command.substring(0, command.indexOf(","));
        String[] nameSurname = VIP.split("_");
        String name = nameSurname[0];
        String surname = nameSurname[1];
        Person finalPerson = new Person(name, surname, 1, true);
        checkCounter(finalPerson, personList);
        personList.add(finalPerson);
        queue.push(finalPerson);
        boolean cameToTheQueue = true;

        System.out.printf("%s came to the queue: %s %n", finalPerson, cameToTheQueue);
        System.out.printf("Queue: %s %n%n", queue);
    }

    private static void process(Deque<Person> queue) {
        if (queue.isEmpty()) {
            System.out.println("Your queue is already empty");
            return;
        }
        System.out.printf("Processing queue: %s %n", queue.poll());
        System.out.printf("Queue: %s %n%n", queue);
    }

    private static void leavePerson(String command, Deque<Person> queue) {
        String person = command.substring(command.indexOf("(") + 1, command.length() - 1);
        String[] name_Surname = person.split("_");
        String name = name_Surname[0];
        String surname = name_Surname[1];

        if (name_Surname.length == 3) {
            Integer counter = Integer.parseInt(name_Surname[2]);
            Person personToDust = new Person(name, surname, counter);
            queue.removeIf(onePerson -> onePerson.equals(personToDust));
        }  else if (name_Surname.length == 2) {
            Person personToDust = new Person(name, surname, 1);
            queue.removeIf(onePerson -> onePerson.equals(personToDust));
            person += "_1";
        }

        System.out.printf("Leaving queue: %s%n", person);
        System.out.printf("Queue: %s%n%n", queue);
    }

    private static Integer checkCounter(Person person, List<Person> personList) {
        for (Person person1 : personList) {
            if (person1.equals(person)) {
                person.setCounter(person.getCounter() + 1);
            }
        }
        return person.getCounter();
    }

}

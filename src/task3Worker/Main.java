package task3Worker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String name;
        String position;
        int year;

        Worker[] workersList = new Worker[2];


        for (int i = 0; i < 2; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the worker: ");
            name = sc.nextLine();
            try{
                for (char c:
                     name.toCharArray()) {
                    if(Character.isDigit(c)) {
                        throw new Exception("Incorrect symbols.");
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getMessage() + "Try again");
            }
            System.out.println("Enter the job title: ");
            position = sc.nextLine();
            // В задаче не требуется проверять должность, поэтому это пока опустим
//            try{
//                for (char c:
//                        position.toCharArray()) {
//                    if(Character.isDigit(c)) {
//                        throw new Exception("Incorrect symbols.");
//                    }
//                }
//            } catch(Exception e) {
//                System.out.println(e.getMessage() + "Try again");
//            }
            System.out.println("Enter the year of hiring: ");

            // Посмотри на 49-ю и 54 строки. Ты дважды пытаешься прочесть год, и первый вызов не внутри try-catch.
            // Поэтому он не ловит это исключение. Если уберешь 49-ю строку, то все будет ОК.

//            year = sc.nextInt();
            //здесь попыталась ловить исключение InputMismatchException, однако он не ловит

            // код выглядел так:
             try{
                  year = sc.nextInt(); //* по идее, выбрасываемое здесь исключение должен был ловить кэч
             } catch(Exception e) {
                            System.out.println(e.getMessage() + "Try again");
                            year = 1999; // присваиваем какое-нибудь предустановленное значение
                        }
//            try{
//               if(year < 1930) {
//                   throw new Exception("Incorrect year data.");
//               }
//            } catch(Exception e) {
//                System.out.println(e.getMessage() + "Try again");
//            }

            Worker worker = new Worker(name, position, year);
            workersList[i] = worker;
            System.out.println(worker.toString());
            System.out.println("the end");
        }
        System.out.println(workersList.toString());
        for (Worker names:
             workersList) {
            System.out.println("Unsorted Name: " + names.getName());
        }

        Arrays.sort(workersList);

        for (Worker names:
                workersList) {
            System.out.println("Sorted Name: " + names.getName());
        }

        for (Worker count:
             workersList) {
            int y = count.getYear();
            if((2020 - y) > 20) {
                System.out.println("This employee " + count.getName() + "\ncurrently occupying the position "
                                    + count.getPosition() + "\nhas more than 20 years of experience." +
                                    "\nWork experience: " + (2020 - count.getYear()));
            }
        }
    }
}

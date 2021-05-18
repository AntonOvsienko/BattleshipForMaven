package ua.com.finaly;

import ua.com.finaly.Demo.CompLogic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectInputStream ois1=new ObjectInputStream(new FileInputStream("src\\main\\resources\\Player1.bin"));////Тест
//        ObjectInputStream ois2=new ObjectInputStream(new FileInputStream("src\\main\\resources\\Player2.bin"));////Тест
        Scanner scanner=new Scanner(System.in);
        Anketa player1 = new Anketa();
        Anketa player2 = new Anketa();

        System.out.println("Выберите формат партии: 1 - HumanVsHuman, 2 - Демонстрация ComputerVsComputer");
        if (DataInput.InputInteger(2)==1) {

//        player1=(Anketa) ois1.readObject();                                                   ////Тест
//        player2=(Anketa) ois2.readObject();                                                   ////Тест
//        System.out.println(player1.getName());                                                ////Тест
//        Vizualization.Vizual(player1.getField());                                             ////Тест
//        System.out.println(player2.getName());                                                ////Тест
//        Vizualization.Vizual(player2.getField());                                             ////Тест

            System.out.println("Введите имя первого игрока");
            player1.setName(scanner.nextLine());
            System.out.println("Введите имя второго игрока");
            player2.setName(scanner.nextLine());
            Initialization.shipInitial(player1, player2);
            Initialization.shipInitial(player2, player1);
        /*
        ObjectOutputStream oos1=new ObjectOutputStream(new FileOutputStream("Player1.bin")); ///запись
        oos1.writeObject(player1);                                                           ///запись
        oos1.close();                                                                        ///запись

        ObjectOutputStream oos2=new ObjectOutputStream(new FileOutputStream("Player2.bin")); ///запись
        oos2.writeObject(player2);                                                           ///запись
        oos2.close();*/                                                                      ///запись

            System.out.println("Если готовы нажмите Enter, первый игрок будет выбран случайным образом");
            Battle.FightStart(player1, player2);
        } else {
            player1.setName("Fortran");
            player2.setName("Basic");
            CompLogic.Initial(player1);
            CompLogic.Initial(player2);
            Vizualization.AuraClear(player1);
            Vizualization.AuraClear(player2);
            System.out.println("Стартовые схема, нажмите Enter для начала");
            Vizualization.VizualCompVsComp(player1, player2);
            scanner.hasNextLine();
            CompLogic.LetsPlay(player1,player2);
        }
    }
}

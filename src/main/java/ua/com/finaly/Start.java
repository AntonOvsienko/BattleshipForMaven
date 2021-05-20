package ua.com.finaly;

import ua.com.finaly.Demo.CompLogic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        Anketa player1 = new Anketa();
        Anketa player2 = new Anketa();
        boolean winLose = false;

        System.out.println("Выберите формат партии: 1 - HumanVsHuman, 2 - Демонстрация ComputerVsComputer");
        if (DataInput.InputInteger(2)==1) {
            System.out.println("Введите имя первого игрока");
            player1.setName(scanner.nextLine());
            System.out.println("Введите имя второго игрока");
            player2.setName(scanner.nextLine());
            Initialization.shipInitial(player1, player2);
            Initialization.shipInitial(player2, player1);
            Anketa player1_enemy=new Anketa(player2.getName());
            Anketa player2_enemy=new Anketa(player1.getName());
            System.out.println("Если готовы нажмите Enter, первый игрок будет выбран случайным образом");
            Battle.FightStart(player1, player2);
        } else {
            player1.setName("Fortran");
            player2.setName("Basic");
            Anketa player1_enemy=new Anketa("Basic");
            Anketa player2_enemy=new Anketa("Fortran");
            CompLogic.Initial(player1);
            CompLogic.Initial(player2);
            Vizualization.AuraClear(player1);
            Vizualization.AuraClear(player2);
            System.out.println("Стартовые схема, нажмите Enter для начала");
            Vizualization.VizualCompVsComp(player1, player2);
            scanner.hasNextLine();

            while(true){
            CompLogic.LetsPlay(player1,player1_enemy,player2,player2_enemy);
                if (player2.getShipList().stream().allMatch(x->x.getHealth()==0)){
                    Finally(player1);
                    break;
                }
            CompLogic.LetsPlay(player2,player2_enemy,player1,player1_enemy);
                if (player1.getShipList().stream().allMatch(x->x.getHealth()==0)){
                    Finally(player2);
                    break;
                }
            }
        }
    }

    public static void Finally(Anketa player1){
        System.out.println("Игрок " + player1.getName() + " победил");
    }
}

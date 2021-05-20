package ua.com.finaly.Demo;

import ua.com.finaly.Anketa;
import ua.com.finaly.ShipClass;
import ua.com.finaly.Vizualization;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

import static java.lang.Thread.sleep;

public class CompLogic {

    public static void Initial(Anketa player){
        int[][] ship=new int[10][10];

            while (player.getCount4()!=0){
                int[] massivfinal=new int[8];
                BuildCoil(massivfinal,4);
                if (CheckCoil(massivfinal)){
                    continue;
                } else {
                    player.setCount4(player.getCount4()-1);
                    int x1 = massivfinal[0];
                    int y1 = massivfinal[1];
                    int x2 = massivfinal[2];
                    int y2 = massivfinal[3];
                    int x3 = massivfinal[4];
                    int y3 = massivfinal[5];
                    int x4 = massivfinal[6];
                    int y4 = massivfinal[7];
                    ship[x1][y1] = 1;
                    ship[x2][y2] = 1;
                    ship[x3][y3] = 1;
                    ship[x4][y4] = 1;
                    player.setField(ship);
                    player.getShipList().add(new ShipClass(x1,y1,x2,y2,x3,y3,x4,y4));
                    Vizualization.Aura(massivfinal,player);
                }
            }
        while (player.getCount3()!=0){
            int[] massivfinal=new int[6];
            BuildCoil(massivfinal,3);
            if (CheckCoil(massivfinal)||CheckAnyShip(massivfinal,player)){
                continue;
            } else {
                player.setCount3(player.getCount3()-1);
                int x1 = massivfinal[0];
                int y1 = massivfinal[1];
                int x2 = massivfinal[2];
                int y2 = massivfinal[3];
                int x3 = massivfinal[4];
                int y3 = massivfinal[5];
                ship[x1][y1] = 1;
                ship[x2][y2] = 1;
                ship[x3][y3] = 1;
                player.setField(ship);
                player.getShipList().add(new ShipClass(x1,y1,x2,y2,x3,y3));
                Vizualization.Aura(massivfinal,player);
            }
        }

        while (player.getCount2()!=0){
            int[] massivfinal=new int[4];
            BuildCoil(massivfinal,2);
            if (CheckCoil(massivfinal)||CheckAnyShip(massivfinal,player)){
                continue;
            } else {
                player.setCount2(player.getCount2()-1);
                int x1 = massivfinal[0];
                int y1 = massivfinal[1];
                int x2 = massivfinal[2];
                int y2 = massivfinal[3];
                ship[x1][y1] = 1;
                ship[x2][y2] = 1;
                player.setField(ship);
                player.getShipList().add(new ShipClass(x1,y1,x2,y2));
                Vizualization.Aura(massivfinal,player);
            }
        }
        while (player.getCount1()!=0){
            int[] massivfinal=new int[2];
            BuildCoil(massivfinal,1);
            if (CheckAnyShip(massivfinal,player)){
                continue;
            } else {
                player.setCount1(player.getCount1()-1);
                int x1 = massivfinal[0];
                int y1 = massivfinal[1];
                ship[x1][y1] = 1;
                player.setField(ship);
                player.getShipList().add(new ShipClass(x1,y1));
                Vizualization.Aura(massivfinal,player);
            }
        }
    }

    public static void BuildCoil(int[] massivfinal,int coint){
        Random random=new Random();
        massivfinal[0] = random.nextInt(10);
        int x=massivfinal[0];
        int y=massivfinal[1];
        massivfinal[1] = random.nextInt(10);
        int xy = random.nextInt(4);
        for (int i = 0; i<(coint-1)*2; i += 2){
            if (xy == 0){
                massivfinal[i+2]=massivfinal[i]+1;
                massivfinal[i+3]=massivfinal[i+1];
            } else if (xy == 1){
                massivfinal[i+2]=massivfinal[i]-1;
                massivfinal[i+3]=massivfinal[i+1];
            } else if (xy == 2){
                massivfinal[i+2]=massivfinal[i];
                massivfinal[i+3]=massivfinal[i+1]+1;
            } else {
                massivfinal[i+2]=massivfinal[i];
                massivfinal[i+3]=massivfinal[i+1]-1;
            }
        }
    }

    public static boolean CheckCoil(int[] massiv){
        return Arrays.stream(massiv).anyMatch(i->i<0||i>9);
    }

    public static boolean CheckAnyShip(int[] massiv,Anketa player){
        int [][] massiveTemp = player.getField();
        for (int i=0;i < massiv.length;i+=2){
            if (massiveTemp[massiv[i]][massiv[i+1]]==1||massiveTemp[massiv[i]][massiv[i+1]]==4){
                return true;
            }
        }
        return false;
    }

    public static void LetsPlay(Anketa player1, Anketa player1_enemy,Anketa player2, Anketa player2_enemy) throws InterruptedException {
        Boolean turn=false;
            do {
                Random random = new Random();
                if (player1.isAILogicOn()) {
                    turn=AIOn(player1, player1_enemy, player2,turn);
                } else {
                    int x = random.nextInt(10);
                    int y = random.nextInt(10);
                    System.out.println(x + "/" + y);
                    if (player1_enemy.getField()[x][y] == 3 || player1_enemy.getField()[x][y] == 2) {
                        continue;
                    }
                    turn=AIOff(x, y, player1, player1_enemy, player2,turn);
                }

                Vizualization.VizualCompVsComp(player2_enemy,player1_enemy);
                System.out.print(1);
                for (int z = 1; z < 5; z++) {
                    sleep(200);
                    System.out.print(".");
                    sleep(200);
                    System.out.print(".");
                    sleep(200);
                    System.out.print(".");
                    sleep(200);
                    System.out.print(".");
                    System.out.print(z + 1);
                }
                System.out.println();
            } while (turn);
    }
    public static String ShipChecked(int x, int y,Anketa player1_enemy,Anketa player2){
        for (ShipClass shipcounter:player2.getShipList()){
            for (int i=0;i<shipcounter.getShip().size();i+=2){
                if (shipcounter.getShip().get(i)==x&&shipcounter.getShip().get(1+i)==y){
                    shipcounter.setHealth(shipcounter.getHealth()-1);
                    if (shipcounter.getHealth()==0){
                        int[] temp=new int[shipcounter.getAura().size()];
                        for (int p=0;p < temp.length;p++){
                            temp[p]=shipcounter.getAura().get(p);
                        }
                        Vizualization.AuraForBattle(player1_enemy,temp);
                        return "убил";
                    }
                }
            }
        }
        return "попал";
    }

    public static Boolean AIOff(int x,int y,Anketa player1, Anketa player1_enemy, Anketa player2,Boolean turn){
        Random random=new Random();
        String text="";
            System.out.println(x+"/"+y);
            if (player2.getField()[x][y] == 1) {
                player1_enemy.getField()[x][y] = 3;
                text = ShipChecked(x, y, player1_enemy, player2);
                if (text.equals("попал")){
                    player1.setAILogicOn(true);
                    AICoordinateFuture(x,y,player1,player1_enemy);
                }
                turn = true;
            } else {
                player1_enemy.getField()[x][y] = 2;
                text = "мимо";
                turn = false;
            }
        System.out.println(player1.getName()+" выбрал координаты x(" + x +
                "),y(" + y + ")-" + text);
            return turn;
    }

    public static Boolean AIOn(Anketa player1, Anketa player1_enemy, Anketa player2, Boolean turn){
        String text="";
        Random random=new Random();
        int t = player1.getAILogic().size()/2;
        int ji = random.nextInt(t);
        int x = player1.getAILogic().get(ji*2);
        player1.getAILogic().remove(ji*2);
        int y = player1.getAILogic().get(ji*2);
        player1.getAILogic().remove(ji*2);
        System.out.println(x+"/"+y);
        if (player2.getField()[x][y] == 1) {
            player1_enemy.getField()[x][y] = 3;
            text = ShipChecked(x, y, player1_enemy, player2);
            if (text.equals("попал")){
                turn=true;
                try {
                    if (player1_enemy.getField()[x - 1][y] == 3) {
                        player1.getAILogic().add(x + 1);
                        player1.getAILogic().add(y);
                        int circle=0;
                        for (int i=0;i<player1.getAILogic().size()-circle;i+=2){
                            if (y!=player1.getAILogic().get(i+1)){
                                player1.getAILogic().remove(i+1);
                                player1.getAILogic().remove(i);
                                circle+=2;
                                i-=2;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e){

                }

                try {
                    if (player1_enemy.getField()[x + 1][y] == 3) {
                        player1.getAILogic().add(x - 1);
                        player1.getAILogic().add(y);
                        int circle=0;
                        for (int i=0;i<player1.getAILogic().size()-circle;i+=2){
                            if (y!=player1.getAILogic().get(i+1)){
                                player1.getAILogic().remove(i+1);
                                player1.getAILogic().remove(i);
                                circle+=2;
                                i-=2;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e){

                }

                try {
                    if (player1_enemy.getField()[x][y-1]==3){
                        player1.getAILogic().add(x);
                        player1.getAILogic().add(y+1);
                        int circle=0;
                        for (int i=0;i<player1.getAILogic().size()-circle;i+=2){
                            if (x!=player1.getAILogic().get(i)){
                                player1.getAILogic().remove(i+1);
                                player1.getAILogic().remove(i);
                                circle+=2;
                                i-=2;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e){

                }

                try {
                    if (player1_enemy.getField()[x][y+1]==3){
                        player1.getAILogic().add(x);
                        player1.getAILogic().add(y-1);
                        int circle=0;
                        for (int i=0;i<player1.getAILogic().size()-circle;i+=2){
                            if (x!=player1.getAILogic().get(i)){
                                player1.getAILogic().remove(i+1);
                                player1.getAILogic().remove(i);
                                circle+=2;
                                i-=2;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e){

                }

            } else {
                player1.setAILogicOn(false);
                player1.getAILogic().clear();
            }
        } else {
            player1_enemy.getField()[x][y] = 2;
            text = "мимо";
            turn = false;
        }
        System.out.println(player1.getName()+" выбрал координаты x(" + x +
                "),y(" + y + ")-" + text);
        return turn;
    }

    public static void AICoordinateFuture(int x, int y, Anketa player1, Anketa player1_enemy){

        try {
            if (player1_enemy.getField()[x - 1][y] != 3 && player1_enemy.getField()[x - 1][y] != 2) {
                player1.getAILogic().add(x - 1);
                player1.getAILogic().add(y);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }

        try {
            if (player1_enemy.getField()[x + 1][y] != 3 && player1_enemy.getField()[x + 1][y] != 2) {
                player1.getAILogic().add(x + 1);
                player1.getAILogic().add(y);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }

        try {
            if (player1_enemy.getField()[x][y-1]!=3&&player1_enemy.getField()[x][y-1]!=2){
                player1.getAILogic().add(x);
                player1.getAILogic().add(y-1);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }

        try {
            if (player1_enemy.getField()[x][y+1]!=3&&player1_enemy.getField()[x][y+1]!=2){
                player1.getAILogic().add(x);
                player1.getAILogic().add(y+1);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
    }
}

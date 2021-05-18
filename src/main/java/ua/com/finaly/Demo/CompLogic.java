package ua.com.finaly.Demo;

import ua.com.finaly.Anketa;
import ua.com.finaly.Checked;
import ua.com.finaly.Vizualization;

import java.util.Arrays;
import java.util.Random;

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

    public static void LetsPlay(Anketa player1, Anketa player2){
        Random random=new Random();
        boolean stop=true;
        Anketa player1_enemy=new Anketa("Basic");
        Anketa player2_enemy=new Anketa("Fortran");

        for (int i=0;i<10;i++){
           int x = random.nextInt(10);
           int y = random.nextInt(10);
            System.out.println(x+"/"+y);
           if (player1_enemy.getField()[x][y]==3||player1_enemy.getField()[x][y]==2){
                continue;
           }else {
               if (player2.getField()[x][y]==1){
                   player1_enemy.getField()[x][y]=3;
                   ShipChecked(x,y,player1_enemy,player2);
               } else {
                   player1_enemy.getField()[x][y]=2;
               }
           }

        }
        Vizualization.VizualCompVsComp(player1,player1_enemy);
    }
    public static void ShipChecked(int x, int y,Anketa player1_enemy,Anketa player2){
        int[] xy={-1,0,1,0,0,-1,0,1};
        for (int i=0;i<xy.length;i+=2){
            try{
            if (player2.getField()[x+xy[i]][y+xy[i+1]]==1&&player1_enemy.getField()[x+xy[i]][y+xy[i+1]]!=3){
                return;
            }else if (player2.getField()[x+xy[i]][y+xy[i+1]]==1 && player1_enemy.getField()[x+xy[i]][y+xy[i+1]]==3){

            }
            } catch (ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
    }
}

package ua.com.finaly;

public class Vizualization {
    private static String ship="\u2B1B";
    private static String empty="\u2B1C";
    private static String shipEmpty="\u2BBD";
    private static String shipHit="\u2B1B";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";


    public static void Vizual(int[][] player){
        System.out.println("----------------------------------------");
        System.out.println("  ⓪"+"①"+"②"+"③"+"④"+"⑤"+"⑥"+"⑦"+"⑧"+"⑨");
        for (int i=0;i<player.length;i++){
            System.out.printf("%1d|",i);
            for (int j=0;j<player[i].length;j++){
                switch (player[j][i]){
                    case (1):
                        System.out.print(ship);
                        break;
                    case (2):
                        System.out.print(shipEmpty);
                        break;
                    case (3):
                        System.out.print(RED + shipHit + RESET);
                        break;
                    case (4):
                        System.out.print(PURPLE + empty + RESET);
                        break;
                    default:
                        System.out.print(empty);
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }

    public static void VizualCompVsComp(Anketa player,Anketa player2){
        System.out.println("----------------------------------------");
        System.out.printf("    %8s       %12s\n",player.getName(),player2.getName());
        System.out.println("  ⓪"+"①"+"②"+"③"+"④"+"⑤"+"⑥"+"⑦"+"⑧"+"⑨"+
                "      ⓪"+"①"+"②"+"③"+"④"+"⑤"+"⑥"+"⑦"+"⑧"+"⑨");
        for (int i=0;i<player.getField().length;i++){
            System.out.printf("%1d|",i);
            for (int j=0;j<player.getField()[i].length;j++){
                switch (player.getField()[j][i]){
                    case (1):
                        System.out.print(ship);
                        break;
                    case (2):
                        System.out.print(shipEmpty);
                        break;
                    case (3):
                        System.out.print(RED + shipHit + RESET);
                        break;
                    case (4):
                        System.out.print(PURPLE + empty + RESET);
                        break;
                    default:
                        System.out.print(empty);
                }
            }
            System.out.printf("%5d|",i);
            for (int j=0;j<player2.getField()[i].length;j++){
                switch (player2.getField()[j][i]){
                    case (1):
                        System.out.print(ship);
                        break;
                    case (2):
                        System.out.print(shipEmpty);
                        break;
                    case (3):
                        System.out.print(RED + shipHit + RESET);
                        break;
                    case (4):
                        System.out.print(PURPLE + empty + RESET);
                        break;
                    default:
                        System.out.print(empty);
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
    public static void Aura(int[] massivfinal, Anketa player) {
        int[][] aura = player.getField();
        for (int k = 0; k < massivfinal.length/2; k++) {
            for (int i = massivfinal[0 + k * 2] - 1; i < massivfinal[0 + k * 2] + 2; i++) {
                for (int j = massivfinal[1 + k * 2] - 1; j < massivfinal[1 + k * 2] + 2; j++) {
                    if (i >= 0 && i < 10 && j >= 0 && j < 10) {
                        if (aura[i][j] != 1 && aura[i][j] != 3) {
                            aura[i][j] = 4;
                        }
                    }
                }
            }
        }
        player.setField(aura);
    }
    public static void AuraBattle(Anketa player, int[] massivfinal) {
        int[][] aura = player.getField();
        for (int k = 0; k < massivfinal.length/2; k++) {
            for (int i = massivfinal[0 + k * 2] - 1; i < massivfinal[0 + k * 2] + 2; i++) {
                for (int j = massivfinal[1 + k * 2] - 1; j < massivfinal[1 + k * 2] + 2; j++) {
                    if (i >= 0 && i < 10 && j >= 0 && j < 10) {
                        if (aura[i][j] != 1 && aura[i][j] != 3) {
                            aura[i][j] = 2;
                        }
                    }
                }
            }
        }
        player.setField(aura);
    }
    public static void AuraClear(Anketa player) {
        int[][] aura = player.getField();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                if (aura[i][j] == 4) {
                    aura[i][j] = 5;
                }
        }
    }
}


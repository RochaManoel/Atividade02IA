package Engine;

import java.util.Scanner;

import Entities.Lista;
import Entities.Node;
import Entities.Table;

public class Menu {
    public Scanner sc = new Scanner(System.in);
    public Table t = new Table();
    public Lista list = new Lista();

    public Menu(){
        System.out.println("Problema: Metrô de Paris\n");
        boolean control = true;
        while(control){
            System.out.println("Digite a opção desejada: \n[0] - Encerrar Programa\n[1] - Busca da solução do menor caminho com A*");
            int option = sc.nextInt();
            switch(option){
                case 0:
                    control = false;
                    System.out.println("\nPrograma Encerrado com sucesso.");
                    break;
                case 1:
                    engine();
                    break;
                default:
                    System.out.println("\nComando Inválido, Por favor digite novamente!\n");
                    break;
            }
        }
    }

    public void engine(){
        list = new Lista();
        System.out.println("Digite o número da estação atual:\n[1 à 14]");
        int nodeStart = sc.nextInt();
        System.out.println("Digite o número da estação final:\n[1 à 14]");
        int nodeEnd = sc.nextInt();
        Node node = new Node(nodeStart-1);
        list.addVisitedList(node);
        search_A_Star(node, nodeEnd-1);
    }

    public void search_A_Star(Node nCurrent, int nodeEnd){
        if(nCurrent.stationCurrent == nodeEnd){
            list.sum = nCurrent.g1 + nCurrent.g2;
            System.out.println("\nCaminho Encontrado com Sucesso!\n");
            list.print(nCurrent);
            System.out.println("\nO percuso desejado apresenta Tempo total: " + list.sum + " min\n");
        }
        else{
            generateNode(nCurrent, nodeEnd);
            search_A_Star(list.getNode(),nodeEnd);
        }
    }

    public void generateNode(Node nCurrent, int sEnd){
        int level = nCurrent.level + 1;
        int stationLast = nCurrent.stationCurrent;
        for(int i = 0; i < 14; i++){
            int lineConnection = t.connections[stationLast][i];
            if(lineConnection != 0){
                int G1 = g1(nCurrent.stationCurrent, lineConnection);
                int G2 = g2(stationLast, i);
                int H = h(i, sEnd);
                Node node = new Node(level, stationLast, i, lineConnection, G1, G2,H);
                if(list.checkVisited(node)){
                    list.addVisitedList(node);
                    list.addSortedList(node);
                }
            }
        }
    }

    public Integer g1(int lineCurrent, int lineConnection){
        return (lineCurrent!=-1 && (lineCurrent!=lineConnection)) ? 4 : 0;
    }

    public Integer g2(int sStart, int sCurrent){
        return t.distance[sStart][sCurrent]*2;
    }

    public Integer h(int sCurrent, int sEnd){
        return t.distance[sCurrent][sEnd]*2;
    }

}

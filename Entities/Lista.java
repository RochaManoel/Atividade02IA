package Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {
    public List<Node> sortedList = new ArrayList<Node>();
    public List<Node> visitedList = new ArrayList<Node>();
    public Integer sum = 0;

    public Lista(){
        this.sortedList = new ArrayList<Node>();
        this.visitedList = new ArrayList<Node>();
        this.sum = 0;
    }

    public void addSortedList(Node node){
        sortedList.add(node);
        Collections.sort(sortedList);
    }

    public void addVisitedList(Node node){
        visitedList.add(node);
    }

    public Node getNode(){
        return sortedList.get(0);
    }

    public boolean checkVisited(Node node){
        for(Node n : visitedList){
            if(n.stationCurrent == node.stationCurrent){
                return false;
            }
        }
        return true;
    }

    public void print(Node node){
        if(node.level!=0){
            int Level = node.level - 1;
            int stationCurrent = node.stationLast;
            for(Node n : this.visitedList){
                if(n.level == Level && n.stationCurrent == stationCurrent){
                    print(n);
                    this.sum += n.g1 + n.g2;
                    String str = "";
                    str += "E"+(node.stationLast+1)+" >> ";
                    str += (node.g1 == 0) ? "" : "4 min + ";
                    str += node.g2+" min >> ";
                    str += "E"+(node.stationCurrent+1);
                    System.out.println(str);
                    return;
                }
            }
        }
    }
    
}

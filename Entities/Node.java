package Entities;

public class Node implements Comparable<Node>{
    public int level;
    public int stationLast;
    public int stationCurrent;
    public int lineCurrent;
    public int g1;
    public int g2;
    public int h;
    public int f;

    public Node(Integer stationCurrent){
        this.level = 0;
        this.stationLast = -1;
        this.stationCurrent = stationCurrent;
        this.lineCurrent = -1;
        this.g1 = 0;
        this.g2 = 0;
        this.h = 0;
        this.f = 0;
    }

    public Node(Integer level, Integer stationLast, Integer stationCurrent, Integer lineCurrent, Integer g1, Integer g2, Integer h){
        this.level = level;
        this.stationLast = stationLast;
        this.stationCurrent = stationCurrent;
        this.lineCurrent = lineCurrent;
        this.g1 = g1;
        this.g2 = g2;
        this.h = h;
        this.f = g1 + g2 + h;
    }

    @Override
    public int compareTo(Node other) {
        if(this.f > other.f){
            return 1;
        }
        if(this.f < other.f){
            return -1;
        }
        return 0;
    }
}

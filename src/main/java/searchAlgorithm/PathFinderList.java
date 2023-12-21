package main.java.searchAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class PathFinderList<T> implements Comparable<PathFinderList<T>> {
    private List<PathNode> pathNodeList = new ArrayList<>();


    public void add(PathNode pathNode) {
        pathNodeList.add(pathNode);
    }

    public void addAll(PathFinderList<PathNode> list){
        this.pathNodeList.addAll(list.getPathNodeList());
    }

    @Override
    public int compareTo(PathFinderList<T> o) {
        int pathWeightThis = this.getPathNodeList().get(this.getPathNodeList().size()-1).getPathWeight();
        int pathWeightInput = o.getPathNodeList().get(o.getPathNodeList().size()-1).getPathWeight();

        return pathWeightThis-pathWeightInput;
    }

    public List<PathNode> getPathNodeList() {
        return pathNodeList;
    }

    public void setPathNodeList(List<PathNode> pathNodeList) {
        this.pathNodeList = pathNodeList;
    }

    public PathNode get(int i) {
        return pathNodeList.get(i);
    }

    public void remove(int i) {
        pathNodeList.remove(i);
    }

    public boolean isEmpty() {
        return pathNodeList.isEmpty();
    }

    public int size() {
        return pathNodeList.size();
    }
}

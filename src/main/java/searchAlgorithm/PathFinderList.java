package main.java.searchAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathFinderList<T> implements Comparable<PathFinderList<T>> {
    List<PathNode> pathNodeList = new ArrayList<>();

    public PathFinderList() {
    }

    public PathFinderList(PathFinderList<PathNode> list) {
        this.pathNodeList.addAll(list.pathNodeList);
    }

    public void add(PathNode pathNode) {
        pathNodeList.add(pathNode);
    }


    @Override
    public int compareTo(PathFinderList<T> o) {
        int pathWeightThis = this.pathNodeList.get(this.pathNodeList.size()-1).getPathWeight();
        int pathWeightInput = o.pathNodeList.get(o.pathNodeList.size()-1).getPathWeight();

        return pathWeightThis-pathWeightInput;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathFinderList<?> that = (PathFinderList<?>) o;

        return Objects.equals(pathNodeList, that.pathNodeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathNodeList);
    }
}

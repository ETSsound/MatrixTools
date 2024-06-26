//THANK YOU https://stackoverflow.com/questions/4401850/how-to-create-a-multidimensional-arraylist-in-java

import java.util.ArrayList;

class TwoDArrayList<T> extends ArrayList<ArrayList<T>> {
    public void addToInnerArray(int index, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }
        this.get(index).add(element);
    }

    public void addToInnerArray(int index, int index2, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<T> inner = this.get(index);
        while (index2 >= inner.size()) {
            inner.add(null);
        }

        inner.set(index2, element);
    }

    //ok this is new
    public T get(int index1, int index2) {
        ArrayList<T> inner = this.get(index1);
        return inner.get(index2);
    }
}

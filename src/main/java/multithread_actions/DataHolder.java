package multithread_actions;

import java.util.Arrays;
import java.util.List;

public class DataHolder {


    public static int deposit = 0;
    public int sum;

    private List<Integer> integerList = Arrays.asList(0,1,2);

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }


}

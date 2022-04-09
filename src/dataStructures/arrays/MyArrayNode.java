package src.dataStructures.arrays;

import java.util.List;

public class MyArrayNode {

    private Object data;
    private int currentIndex;

    MyArrayNode(int currentIndex, Object data)
    {
        this.currentIndex = currentIndex;
        this.data = data;
    }

    public int getCurrentIndex(){
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex){
        this.currentIndex = currentIndex;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}

class MyArray {

    private List<MyArrayNode> dataList;

    private int length;

    MyArray(int length, List<MyArrayNode> dataList){
        this.dataList = dataList;
        this.length = length;
    }

    public void putElement(int index, Object data)
    {
        if(index < length)
        {
            dataList.stream().forEach(elem -> {

                if(elem.getCurrentIndex() == index)
                {
                    elem.setData(data);
                }
            });
        }
    }

}

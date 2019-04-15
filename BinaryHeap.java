public class BinaryHeap {
    private int [] items;
    private int size = 0;
    public BinaryHeap(){
        items = new int[10];
    }
    public int remove(){ //removes the first element of heap and replaces with the last element of the tree
        int value = items[0];
        items[0] = items[size-1];
        size--;
        int index =0;
        //swap with smallest child if less than you
        while((index*2)+1 < size){
            int left = items[(index*2)+1];
            int right = left;
            if((index*2)+2 < size) {
                right = items[(index * 2) + 2];
            }
            int smallest = left;
            int smallestIndex = (2*index)+1;
            if(right < left){
                smallest = right;
                smallestIndex = (2*index)+2;
            }
            if(items[index]> smallest){
                int temp = items[index];
                items[index] = items[smallestIndex];
                items[smallestIndex] = temp;
                index = smallestIndex;
            }
            else{
                break;
            }
        }
        return value;
    }

    public void add(int value){
        //if we add space in array we have to double size of array
        if(size == items.length){
            int[] newItems = new int[size*2];
            for(int i = 0; i< items.length; i++){
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[size] = value;
        size++;
        int index = size-1;
        //swap with parent if the parent is greater
        while((index > 0) && (items[(index-1)/2] > items[index])){
            int temp = items[index];
            items[index] = items[(index-1)/2];
            items[(index-1)/2] = temp;
            index = (index-1)/2;

        }
    }
}

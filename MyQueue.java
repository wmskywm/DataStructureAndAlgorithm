import java.util.Scanner;

public class MyQueue {
    public int maxSize;
    public int[] queue;
    public int head = -1;
    public int tail = -1;
    public MyQueue(int maxSize){
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }
    public void append(int element){ //入队
        if(this.isFull()){
            System.out.println("满了加不了");
            return;
        }
        if(tail == this.queue.length - 1 && head != 0){
            tail = 0;
        }else{
            this.tail++;
        }
        if(this.head == -1){
            this.head = 0;
        }
        this.queue[this.tail] = element;
    }
    public boolean isFull(){
        if(this.tail > this.head) {
            return (this.tail - this.head) == this.maxSize - 1;
        }else if(this.tail < this.head){
            //return this.tail + this.maxSize - this.head == this.maxSize - 1;
            return this.tail - this.head == - 1;
        }else{
            return false;
        }
    }
    public boolean isEmpty(){
        return this.head == -1;
    }
    public int getElement(){ //出队
        if(this.isEmpty()){
            System.out.println("队列是空的");
            return -1;
        }
        int value =  this.queue[this.head];
        this.queue[this.head] = 0;
        if(this.tail == this.head){
            this.tail = -1;
            this.head = -1;
        }else{
            if(this.head == this.maxSize - 1){
                this.head = 0;
            }else{
                this.head++;
            }
        }
        return value;
    }
    public void des(){ //查看队列
        for(int element : this.queue){
            System.out.print(element + " ");
        }
        System.out.println("head " + this.head + " tail " + this.tail);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入队列长度：");
        MyQueue myQueue = new MyQueue(sc.nextInt());
        while(true){
            System.out.println("==============");
            System.out.println("1 入队");
            System.out.println("2 出队");
            System.out.println("3 查看队列");
            System.out.println("4 退出");
            System.out.println("==============");
            boolean flag = false;
            switch(sc.nextInt()){
                case 1:
                    System.out.println("输入入队数字：");
                    myQueue.append(sc.nextInt());
                    break;
                case 2:
                    int n = myQueue.getElement();
                    System.out.println("出队元素是：" + n);
                    break;
                case 3:
                    myQueue.des();
                    break;
                case 4:
                    flag = true;
                    break;
            }
            if(flag){break;}
        }
    }
}
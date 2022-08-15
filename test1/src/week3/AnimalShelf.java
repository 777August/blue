package week3;

import java.util.LinkedList;

//动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，
//收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗
//（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。
//请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
//enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
//dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]
public class AnimalShelf {

    LinkedList<int[]> cats;
    LinkedList<int[]> dogs;
    public AnimalShelf() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if(animal[1] == 0){
            cats.add(animal);
        }else if(animal[1] ==1){
            dogs.add(animal);
        }

    }

    public int[] dequeueAny() {
        if(cats.isEmpty() && dogs.isEmpty()){
            return new int[]{-1,-1};
        }else if(cats.isEmpty()){
            return dogs.removeFirst();
        }else if(dogs.isEmpty()){
            return cats.removeFirst();
        }else{
            int[] cat = cats.getFirst();
            int[] dog = dogs.getFirst();
            if(cat[0] < dog[0]){
                return cats.removeFirst();
            }else {
                return dogs.removeFirst();
            }
        }
    }

    public int[] dequeueDog() {

        if(dogs.isEmpty()){
            return new int[]{-1,-1};
        }else{
            return dogs.removeFirst();
        }

    }

    public int[] dequeueCat() {
        if(cats.isEmpty()){
            return new int[]{-1,-1};
        }else{
            return cats.removeFirst();
        }
    }

//leetcode提交通过
//执行用时：67 ms, 在所有 Java 提交中击败了59.97%的用户
//内存消耗：52.9 MB, 在所有 Java 提交中击败了19.94%的用户
//通过测试用例：31 / 31

}


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//2021215023  李博伦
public class lab6 {

        public static void main(String[] args) {
            List<Integer> integers = new ArrayList<Integer>();

            //Add three elements into the array list.
            integers.add(4);
            integers.add(6);
            integers.add(8);

            // Get the iterator of the array list.
            Iterator<Integer> it = integers.iterator();

            // Iterate the list and display the elements.
            while (it.hasNext()) {
                System.out.println(it.next());
                // The most recently returned element from next call is removed.
                it.remove();
            }

            //No more elements.
            System.out.println(it.hasNext());

            //The size of the array list is 0 if remove is called.
            System.out.println(integers.size());
        }

    }

public class lab4 {
    public static void main(String[] args) {
        String[] s = {"Jujube", "Orange", "Logan", "Pomegranate", "Raspberry", "Cantaloupe", "Carambola", "Date palm", "Coconut"};
        quickSort(s,0,s.length-1);
        System.out.println("test quickSort:");
        for(String name : s){
            System.out.print(name + " ");
        }

        System.out.println();
        System.out.println();
        String[] s2 = {"Jujube", "Orange", "Logan", "Pomegranate", "Raspberry", "Cantaloupe", "Carambola", "Date palm", "Coconut"};
        mergesort(s2,0,s2.length-1);
        System.out.println("test mergeSort:");
        for(String name : s2){
            System.out.print(name + " ");
        }
        System.out.println();
        System.out.println();
        System.out.print("test binarySearch:");
        System.out.println(binarySearch(s,"Logan",0,s.length-1));
        System.out.print("test sequentialSearch:");
        System.out.println(sequentialSearch(s2,"Apple"));
    }

    //quickSort
    public static void quickSort(String[] arr,int startPos, int endPos) {
        if (startPos >= endPos) {
            return;
        }
        int leftIndex = startPos;
        int rightIndex = endPos;
        String mid = arr[leftIndex];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && arr[rightIndex].compareTo(mid) >= 0) {
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];

            while (leftIndex < rightIndex && arr[leftIndex].compareTo(mid) < 0) {
                leftIndex++;
            }
            arr[rightIndex] = arr[leftIndex];
        }
        arr[leftIndex] = mid;
        quickSort(arr, startPos, leftIndex - 1);
        quickSort(arr, leftIndex + 1, endPos);

    }


    //mergesort
    public static void mergesort(String[] arr, int left, int right) {
        // TODO Auto-generated method stub
        if(left==right) {
            return;
        }
        int mid=(left+right)/2;
        mergesort(arr, left, mid);
        mergesort(arr, mid+1, right);
        merge(arr,left,mid,right);
    }

    public static void merge(String[] arr, int left, int mid,int right) {
        // TODO Auto-generated method stub
        int s1=left;
        int s2=mid+1;
        String[] temp=new String[(right-left)+1];
        int i=0;
        while(s1<=mid&&s2<=right) {
            if(arr[s1].compareTo(arr[s2])>=0) {
                temp[i++]=arr[s2++];
            }else {
                temp[i++]=arr[s1++];
            }
        }
        while(s1<=mid) {
            temp[i++]=arr[s1++];
        }
        while(s2<=right) {
            temp[i++]=arr[s2++];
        }
        for(int j=0;j<temp.length;j++) {
            arr[j+left]=temp[j];
        }
    }

    //binarySearch
    public static int binarySearch(String[] arr, String key,int min,int max){
        if(key.compareTo(arr[min])<0 || key.compareTo(arr[max])>0  || min > max) {
            return -1;
        }
        int middle = (min + max)/2;
        if(key.compareTo(arr[middle])<0) {
            return binarySearch(arr,key,min,middle-1);
        }else if(key.compareTo(arr[middle])>0) {
            return binarySearch(arr,key,middle+1,max);
        }else {
            return middle;
        }
    }

    //sequentialSearch
    public static int sequentialSearch(String[] a, String num) {
        for(int i = 0; i < a.length; i++) {
            if(a[i].equals(num)){
                return i;
            }
        }
        return -1;

    }


}


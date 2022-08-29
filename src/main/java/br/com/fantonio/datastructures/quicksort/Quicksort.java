package br.com.fantonio.datastructures.quicksort;

public class Quicksort {

     public void sort(Integer[] array) {
          this.sort(array, 0, array.length-1);
     }

     private void sort(Integer[] array, int left, int right) {

          int pivot = array[right];
          right--;

          while (array[left] < pivot) {
               left++;
          }

          while(array[right] > pivot) {
               right--;
               if (right == -1) {
                    right++;
                    break;
               }
          }

          if (right < left) {
               Integer leftValue = array[left];
               Integer rightValue = array[right];

               array[left] = rightValue;
               array[right] = leftValue;

//               break;
          }

          if (array[left] > array[right]) {
               Integer leftValue = array[left];
               Integer rightValue = array[right];

               array[left] = rightValue;
               array[right] = leftValue;
          }

     }



}

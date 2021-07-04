/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


/**
 *
 * @author george
 */
public class IO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // repalce "E:\\7asbat-3rd\\term 1\\project" with folder path
        File fl =new File("E:\\7asbat-3rd\\term 1\\project");//root
        if(fl.exists()){
                copyFiles(fl);
        }
    }
    public static void copyFiles(File f) {
        if(f.exists()){
                copy(f,f.getName());
        }
    }
    
    public static void copy(File f,String s) {
        if(f.exists()){
            if(f.isDirectory()){
                for(File fl:f.listFiles()){
                    copy(fl,s);
                }
            }
            else{
                //replace "E:\\My Copy" with new direction
                File c=new File("E:\\My Copy"+"\\"+s);
                if(c.exists()==false){
                        c.mkdirs();
                }
                String k;
                if(f.getParentFile().getName().equals(s)){
                    k="";
                }
                else{
                    k="\\"+f.getParentFile().getName();
                }
                File di=new File(c.getAbsolutePath()+k);
                if(di.exists()==false){
                    di.mkdir();
                }
                File d=new File(di.getAbsolutePath()+"\\"+f.getName());
                    try {
                        Files.copy(f.toPath(), d.toPath());
                    } catch (IOException ex) {
                        System.out.println("error");
                    }
                
                
            }
        }
    }
    /*
    //problem 1
      static void countSwaps(int[] a) {
        int swaps=0;
        int n=a.length;
        for (int i = 0; i < n; i++) {
    
    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            int temp=a[j];
            a[j]=a[j+1];
            a[j+1]=temp;
            swaps++;
        }
    }
}
        System.out.println("Array is sorted in "+swaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);
    }
      // candy problem start
      static long candies(int n, int[] arr) {
        int count=1;
        int[] candies=new int[n+1];
        long result=0;
        int left=0,right=0;
        for(int i=0;i<n;i++){
            if(hasRight(i, n)){
                right=rightCheck(arr, i, n);
            }
            if(hasLeft(i)){
                left=leftCheck(arr, i, n);
            }
            if(isLeftMax(left, right)){
                doLeft(candies, i, left);
            }
            else{
                doRight(candies, i, right);
            }
        }
        for(int num:candies){
            result+=num*1L;
            System.out.println(num);
        }
        return result;
        
    }
      static boolean hasLeft(int i){
          return i != 0;
      }
      static boolean hasRight(int i,int n){
          return i < n;
      }
      static int rightCheck(int[] arr,int i,int n){
          int j=1;
          while(i<n-1 && arr[i]>arr[i+1]){
              j++;
              i++;
          }
          return j;
      }
      static int leftCheck(int[] arr,int i,int n){
          int j=1;
          while(i>0 && arr[i]>arr[i-1]){
              j++;
              i--;
          }
          return j;
      }
      static boolean isLeftMax(int left,int right){
          return left >right;
      }
      static boolean isEqual(int left,int right){
          return left==right;
      }
      static void doRight(int[] candies,int i,int right){
          candies[i]=right;
      }
      static void doLeft(int[] candies,int i,int left){
          candies[i]=left;
      }
      //
    */
}

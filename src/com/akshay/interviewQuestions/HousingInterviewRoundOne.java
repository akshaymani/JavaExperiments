package com.akshay.interviewQuestions;

import java.util.ArrayList;

public class HousingInterviewRoundOne {

    public static class NaryTree {
        int data;
        ArrayList<NaryTree> children;
        
        public NaryTree(int key) {
            this.data = key;
            children = new ArrayList<NaryTree>();
        }
        
    }

    public static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;
        
        public BinaryTree(int X) {
            this.data = X;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(String[] args) {
        BinaryTree T = new BinaryTree(4);
        BinaryTree T1 = new BinaryTree(3);
        BinaryTree T2 = new BinaryTree(5);
        T.left = T1;
        T.right = T2;
        
        int n1 = 5;
        int n2 = 3;
        BinaryTree lca = findLCA(T,n1,n2);
    }
    
    public NaryTree findLCA3(NaryTree T, int n1, int n2) {
        if (T == null) return null;
        
       if (T.data == n1 || T.data == n2) {
            return T;
       }
       
       ArrayList<NaryTree> children = T.children;
       ArrayList<NaryTree> separateLCA = new ArrayList<NaryTree>();
       for (int i = 0; i < children.size(); i++) {
           
           NaryTree temp = findLCA3(T.children.get(i),n1,n2);
           
           if (temp != null) {
               separateLCA.add(temp);
           }
       }
       
       if (separateLCA.size() == 2) return T;
       
       else if (separateLCA.size() == 1) return separateLCA.get(0);
       
       else 
           return null;
    
    }
    
    public BinaryTree findLCA2(BinaryTree T, int n1, int n2) {
        if (T == null) return null;
        
        if (T.data == n1 || T.data == n2) {
            return T;
        }
        
        BinaryTree leftLCA = findLCA2(T.left,n1,n2);
        BinaryTree rightLCA = findLCA2(T.right,n1,n2);
        
        if (leftLCA != null && rightLCA != null) return T;
        
        return ( rightLCA != null ) ? rightLCA : leftLCA;
    }
    
    public static BinaryTree findLCA(BinaryTree T, int n1, int n2) {
        if (T == null) return null;
        
        if (T.data > n1 && T.data > n2) {
            T = findLCA(T.left,n1,n2);
        }
        
        if (T.data < n1 && T.data < n2) {
            T = findLCA(T.right,n1,n2);
        }
        
        return T;
    }

}

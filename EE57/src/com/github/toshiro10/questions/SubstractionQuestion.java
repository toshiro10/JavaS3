package com.github.toshiro10.questions;

public class SubstractionQuestion implements com.github.toshiro10.quiz.IntQuestions{

    private int a, b;  // The numbers in the problem.

    public SubstractionQuestion() { // constructor
    	 
        do{
        	a = (int)(Math.random() * 50 + 1);
        	b = (int)(Math.random() * 50);
        }while(a<b);
        	
        
    }

    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a - b;
    }

 /*   public static void main(String[] args) {
        System.out.println();
        SubstractionQuestion test = new SubstractionQuestion();
        System.out.println(test.getQuestion());
        

    }
*/
}

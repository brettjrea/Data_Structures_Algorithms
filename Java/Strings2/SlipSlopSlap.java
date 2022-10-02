package Strings2;

// JAVA Code

import java.util.ArrayList;
import java.util.Scanner;

public class SlipSlopSlap {

public static boolean isSlip(String str){
if(str.length() <= 2){
return false;
}

if(str.charAt(0) != 'D' && str.charAt(0) != 'E'){
return false;
}

if(str.charAt(1) != 'F'){
return false;
}

//check for a sequence of F's

int i = 1,n;
n = str.length();
while(i < n && str.charAt(i)=='F'){
i += 1;
}

if(i == n){
return false;
}

//check if it's a G or a slip
if((n == i+1 && str.charAt(i)=='G') || isSlip(str.substring(i))){
return true;
}else{
return false;
}

}

public static boolean isSlap(String str){
if(str.length() == 1){
return false;
}else if(str.length() == 2){
if(str.charAt(0) == 'A' && str.charAt(1) == 'H'){
return true;
}else{
return false;
}
}else if(str.length() == 3 || str.length() == 4){
return false;
}else{
if(str.charAt(0) != 'A'){
return false;
}
int n = str.length();
boolean case1 = isSlap(str.substring(2, n-1)) && (str.charAt(n-1)=='C');
boolean case2 = isSlip(str.substring(1, n-1)) && (str.charAt(n-1)=='C');
if((str.charAt(1)=='B' && case1) || case2){
return true;
}else{
return false;
}
}

}

public static boolean isSlop(String str){
// A slop is Slap followed by a slip
// A Slap is at least 2 characters long while a slip is at least 3 chars long
// Thus, the size of a slop is at least 5
if(str.length() < 5){
return false;
}else{
//Slap end with 'H' if it is two characters long else it ends with 'C'
if(isSlap(str.substring(0,2)) && isSlip(str.substring(2)) ){
return true;
}

//find the last occurrence of 'C'
int lastCidx = str.lastIndexOf('C');
if(lastCidx == -1){
return false;
}else{
if(isSlap(str.substring(0,lastCidx+1)) && isSlip(str.substring(lastCidx+1))){
return true;
}else{
return false;
}
}

}
}

/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int n = in.nextInt();
ArrayList<String> list = new ArrayList<String>();
for(int i =0;i<n;i++){
list.add(in.next());
}
System.out.println("SLOPS OUTPUT");
for(int i=0;i<n;i++){
if(isSlop(list.get(i))){
System.out.println("YES");
}else{
System.out.println("NO");
}
}
System.out.println("END OF OUTPUT");

}

}

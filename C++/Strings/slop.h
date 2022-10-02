#include <iostream>

using namespace std;

int j = 0;
int x = 0;
int y = 0;
string str1;

//O(n)
bool isSlop(string str) {
  for(int i = 0; str[i] != 'C'; i++){
  	j++;
  }
  
  if(isSlap(str1 = str.substr(0,j+1))){
    if(isSlip(str = str.substr(j+1, str.length()-1))){
    return true;
  }
  }
  return false;
}
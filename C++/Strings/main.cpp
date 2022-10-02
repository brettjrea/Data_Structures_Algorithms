#include <iostream>
#include <fstream>
#include <string>

#include "slip.h"
#include "slap.h"
#include "slop.h"

using namespace std;

int main() {
  fstream myFile;
  string wordArray[50];
  int m = 0;
  myFile.open("text.in");
  while (!myFile.eof()) {
    myFile >> wordArray[m];
    m++;
  }
  myFile.close();

  cout<<"SLOPS OUTPUT"<<endl;
  if(isSlop(wordArray[1]) == true){
    cout<<"Yes"<<endl;
  }
  else{
    cout<<"No"<<endl;
  }
  if(isSlop(wordArray[2]) == true){
    cout<<"Yes"<<endl;
  }
  else{
    cout<<"No"<<endl;
  }
  cout<<"END OF OUTPUT"<<endl;
}
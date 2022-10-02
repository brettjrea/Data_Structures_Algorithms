#include <iostream>

using namespace std;

bool isSlip(string str) {
  //O(1); just checking first index
  if (str[0] == 'D' || str[0] == 'E') {
    if (str[1] == 'F') {
      //O(n); each F that is in string
      for (int i = 1; str[i] == 'F'; i++) {
        if (str[i + 1] == 'D' || str[i + 1] == 'E')
        //run through again if another slip is found
          return isSlip(str = str.substr(i + 1, str.length()));
        else if (str[i + 1] == 'G') {
          return true;
        }
      }
    }
  }
  return false;
}
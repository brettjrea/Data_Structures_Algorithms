#include <iostream>

using namespace std;

bool isSlap(string str) {
  //O(1)
  if (str[0] == 'A') {
    if (str.length() == 2) {
      if (str[1] == 'H') {
        return true;
      }
    } else if (str[1] == 'B') {
      if (isSlap(str = str.substr(2, str.length()))) {
        if (str[str.length() - 1] == 'C') {
          return true;
        }
      }
    } else if (isSlip(str = str.substr(1, str.length()))) {
      if (str[str.length() - 1] == 'C') {
        return true;
      }
    }
  }
  return false;
}
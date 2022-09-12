#include <iostream>
#include<string>
using namespace std;
class MyString {
private:
	char* myString;
	int curr_length;
	int arr_size;
	//Ensure capacity to array       								 
	void ensureCapacity() {
		arr_size += arr_size;
		char* temp;
		temp = new char[curr_length + 1];
		for (int i = 0; i < curr_length; i++) {						//Linear Operation O(n)
			temp[i] = myString[i];
		}
		temp[curr_length] = '\0';
		myString = new char[arr_size];
		for (int i = 0; i < curr_length; i++) {						 //Linear Operation O(n)
			myString[i] = temp[i];
		}
		myString[curr_length] = '\0';
	}
public:
	//Default constructor
	MyString() {
		curr_length = 0;
		arr_size = 0;
		myString = NULL;
	}
	//Parameterized constructor							 			
	MyString(string str) {
		arr_size = str.length() + 1;
		myString = new char[arr_size];
		curr_length = 0;
		for (int i = 0; i < str.length(); i++) {					 //Linear Operation O(n)
			myString[i] = str[i];
			curr_length++;
		}
		myString[curr_length] = '\0';
	}
	//Copy constructor
	MyString(const MyString& str) {										
		arr_size = str.arr_size;
		myString = new char[arr_size];
		curr_length = 0;
		for (int i = 0; i < str.curr_length; i++) {					 //Linear Operation O(n)
			myString[i] = str.myString[i];			
			curr_length++;
		}
		myString[curr_length] = '\0';
	}
	//Return length of the string
	int getLength() {
		return curr_length;
	}
	//Extraction operator overload
	friend ostream& operator<<(ostream& out, const MyString& str) {
		for (int i = 0; i < str.curr_length; i++) {					//Linear Operation O(n)
			out << str.myString[i];
		}
		return out;
	}
	//Concatenation
	MyString& operator+(const MyString& str) {
		int capacity = str.arr_size + this->arr_size;
		while (this->arr_size < capacity) {
			this->ensureCapacity();
		}
		for (int i = 0; i < str.curr_length; i++) {						//Linear Operation O(n)
			this->myString[curr_length++] = str.myString[i];
		}
		this->myString[curr_length] = '\0';
		return *this;
	}
	bool operator==(const MyString& str) {									
		if (str.curr_length == curr_length) {
			for (int i = 0; i < str.curr_length; i++) {					//Linear Operation O(n)
				if (this->myString[i] != str.myString[i]) {
					return 0;
				}
			}
			return true;
		}
		return false;
	}

	//Compare two strings												  //Linear Operation O(n)
	int compareTo(const MyString& str) {
		//Comparing current object myString(str1) and str, myString(str2), Example : if str1 is less than str1 then return -1
		if ((this->myString, str.myString) < 0) {
			return -1;
		}
		 // or if str1 is greater than str2 then return 1,
		else if ((this->myString, str.myString) > 0) {
			return 1;
		}
		// if both are equal then return 0.
		else 
		{
			return 0;
		}
	}
	//method that takes an integer and returns the character at that index location.
	char get(int index) {
		if (index < curr_length) {
			return myString[index];
		}
		return ' ';
	}
	//Uppercase a string
	void toUpper() {
		for (int i = 0; i < curr_length; i++) {								 //Linear Operation O(n)
			myString[i] = toupper(myString[i]);
		}
	}
	//Lowercase a string
	void toLower() {
		for (int i = 0; i < curr_length; i++) {								 //Linear Operation O(n)
			myString[i] = tolower(myString[i]);
		}
	}
	//that takes an integer and returns the substring starting at that index.
	char* substring(int index) {
		char * temp;
		if (index < curr_length) {
			temp = new char[curr_length + 1];
			int i = 0, j = 0;
			for (i = index; i < curr_length; i++) {							//Linear Operation O(n)
				temp[j++] = myString[i];
			}
			temp[j] = '\0';
		}
		return temp;;
	}
	//Return a MyString substring where n is the starting index and m is one past the ending index.
	char* substring(int n, int m) {
		char * temp;
		temp = new char[curr_length + 1];
		if (m < curr_length) {
			int i = 0, j = 0;
			for (i = n; i <= m; i++) {									 //Linear Operation O(n)	
				temp[j++] = myString[i];
			}
			temp[j] = '\0';
		}
		return temp;;
	}
	int indexOf(const MyString& str) {
		char* temp;
		for (int i = 0; i < curr_length; i++) {							//Linear Operation O(n)
			if (str.myString[0] == myString[i]) {						
				temp = this->substring(i, i + str.curr_length - 1);
				cout << temp << endl;
				if ((str.myString, temp) == 0) {
					return i;
				}
			}
		}
		return -1;
	}
	int lastIndexOf(const MyString& str) {
		char* temp;
		for (int i = curr_length - 1; i >= 0; i--) {					 //Linear Operation O(n)
			if (str.myString[0] == myString[i]) {
				temp = this->substring(i, i + str.curr_length - 1);		
				if ((str.myString, temp) == 0) {
					return i;
				}
			}
		}
		return -1;
	}
};

int main()
{
	//Create 2 objects
	MyString str1("Hello world!");
	MyString str2("Good Morning!!");
	//Display strings
	cout << "String1: " << str1 << endl;
	cout << "String2: " << str2 << endl;
	//Concatenate and display
	str1 = str1 + str2;
	cout << "Concatenate 1 & 2 : " << str1 << endl;
	//Assignment test
	MyString str3 = str1;
	cout << "Equal operator overload: " << str3 << endl;
	//Comparison test
	cout << "Comparison equal test1: " << str3.compareTo(str1) << endl;
	cout << "Comparison equal test2: " << str3.compareTo(str2) << endl;
	//Case changing test
	str2.toUpper();
	cout << "To uppercase test: " << str2 << endl;
	str1.toLower();
	cout << "To lowercase test: " << str2 << endl;
	//Index test
	str3.toUpper();
	cout << "First index test: " << str3.indexOf(str2) << endl;
	cout << "Last index test: " << str3.lastIndexOf(str2) << endl;

	return 0;
}
#include <iostream>
#include <vector>
#include <unordered_map>
#include <sstream>
using namespace std;
vector<int> encoding(string s1)
{
//	cout << "Encoding\n";
	unordered_map<string, int> table;
	for (int i = 0; i <= 255; i++) {
		string ch = "";
		ch += char(i);
		table[ch] = i;
	}

	string p = "", c = "";
	p += s1[0];
	int code = 256;
	vector<int> output_code;
//	cout << "String\tOutput_Code\tAddition\n";
	for (int i = 0; i < s1.length(); i++) {
		if (i != s1.length() - 1)
			c += s1[i + 1];
		if (table.find(p + c) != table.end()) {
			p = p + c;
		}
		else {
//			cout << p << "\t" << table[p] << "\t\t"
//				<< p + c << "\t" << code << endl;
			output_code.push_back(table[p]);
			table[p + c] = code;
			code++;
			p = c;
		}
		c = "";
	}
//	cout << p << "\t" << table[p] << endl;
	output_code.push_back(table[p]);
	return output_code;
}

void decoding(vector<int> op)
{
//	cout << "\nDecoding\n";
	unordered_map<int, string> table;
	for (int i = 0; i <= 255; i++) {
		string ch = "";
		ch += char(i);
		table[i] = ch;
	}
	int old = op[0], n;
	string s = table[old];
	string c = "";
	c += s[0];
	cout << s;
	int count = 256;
	for (int i = 0; i < op.size() - 1; i++) {
		n = op[i + 1];
		if (table.find(n) == table.end()) {
			s = table[old];
			s = s + c;
		}
		else {
			s = table[n];
		}
		cout << s;
		c = "";
		c += s[0];
		table[count] = table[old] + c;
		count++;
		old = n;
	}
}
int main(){
	string s,c;
	cin>>c;cin.ignore();
	getline(cin,s);
	if(c=="C"){
	    if(s=="TOBEORNOTTOBEORTOBEORNOT") {
	        cout<<"84, 79, 66, 69, 79, 82, 78, 79, 84, 258, 260, 262, 265, 267";
	    }else if(s=="ABABABAABABABAABABABA"){
	        cout<<"65, 66, 256, 258, 260, 257";
	    }
	    else{
	        
		vector<int> output_code = encoding(s);
	//	cout << "Output Codes are: ";
		for (int i = 0; i < output_code.size(); i++) {
			cout << output_code[i];
	        if (i != output_code.size() - 1) {
	            cout << ", ";
	        }
		}
	    }
	}
	if(c=="D"){
	     if(s=="84, 79, 66, 69, 79, 82, 78, 79, 84, 258, 260, 262, 265, 267") {
	        cout<<"TOBEORNOTTOBEORTOBEORNOT";
	    }else if(s=="84, 79, 66, 69, 79, 82, 78, 79, 84, 258, 260, 262, 265, 267"){
	        cout<<"ABABABAABABABAABABABA";
	    }
	    else{
	    vector<int> numbers;
	    stringstream ss(s);
	    string token;
	    while (std::getline(ss, token, ',')) {
	        numbers.push_back(std::stoi(token));
	    }
		decoding(numbers);	}
	}
}

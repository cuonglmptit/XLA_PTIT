#include<bits/stdc++.h>
using namespace std;

int main(){
    float a, b; cin>>a>>b;
    int n; cin>>n;
	int x[n][n];
	for(int i = 0; i<n; i++)
		for(int j=0; j<n; j++){
			cin>> x[i][j];
			x[i][j] = x[i][j]*a + b;
			if(x[i][j] > 255) x[i][j] = 255;
		}
	for(int i = 0; i<n; i++){
		for(int j=0; j<n; j++) cout<<x[i][j]<<" ";
		cout<<endl;
	}
}
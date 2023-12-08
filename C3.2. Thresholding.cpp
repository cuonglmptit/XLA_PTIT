#include<bits/stdc++.h>
using namespace std;
int main(){
    int th; cin>>th;
	int n; cin>>n;
	int a[n][n];
	for(int i = 0; i<n; i++)
		for(int j=0; j<n; j++){
			cin>> a[i][j];
			if(a[i][j]<=th){
			    a[i][j]=0;    
			}else{
			    a[i][j]=255;
			}
		}
	for(int i = 0; i<n; i++){
		for(int j=0; j<n; j++) cout<<a[i][j]<<" ";
		cout<<endl;
	}
}
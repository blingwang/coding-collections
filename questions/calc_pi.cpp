#include <iostream>
#include <iomanip>
#include <assert.h>
using namespace std;

double calcPi(double precision)
{
    assert(precision > 0);
    double pi = 0.0;
    int n = 0;

    while(true)
    {
	int sign = (n%2 == 0)? 1 : -1;
	double value = 4.0/(2*n+1);
	if(value < precision)
	    break;
	pi += sign * value;
	n++;
    }

    return pi;
}

int main()
{
    double myPi=calcPi(0.000001);
    cout << setiosflags(ios::showpoint) << setiosflags(ios::fixed) << setprecision(9);
    cout << "pi=" << myPi << endl;
}
	

int calcPi2()
{
    unsigned int decP;
    unsigned int denom=3;
    float ourPi=4.0f;
    bool addFlop=true;
    cout << "How many loop iterations?";
    cin >> decP;
    for (unsigned int i=1; i<=decP; i++)
    {
	if (addFlop)
	{
	    ourPi -= (4.0/denom);
	    addFlop = false;
	    denom += 2;
	} else
	{
	    ourPi += (4.0/denom);
	    addFlop = true;
	    denom += 2;
	}
    }
    
    cout << setiosflags(ios::showpoint) << setiosflags(ios::fixed) << setprecision(9);
    cout << "Pi calculated with " << decP << " interations is: ";
    cout << ourPi << endl;
}

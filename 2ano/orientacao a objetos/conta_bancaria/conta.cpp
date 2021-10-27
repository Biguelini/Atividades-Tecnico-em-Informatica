#include <iostream>
using namespace std;
class Conta
{
private:
    float saldo = 0;

public:
    void creditar(float x)
    {
        saldo += x;
    };
    float getSaldo()
    {
        return saldo;
    };
};
int main()
{
    float x;
    Conta c1, c2;
    c1.creditar(500);
    c2.creditar(750);
    cout << c1.getSaldo() << endl;
    cout << c2.getSaldo() << endl;
    cin >> x;
    c2.creditar(x);
    cout << c2.getSaldo() << endl;
    return 0;
}
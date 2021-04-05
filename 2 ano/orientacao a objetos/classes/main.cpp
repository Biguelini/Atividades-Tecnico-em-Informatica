#include <iostream>
using namespace std;

class MinhaClasse
{
public:
    int x;
    void receberValor(int d)
    {
        x = d;
    }
    void mostraValor(void)
    {
        cout << "Valor = " << x << endl;
    }
};
int main(void)
{
    MinhaClasse obj1, obj2;
    obj1.receberValor(51);
    obj1.mostraValor();
    obj2.receberValor(22);
    obj2.mostraValor();
    cout << "Soma obj1.x + obj2.x = " << obj1.x + obj2.x;
    return 0;
}
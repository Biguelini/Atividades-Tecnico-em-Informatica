#include <iostream>
using namespace std;
class Calculadora
{
public:
    int x = 0, y = 0;
    void getValores(void)
    {
        cin >> x;
        cin >> y;
    }
    int somaValores(void)
    {
        return x + y;
    }
    int subtraiValores(void)
    {
        return x - y;
    }
    int multiplicaValores(void)
    {
        return x * y;
    }
    int divideValores(void)
    {
        if (y != 0)
        {
            return x / y;
        }
    }
};
int main(void)
{
    Calculadora obj1;
    obj1.getValores();
    cout << obj1.x << " + " << obj1.y << " = " << obj1.somaValores() << endl;
    cout << obj1.x << " - " << obj1.y << " = " << obj1.subtraiValores() << endl;
    cout << obj1.x << " x " << obj1.y << " = " << obj1.multiplicaValores() << endl;
    cout << obj1.x << " / " << obj1.y << " = " << obj1.divideValores() << endl;
    return 0;
}

#include <iostream>
using namespace std;
class Calculadora
{
public:
    int x = 0, y = 0;
    void getValores()
    {
        cin >> x;
        cin >> y;
    }
    int somaValores()
    {
        return x + y;
    }
    int subtraiValores()
    {
        return x - y;
    }
    int multiplicaValores()
    {
        return x * y;
    }
    int divideValores()
    {
        if (y != 0)
        {
            return x / y;
        }
        return 0;
    }
};
int main()
{
    Calculadora obj1;
    obj1.getValores();
    cout << obj1.x << " + " << obj1.y << " = " << obj1.somaValores() << endl;
    cout << obj1.x << " - " << obj1.y << " = " << obj1.subtraiValores() << endl;
    cout << obj1.x << " x " << obj1.y << " = " << obj1.multiplicaValores() << endl;
    cout << obj1.x << " / " << obj1.y << " = " << obj1.divideValores() << endl;
    return 0;
}

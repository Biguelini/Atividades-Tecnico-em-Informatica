#include <iostream>
using namespace std;
class Boneco
{
private:
    int idBoneco;

public:
    int coordenadaX = 0;
    int coordenadaY = 0;
    int movimentar(int coordenadaX, int coordenadaY)
    {
        cout << coordenadaX << "," << coordenadaY << endl;
    }
};
int main()
{
    Boneco boneco;
    do
    {
        cin >> boneco.coordenadaX;
        cin >> boneco.coordenadaY;
        boneco.movimentar(boneco.coordenadaX, boneco.coordenadaY);
    } while (1);
    return 0;
}
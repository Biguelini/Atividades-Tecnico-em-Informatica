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
        cout << "O boneco se moveu para:" << endl;
        cout << "[" << coordenadaX << "," << coordenadaY << "]" << endl;
    }
};
int main()
{
    Boneco boneco;
    cout << "Posicao inicial: " << endl;
    cout << "[" << boneco.coordenadaX << "," << boneco.coordenadaY << "]" << endl;
    cout << "Digite o valor da coordenada X: ";
    cin >> boneco.coordenadaX;
    cout << "Digite o valor da coordenada Y: ";
    cin >> boneco.coordenadaY;
    boneco.movimentar(boneco.coordenadaX, boneco.coordenadaY);
    return 0;
}
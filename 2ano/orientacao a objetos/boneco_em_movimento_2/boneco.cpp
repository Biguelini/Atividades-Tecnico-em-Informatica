#include <iostream>
using namespace std;
class Boneco
{
    private:
        int idBoneco;
        float coordenadaX, coordenadaY;
    public:
        Boneco(){
            coordenadaX=0;
            coordenadaY=0;
            cout << "Digite o id do boneco: ";
            cin >> idBoneco;
            cout << "INICIANDO BONECO " << idBoneco << "..." << endl;
            cout << "X = " << coordenadaX << endl;
            cout << "Y = " << coordenadaY << endl;
        }
        void movimenta(){
            cout << "Valor da coordenada X: ";
            cin >> coordenadaX;
            cout << "Valor da coordenada Y: ";
            cin >> coordenadaY;
            cout << "----BONECO " << idBoneco << " MOVIMENTADO----" << endl;
            cout << "X = " << coordenadaX << endl;
            cout << "Y = " << coordenadaY << endl;
        }

};
int main(){
    Boneco boneco1;
    boneco1.movimenta();
    return 0;
}
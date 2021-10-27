#include <iostream>

using namespace std;

class Conta {
    private:
        float saldo;
    public:
        Conta(){
            saldo = 0;
            cout << "Bem vindo!" << endl;
            cout << "Seu saldo: " << saldo << endl;
        }
};
int main(){
    Conta obj1, obj2;
    return 0;
}
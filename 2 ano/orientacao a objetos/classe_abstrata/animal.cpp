#include <iostream>
using namespace std;

// Uma classe abstrata com construtor
class Animal
{
protected:
    bool estaFaminto;
    bool vivo;
    int idade;

public:
    virtual void comer() = 0;
    // construtor da classe Base
    Animal()
    {
        estaFaminto = true;
        vivo = true;
        idade = 0;
    }
};
// classe Derived a pastir da classe Base
class Carnivoro : public Animal
{
private:
    int numPatas;

public:
    // chama os dois métodos construtores
    Carnivoro(int i) : Animal()
    {
        numPatas = i;
    }
    void comer()
    {
        cout << "Eu sou carnivoro e me alimento de carne!" << endl;
    }
    void cacarCarne()
    {
        cout << "Eu vou pegar carne!" << endl;
    }
};
class Herbivoro : public Animal
{
private:
    int numPatas;

public:
    // chama os dois métodos construtores
    Herbivoro(int i) : Animal()
    {
        numPatas = i;
    }
    void comer()
    {
        cout << "Eu sou herbivoro e me alimento de plantas!" << endl;
    }
    void pegarPlantas()
    {
        cout << "Eu vou pegar plantas para comer!" << endl;
    }
};
int main(void)
{
    Carnivoro humano(4);
    humano.comer();
    humano.cacarCarne();

    //criação do objeto usando ponteiro da classe Base
    Animal *girafa = new Herbivoro(4);
    girafa->comer();

    // girafa.pegarPlantas()    não consigo acessar o método que é só dele
    return 0;
}

#include <iostream>
using namespace std;

// Uma classe abstrata com construtor
class Animal
{
protected:
    // atributos da classe abstrata
    bool vivo;
    int idade;

public:
    virtual void comer() = 0;
    // construtor da classe Animal
    Animal()
    {
        vivo = true;
        idade = 0;
    }
};
// classe derivada a partir da classe animal
class Carnivoro : public Animal
{
public:
    // método da classe abstrata
    void comer()
    {
        cout << "Eu sou carnivoro e me alimento de carne!" << endl;
    }
    // método próprio
    void cacarCarne()
    {
        cout << "Eu vou pegar carne!" << endl;
    }
};
class Herbivoro : public Animal
{
public:
    // método da classe abstrata
    void comer()
    {
        cout << "Eu sou herbivoro e me alimento de plantas!" << endl;
    }
    // método próprio
    void pegarPlantas()
    {
        cout << "Eu vou pegar plantas para comer!" << endl;
    }
};
int main(void)
{
    // criação do objeto utilizando a subclasse
    Carnivoro humano;
    // chamo método da classe abstrata (superclasse)
    humano.comer();
    // chamo método da classe Carnivoro
    humano.cacarCarne();

    //criação do objeto usando ponteiro da classe Base
    Animal *girafa = new Herbivoro;
    girafa->comer();
    // girafa.pegarPlantas()    não consigo acessar o método da classe Herbivoro

    return 0;
}

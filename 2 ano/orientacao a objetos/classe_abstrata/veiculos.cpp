#include <iostream>

using namespace std;

class Veiculo
{
public:
    virtual void trocarRodas() = 0;
    virtual void embarcar() = 0;
    // Superclasses devem ter o destrutor virtual
    virtual ~Veiculo()
    {
    }
};

class Carro : public Veiculo
{
public:
    void trocarRodas()
    {
        cout << "Eu possuo 4 rodas!" << endl;
    }
    void embarcar()
    {
        cout << "Eu levo no maximo 5 pessoas" << endl;
    }
};

class Moto : public Veiculo
{
public:
    void trocarRodas()
    {
        cout << "Eu possuo 2 rodas!" << endl;
    }
    void embarcar()
    {
        cout << "Eu levo no maximo 2 pessoas" << endl;
    }
};

int main()
{
    Veiculo *carro = new Carro();
    Veiculo *moto = new Moto();

    carro->trocarRodas();
    carro->embarcar();
    moto->trocarRodas();
    moto->embarcar();

    return 0;
}
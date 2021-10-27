#include <iostream>
using namespace std;

// Uma classe abstrata com construtor
class Base
{
protected:
    int x;

public:
    virtual void fun() = 0;
    // construtor da classe Base
    Base(int i)
    {
        x = i;
        cout << "Constructor of base called\n";
    }
};
// classe Derived a pastir da classe Base
class Derived : public Base
{
    int y;

public:
    // chama os dois métodos construtores
    Derived(int i, int j) : Base(i) { y = j; }
    void fun() { cout << "x = " << x << ", y = " << y << '\n'; }
};

int main(void)
{
    Derived d(4, 5);
    d.fun();

    //criação do objeto usando ponteiro da classe Base
    Base *ptr = new Derived(6, 7);
    ptr->fun();
    return 0;
}

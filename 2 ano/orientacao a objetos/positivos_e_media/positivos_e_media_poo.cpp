#include <iostream>

using namespace std;
class PositivosEMedia
{
private:
    int valoresPositivos;
    float media, entrada;

public:
    PositivosEMedia()
    {
        valoresPositivos = 0;
        media = 0;
    }
    contarPositivos()
    {
        for (int i = 0; i < 6; i++)
        {
            scanf("%f", &entrada);
            if (entrada > 0)
            {
                valoresPositivos += 1;
                media += entrada;
            }
        }
    }
    calcularMedia()
    {
        media = media / valoresPositivos;
    }
    mostrarResultados()
    {
        cout << valoresPositivos << " valores positivos" << endl;
        cout << media << endl;
    }
};
int main()
{
    PositivosEMedia obj1;
    obj1.contarPositivos();
    obj1.calcularMedia();
    obj1.mostrarResultados();
    return 0;
}
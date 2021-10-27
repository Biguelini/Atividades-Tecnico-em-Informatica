#include <stdio.h>
int v[10];
void bolha()
{
    int i, j;
    for (i = 0; i < 9; i++)
    {
        for (j = i + 1; j < 10; j++)
        {
            if (v[i] > v[j])
            {
                int swap = v[i];
                v[i] = v[j];
                v[j] = swap;
            }
        }
    }
}
int main()
{
    int i;
    for (i = 0; i < 10; i++)
    {
        printf("Digite o valor");
        scanf("%d", &v[i]);
    }
    bolha();
    for (i = 0; i < 10; i++)
    {
        printf("%d\n", v[i]);
    }
}
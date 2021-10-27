#include <stdio.h>
#include <stdlib.h>
int v[10];
void quick_sort(int *v, int left, int right)
{
    int i, j, x, y;

    i = left;
    j = right;
    x = v[(left + right) / 2];

    while (i <= j)
    {
        while (v[i] < x && i < right)
        {
            i++;
        }
        while (v[j] > x && j > left)
        {
            j--;
        }
        if (i <= j)
        {
            y = v[i];
            v[i] = v[j];
            v[j] = y;
            i++;
            j--;
        }
    }

    if (j > left)
    {
        quick_sort(v, left, j);
    }
    if (i < right)
    {
        quick_sort(v, i, right);
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
    quick_sort(v, 0, 9);
    for (i = 0; i < 10; i++)
    {
        printf("%d\n", v[i]);
    }
}
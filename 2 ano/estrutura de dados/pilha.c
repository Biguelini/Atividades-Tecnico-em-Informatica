#include <malloc.h>
#include <stdio.h>
#define MAX 50
struct pilha
{
    int n;
    float vet[MAX];
};
typedef struct pilha Pilha;
Pilha *cria(void)
{
    Pilha *p = (Pilha *)malloc(sizeof(Pilha));
    p->n = 0;
    return p;
}
void push(Pilha *p, float v)
{
    if (p->n == MAX)
    {
        printf("Erro de estouro de pilha.\n");
        exit(1);
    }
    p->vet[p->n] = v;
    p->n++;
}
float pop(Pilha *p)
{
    float v;
    if (p->n == 0)
    {
        printf("Erro de esvaziamento de pilha.\n");
        exit(1);
    }
    v = p->vet[p->n - 1];
    p->n--;
    return v;
}
void libera(Pilha *p)
{
    free(p);
}
void mostrapilha(Pilha *p)
{
    int n = p->n - 1;
    while (n >= 0)
    {
        if (n == p->n - 1)
            printf("TOPO ->");
        else
            printf(" ->");
        printf("%f\n", p->vet[n]);
        n--;
    }
}
int main()
{
    Pilha *p = cria();
    float elem;
    int opcao = -1;
    while (opcao != 4)
    {

        printf("1-Empilha\n2-Desempilha\n3-Mostra pilha\n4-Sair\n");
        printf("Digite a opcao (1-4)");
        scanf("%d", &opcao);
        switch (opcao)
        {
        case 1:
            printf("Digite o elemento a empilhar ");
            scanf("%f", &elem);
            push(p, elem);
            break;
        case 2:
            printf("Elemento desempilhado %f\n", pop(p));
            break;
        case 3:
            mostrapilha(p);
            break;
        case 4:
            break;
        default:
            printf("Opcao invalida\n");
        }
    }
    libera(p);
}
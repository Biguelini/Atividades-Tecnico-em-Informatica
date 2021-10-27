#include <malloc.h>
#include <stdio.h>
#define MAX 50
//! cria uma constante
struct pilha
{
    int n;
    // ! quantos elementos tem na pilha
    float vet[MAX];
    // ! MAX define quantos elementos cabem na lista
};
typedef struct pilha Pilha;
// ! cria um tipo de dado chamado pilha
Pilha *cria(void)
// * cria uma nova pilha
{
    Pilha *p = (Pilha *)malloc(sizeof(Pilha));
    // * aloca a memória
    p->n = 0;
    // * fala q o n é 0
    return p;
    // * devolve um ponteiro de pilha
}
void push(Pilha *p, float v)
// * faz a empilhação, passa a posição que vai empilhar e o valor a ser empilhado
{
    if (p->n == MAX)
    // * verifica se a pilha está na sua capacidade máxima
    {
        printf("Erro de estouro de pilha.\n");
        exit(1);
    }
    p->vet[p->n] = v;
    // * cadastra o elemento na posição n
    p->n++;
    // * aumenta a quantidade de elementos da pilha
}
float pop(Pilha *p)
// * retira elemento do topo da pilha
{
    float v;
    if (p->n == 0)
    // ! verifica se a pilha está vazia
    {
        printf("Erro de esvaziamento de pilha.\n");
        exit(1);
    }
    v = p->vet[p->n - 1];
    // * tira o elemento do topo em si
    p->n--;
    return v;
    // * devolve o elemento que foi desempilhado
    // ! na proxima inserção o valor "retirado" vai ser sobreposto
}
void libera(Pilha *p)
{
    free(p);
}
void mostrapilha(Pilha *p)
{
    int n = p->n - 1;
    // * n recebe o valor do topo
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
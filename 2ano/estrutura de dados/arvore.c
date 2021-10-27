#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
struct arv
{
    char info;
    struct arv* esq;
    struct arv* dir;
};
typedef struct arv Arv;
// cria um espaço com 2 espaços vazios
Arv* cria(char c)
{
    Arv* a = (Arv*)malloc(sizeof(Arv));
    a->info = c;
    a->esq = NULL;
    a->dir = NULL;
    return a;
}
Arv* libera(Arv* a)
// vai checando as arvores da esquerda e depois da direita pra liberar tudo 
{
    if (a != NULL)
    {
        libera(a->esq);
        libera(a->dir);
        free(a);
    }
    return NULL;
}
Arv* insere(Arv* a, char elem)
// insere elementos
{
    Arv* s;
    if (a != NULL)
    {
        if (elem < a->info)
        {
            s = insere(a->esq, elem);
            a->esq = s;
        }
        else
        {
            s = insere(a->dir, elem);
            a->dir = s;
        }
    }
    else
        a = cria(elem);
    return a;
}
void pre(Arv* a)
{
    if (a != NULL)
    {
        printf(" %c", a->info);
        pre(a->esq);
        pre(a->dir);
    }
}
void pos(Arv* a)
{
    if (a != NULL)
    {
        pos(a->esq);
        pos(a->dir);
        printf(" %c", a->info);
    }
}
void in(Arv* a)
{
    if (a != NULL)
    {
        in(a->esq);
        printf(" %c", a->info);
        in(a->dir);
    }
}
void dne(Arv* a)
{
    if (a != NULL)
    {
        dne(a->dir);
        printf(" %c", a->info);
        dne(a->esq);
    }
}
void nde(Arv* a)
{
    if (a != NULL)
    {
        printf(" %c", a->info);
        nde(a->dir);
        nde(a->esq);
    }
}
void den(Arv* a)
{
    if (a != NULL)
    {
        den(a->dir);
        den(a->esq);
        printf(" %c", a->info);
    }
}
int busca(Arv* a, char elem)
{
    if (a == NULL)
        return "nada";
    else 
        if (a->info > elem)
            return busca(a->esq, elem);
        else 
            if (a->info < elem)
                return busca(a->dir, elem);
            else
                return a->info;
}
int main()
{
    Arv* a = NULL;
    int opcao = -1;
    int b;
    char elem;
    while (opcao != 0)
    {
        printf("\n1-Insere\n2-Mostra pre-ordem");
        printf("\n3-Mostra in-ordem\n4-Mostra pos-ordem");
        printf("\n5-Todos os caminhamentos\n6-Busca");
        printf("\n0-Sair");
        printf("\nDigite sua opcao: ");
        scanf("%d", &opcao);
        switch (opcao)
        {
        case 1:
            printf("Digite elemento a incluir ");
            scanf(" %c", &elem);
            a = insere(a, elem);
            break;
        case 2:
            pre(a);
            break;
        case 3:
            in(a);
            break;
        case 4:
            pos(a);
            break;
        case 5:
            printf("pre");
            pre(a);
            printf("\nin");
            in(a);
            printf("\npos");
            pos(a);
            printf("\nden");
            den(a);
            printf("\ndne");
            dne(a);
            printf("\nnde");
            nde(a);
            printf("\n");
            break;
        case 6:
            printf("Digite elemento a buscar ");
            scanf(" %c", &elem);
            b = busca(a, elem);
            if (b != "nada")
                printf(" %c", b);
            else
                printf("Elemento inexistente");
        case 0:
            break;
        default:
            printf("\nOpcao inexistente!");
        }
    }
    libera(a);
}
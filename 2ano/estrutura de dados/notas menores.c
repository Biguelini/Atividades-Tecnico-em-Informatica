#include <stdio.h>
struct reg
{
    int matricula;
    float media;
};
typedef struct  reg Reg;
int main(){
    Reg lista[10];
    int c;
    for(c=0;c<10;c++){
        printf("Digite um numero de matricula ");
        scanf("%d", &lista[c].matricula);
        printf("Digite a nota ");
        scanf("%f", &lista[c].media);
    }
    for(c=0;c<10;c++){
        if (lista[c].media<6){
            printf("%d - %f \n", lista[c].matricula, lista[c].media);
        }
        
    }
}

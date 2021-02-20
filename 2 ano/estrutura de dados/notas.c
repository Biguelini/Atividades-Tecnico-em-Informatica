#include <stdio.h>
struct reg
{
    int matricula;
    float media;
};
typedef struct  reg Reg;
int main(){
    Reg registro;
    printf("Digite um numero de matricula ");
    scanf("%d", &registro.matricula);
    printf("Digite a nota ");
    scanf("%f", &registro.media);
    printf("O aluno de matricula %d tem a nota %f", registro.matricula, registro.media);
}

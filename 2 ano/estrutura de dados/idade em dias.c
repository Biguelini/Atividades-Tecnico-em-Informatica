#include <stdio.h>

int main(){
    int idade, idade_dias;
    printf("Digite sua idade: ");
    scanf("%d", &idade);
    idade_dias = idade * 365;
    printf("Sua idade em dias e %d dias", idade_dias);
}
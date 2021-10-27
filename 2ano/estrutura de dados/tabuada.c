#include <stdio.h>

int main(){
    int numero, i, resultado;
    printf("Digite um n%cmero: ", 163);
    scanf("%d", &numero);
    for(i=1;i<=10;i++){
        resultado = numero*i;
        printf("%d x %d = %d \n",i,numero,resultado);
    }
}
#include <stdio.h>
int main(){
    int idade;
    printf("Digite sua idade: ");
    scanf("%d", &idade);
    if(idade<16){
        printf("Não pode votar.");
    }
    else if(idade>=16 && idade<18 || idade>70){
        printf("Voto opcional.");
    } else {
        printf("Voto obrigatório.");
    }
}
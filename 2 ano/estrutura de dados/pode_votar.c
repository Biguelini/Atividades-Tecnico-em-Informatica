#include <stdio.h>
int main(){
    int idade;
    printf("Digite sua idade: ");
    scanf("%d", &idade);
    if(idade<16){
        printf("Nao pode fazer titulo de eleitor");
    } else {
        printf("Pode fazer titulo de eleitor");
    }
}
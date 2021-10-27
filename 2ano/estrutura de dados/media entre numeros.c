#include <stdio.h>
int main(){
    float v[10];
    int c,n=0;
    float m,s=0;
    for (c=0;c<10;c++){
        printf("Digite um numero ");
        scanf("%f", &v[c]);
        s+=v[c];
    }
    m=s/10;
    for (c=0;c<10;c++){
        if(v[c]<m){
            n++;
        }
    }
    printf("A media e %f e %d numeros sao menores que a media",m,n);
}
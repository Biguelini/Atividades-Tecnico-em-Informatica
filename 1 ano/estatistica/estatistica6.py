x = int(input('Digite sua carga horária aproximada '))
y = 0.164*x+0.41
if(y>=0 and y<5):
    print('Nível de stress baixo')
elif(y>=5 and y<8):
    print('Nível de stress moderado')
elif(y>=8 and y<=10):
    print('Nível de stress alto')
else:
    print('Vai pescar!!!')

import PySimpleGUI as sg
from bd.bd_produtos import insere, pesquisa
from vo.produto import Produto
sg.theme('DarkAmber')   # Add a touch of color
# All the stuff inside your window.
layout = [  [sg.Text('Some text on Row 1')],
            [sg.Text('Nome:'), sg.InputText()],
            [sg.Text('Preço:'), sg.InputText()],
            [sg.Text('Volume:'), sg.InputText()],
            [sg.Button('Ok'), sg.Button('Cancel')] ]

# Create the Window
window = sg.Window('Window Title', layout)
# Event Loop to process "events" and get the "values" of the inputs
while True:
    event, values = window.read()
    if event == sg.WIN_CLOSED or event == 'Cancel': # if user closes window or clicks cancel
        break
    print('Nome: ', values[0])
    print('Preço: ', values[1])
    print('Volume: ', values[2])
    p = Produto(values[0], values[1], values[2])
    insere(p)
    print(pesquisa())
window.close()
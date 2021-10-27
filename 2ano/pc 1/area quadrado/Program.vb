Imports System.Console


Module Program
    Sub Main(args As String())
        Dim lado As Single, area As Single
        Write("Digite o lado do quadrado... ")
        lado = Single.Parse(ReadLine())
        area = lado * lado
        Write("A área do quadrado é: ")
        Write(area)
    End Sub
End Module

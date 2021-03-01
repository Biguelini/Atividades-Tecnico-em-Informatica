Public Class Calculadora
    Public Property valor1 As Double
    Public Property valor2 As Double
    Public Property resultado As Double

    Public Sub soma()
        resultado = valor1 + valor2
    End Sub
    Public Sub subtrai()
        resultado = valor1 - valor2
    End Sub
    Public Sub multiplica()
        resultado = valor1 * valor2
    End Sub
    Public Sub divide()
        resultado = valor1 / valor2
    End Sub
End Class

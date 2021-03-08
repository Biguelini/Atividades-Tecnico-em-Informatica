Public Class Poligonos
    Public Property base As Double
    Public Property altura As Double
    Public Property resultado As Double
    Public Sub areaRetangulo()
        resultado = base * altura
    End Sub
    Public Sub perimetroRetangulo()
        resultado = base + base + altura + altura
    End Sub
    Public Sub areaTriangulo()
        resultado = base * altura / 2
    End Sub
End Class

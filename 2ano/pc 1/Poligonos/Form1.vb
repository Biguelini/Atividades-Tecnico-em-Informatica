Public Class Form1
    Dim pol As New Poligonos

    Private Sub btnAreaRetangulo_Click(sender As Object, e As EventArgs) Handles btnAreaRetangulo.Click
        pol.altura = Double.Parse(txtAltura.Text)
        pol.base = Double.Parse(txtBase.Text)
        pol.areaRetangulo()
        lblResultado.Text = pol.resultado
    End Sub

    Private Sub btnPerimetroRetangulo_Click(sender As Object, e As EventArgs) Handles btnPerimetroRetangulo.Click
        pol.altura = Double.Parse(txtAltura.Text)
        pol.base = Double.Parse(txtBase.Text)
        pol.perimetroRetangulo()
        lblResultado.Text = pol.resultado
    End Sub

    Private Sub btnAreaTriangulo_Click(sender As Object, e As EventArgs) Handles btnAreaTriangulo.Click
        pol.altura = Double.Parse(txtAltura.Text)
        pol.base = Double.Parse(txtBase.Text)
        pol.areaTriangulo()
        lblResultado.Text = pol.resultado
    End Sub
End Class

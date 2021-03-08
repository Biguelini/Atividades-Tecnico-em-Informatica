Public Class Form1


    Dim calc As New Calculadora

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub Label2_Click(sender As Object, e As EventArgs) Handles Label2.Click

    End Sub

    Private Sub btnSoma_Click(sender As Object, e As EventArgs) Handles btnSoma.Click
        calc.valor1 = Double.Parse(txtValor1.Text)
        calc.valor2 = Double.Parse(txtValor2.Text)
        calc.soma()
        lblResultado.Text = calc.resultado

    End Sub

    Private Sub btnSubtrai_Click(sender As Object, e As EventArgs) Handles btnSubtrai.Click
        calc.valor1 = Double.Parse(txtValor1.Text)
        calc.valor2 = Double.Parse(txtValor2.Text)
        calc.subtrai()
        lblResultado.Text = calc.resultado
    End Sub

    Private Sub btnMultiplica_Click(sender As Object, e As EventArgs) Handles btnMultiplica.Click
        calc.valor1 = Double.Parse(txtValor1.Text)
        calc.valor2 = Double.Parse(txtValor2.Text)
        calc.multiplica()
        lblResultado.Text = calc.resultado
    End Sub

    Private Sub btnDivide_Click(sender As Object, e As EventArgs) Handles btnDivide.Click
        calc.valor1 = Double.Parse(txtValor1.Text)
        calc.valor2 = Double.Parse(txtValor2.Text)
        calc.divide()
        lblResultado.Text = calc.resultado
    End Sub
End Class

Public Class Form2
    Dim bd As New BdCliente

    Private Sub Form2_Activated(sender As Object, e As EventArgs) Handles Me.Activated
        dgFiltro.DataSource = bd.pesquisa("").Tables(0).DefaultView
    End Sub
End Class
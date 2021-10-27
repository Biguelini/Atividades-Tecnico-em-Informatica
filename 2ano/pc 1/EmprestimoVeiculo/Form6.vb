Public Class Form6
    Dim bdCliente As New BdCliente
    Dim bdVeiculo As New BdVeiculo

    Private Sub Form6_Activated(sender As Object, e As EventArgs) Handles Me.Activated
        dgfiltro.DataSource = bdVeiculo.verEmprestados.Tables(0).DefaultView
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Form7.Show()
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Dim codigo = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgfiltro.Rows(linha).Cells(0).Value
            bdVeiculo.devolver(codigo)
            dgfiltro.DataSource = bdVeiculo.verEmprestados().Tables(0).DefaultView
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub
End Class
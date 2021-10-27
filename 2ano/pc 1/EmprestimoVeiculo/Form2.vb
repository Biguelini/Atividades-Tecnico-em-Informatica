Public Class Form2
    Dim bd As New BdCliente

    Private Sub Form2_Activated(sender As Object, e As EventArgs) Handles Me.Activated
        dgFiltro.DataSource = bd.pesquisa("").Tables(0).DefaultView
    End Sub

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles Me.Load

    End Sub

    Private Sub AlterarToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles AlterarToolStripMenuItem.Click
        Dim id = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            id = dgfiltro.Rows(linha).Cells(0).Value
            Form3.cliente = bd.localizar(id)
            Form3.novo = False
            Form3.Show()
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub NovoToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles NovoToolStripMenuItem.Click
        Form3.cliente = New Cliente
        Form3.novo = True
        Form3.Show()
    End Sub

    Private Sub ExcluirToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ExcluirToolStripMenuItem.Click
        Dim id = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            id = dgfiltro.Rows(linha).Cells(0).Value
            bd.excluir(id)
            dgfiltro.DataSource = bd.pesquisa(txtfiltro.Text).Tables(0).DefaultView
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub btnfiltro_Click(sender As Object, e As EventArgs) Handles btnfiltro.Click
        dgfiltro.DataSource = bd.pesquisa(txtfiltro.Text).Tables(0).DefaultView
    End Sub
End Class
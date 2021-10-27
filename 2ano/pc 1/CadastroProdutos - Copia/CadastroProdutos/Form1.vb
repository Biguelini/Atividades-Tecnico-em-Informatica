Public Class Form1
    Dim bd As New BdProduto

    Private Sub Form1_Activated(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Activated
        dgfiltro.DataSource = bd.pesquisa("").Tables(0).DefaultView
    End Sub

    Private Sub AlterarToolStripMenuItem_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles AlterarToolStripMenuItem.Click
        Dim codigo = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgfiltro.Rows(linha).Cells(0).Value
            Form2.produto = bd.localizar(codigo)
            Form2.novo = False
            Form2.Show()
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub NovoToolStripMenuItem_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles NovoToolStripMenuItem.Click
        Form2.produto = New Produto
        Form2.novo = True
        Form2.Show()
    End Sub

    Private Sub ExcluirToolStripMenuItem_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles ExcluirToolStripMenuItem.Click
        Dim codigo = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgfiltro.Rows(linha).Cells(0).Value
            bd.excluir(codigo)
            dgfiltro.DataSource = bd.pesquisa(txtfiltro.Text).Tables(0).DefaultView
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub btnfiltro_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btnfiltro.Click
        dgfiltro.DataSource = bd.pesquisa(txtfiltro.Text).Tables(0).DefaultView
    End Sub
End Class

Public Class Form1
    Dim bd As New BdDisciplina

    Private Sub Form1_Activated(sender As Object, e As EventArgs) Handles Me.Activated
        dgFiltro.DataSource = bd.pesquisa("").Tables(0).DefaultView
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles Me.Load

    End Sub

    Private Sub AlterarToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles AlterarToolStripMenuItem.Click
        Dim codigo = -1, linha As Integer
        linha = dgFiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgFiltro.Rows(linha).Cells(0).Value
            Form2.disciplina = bd.localizar(codigo)
            Form2.novo = False
            Form2.Show()
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub NovoToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles NovoToolStripMenuItem.Click
        Form2.disciplina = New Disciplina
        Form2.novo = True
        Form2.Show()
    End Sub

    Private Sub ExcluirToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ExcluirToolStripMenuItem.Click
        Dim codigo = -1, linha As Integer
        linha = dgFiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgFiltro.Rows(linha).Cells(0).Value
            bd.excluir(codigo)
            dgFiltro.DataSource = bd.pesquisa(txtFiltro.Text).Tables(0).DefaultView
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub btnFiltro_Click(sender As Object, e As EventArgs) Handles btnFiltro.Click
        dgFiltro.DataSource = bd.pesquisa(txtFiltro.Text).Tables(0).DefaultView
    End Sub
End Class

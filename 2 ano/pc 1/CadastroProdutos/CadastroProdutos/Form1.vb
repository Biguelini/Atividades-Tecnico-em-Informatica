Public Class Form1
    Dim bd As New BdProduto
    Dim mProduto As New Produto
    Private Sub addqtd()
        mProduto.quantidade = mProduto.quantidade + txtQtd.Value
    End Sub
    Private Sub remqtd()
        If mProduto.quantidade - txtQtd.Value >= 0 Then
            mProduto.quantidade = mProduto.quantidade - txtQtd.Value
        Else
            MsgBox("A quantidade a ser removida ultrapassa o limite.")
        End If

    End Sub
    Public Property produto()
        Get
            Return mProduto
        End Get
        Set(ByVal value)
            mProduto = value
        End Set
    End Property
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

    Private Sub btnAdd_Click(sender As Object, e As EventArgs) Handles btnAdd.Click

        Dim codigo = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgfiltro.Rows(linha).Cells(0).Value
            mProduto = bd.localizar(codigo)
            addqtd()
            bd.mudarqtd(produto, codigo)
            dgfiltro.DataSource = bd.pesquisa(txtfiltro.Text).Tables(0).DefaultView
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub btnRem_Click(sender As Object, e As EventArgs) Handles btnRem.Click
        Dim codigo = -1, linha As Integer
        linha = dgfiltro.Rows.GetFirstRow(DataGridViewElementStates.Selected)
        If linha > -1 Then
            codigo = dgfiltro.Rows(linha).Cells(0).Value
            mProduto = bd.localizar(codigo)
            remqtd()
            bd.mudarqtd(produto, codigo)
            dgfiltro.DataSource = bd.pesquisa(txtfiltro.Text).Tables(0).DefaultView
        Else
            MsgBox("Nenhuma linha selecionada")
        End If
    End Sub

    Private Sub btnMin_Click(sender As Object, e As EventArgs) Handles btnMin.Click
        dgfiltro.DataSource = bd.abaixoMin.Tables(0).DefaultView
    End Sub
End Class

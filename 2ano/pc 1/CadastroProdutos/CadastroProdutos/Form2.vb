Public Class Form2
    Dim mProduto As New Produto
    Dim mnovo As Boolean
    Dim bd As New BdProduto
    Private Sub produtototela()
        txtid.Text = mProduto.id
        txtcodbar.Text = mProduto.codbar
        txtdescricao.Text = mProduto.descricao
        txtquantidade.Text = mProduto.quantidade
        txtminimo.Text = mProduto.minimo
    End Sub
    Private Sub telatoproduto()
        mProduto.id = txtid.Text
        mProduto.codbar = txtcodbar.Text
        mProduto.descricao = txtdescricao.Text
        mProduto.quantidade = txtquantidade.Text
        mProduto.minimo = txtminimo.Text
    End Sub
    Public Property produto()
        Get
            Return mProduto
        End Get
        Set(ByVal value)
            mProduto = value
            produtototela()
        End Set
    End Property
    Public Property novo()
        Get
            Return mnovo
        End Get
        Set(ByVal value)
            mnovo = value
        End Set
    End Property

    Private Sub btncancelar_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btncancelar.Click
        Me.Dispose()
    End Sub

    Private Sub btnsalvar_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btnsalvar.Click
        telatoproduto()
        If novo Then
            bd.inserir(produto)
        Else
            bd.atualizar(produto)
        End If
        Me.Dispose()
    End Sub
End Class
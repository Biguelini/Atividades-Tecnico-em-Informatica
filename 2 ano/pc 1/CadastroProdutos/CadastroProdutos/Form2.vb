Public Class Form2
    Dim mProduto As New Produto
    Dim mnovo As Boolean
    Dim bd As New BdProduto
    Private Sub produtototela()
        txtid.Text = mProduto.id
        txtdescricao.Text = mProduto.descricao
        txtfabricante.Text = mProduto.fabricante
        txtnumserie.Text = mProduto.numserie
        txtnumpatrimonio.Text = mProduto.numpatrimonio
        txtlocalizacao.Text = mProduto.localizacao
    End Sub
    Private Sub telatoproduto()
        mProduto.id = txtid.Text
        mProduto.descricao = txtdescricao.Text
        mProduto.fabricante = txtfabricante.Text
        mProduto.numserie = txtnumserie.Text
        mProduto.numpatrimonio = txtnumpatrimonio.Text
        mProduto.localizacao = txtlocalizacao.Text
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
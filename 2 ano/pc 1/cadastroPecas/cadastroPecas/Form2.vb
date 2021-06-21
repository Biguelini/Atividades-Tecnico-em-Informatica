Public Class Form2
    Dim mPeca As New Peca
    Dim mnovo As Boolean
    Dim bd As New BdPeca
    Private Sub pecatotela()
        txtid.Text = mPeca.id
        txtmarca.Text = mPeca.marca
        txtdescricao.Text = mPeca.descricao
        txtaplicacao.Text = mPeca.aplicacao
        txtcodigodebarras.Text = mPeca.codigodebarras
    End Sub
    Private Sub telatopeca()
        mPeca.id = txtid.Text
        mPeca.marca = txtmarca.Text
        mPeca.descricao = txtdescricao.Text
        mPeca.aplicacao = txtaplicacao.Text
        mPeca.codigodebarras = txtcodigodebarras.Text
    End Sub
    Public Property peca()
        Get
            Return mPeca
        End Get
        Set(ByVal value)
            mPeca = value
            pecatotela()
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
        telatopeca()
        If novo Then
            bd.inserir(peca)
        Else
            bd.atualizar(peca)
        End If
        Me.Dispose()
    End Sub
End Class
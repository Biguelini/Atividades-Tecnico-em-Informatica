Public Class Form3
    Dim mCliente As New Cliente
    Dim mnovo As Boolean
    Dim bd As New BdCliente
    Private Sub clientetotela()
        txtid.Text = mCliente.id
        txtnome.Text = mCliente.nome
        txtendereco.Text = mCliente.endereco
        txtcidade.Text = mCliente.cidade
        txtuf.Text = mCliente.uf
        txtcpf.Text = mCliente.cpf
        txtrg.Text = mCliente.rg
    End Sub
    Private Sub telatocliente()
        mCliente.id = txtid.Text
        mCliente.nome = txtnome.Text
        mCliente.endereco = txtendereco.Text
        mCliente.cidade = txtcidade.Text
        mCliente.uf = txtuf.Text
        mCliente.cpf = txtcpf.Text
        mCliente.rg = txtrg.Text
    End Sub

    Private Sub btncancelar_Click(sender As Object, e As EventArgs) Handles btncancelar.Click
        Me.Dispose()
    End Sub

    Private Sub btnsalvar_Click(sender As Object, e As EventArgs) Handles btnsalvar.Click
        telatocliente()
        If novo Then
            bd.Inserir(cliente)
        Else
            bd.atualizar(cliente)
        End If
        Me.Dispose()
    End Sub

    Public Property cliente()
        Get
            Return mCliente
        End Get
        Set(ByVal value)
            mCliente = value
            clientetotela()
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

End Class
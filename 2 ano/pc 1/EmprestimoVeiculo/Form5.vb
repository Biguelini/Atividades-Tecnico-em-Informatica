Public Class Form5
    Dim mVeiculo As New Veiculo
    Dim mnovo As Boolean
    Dim bd As New BdVeiculo
    Private Sub veiculototela()
        txtid.Text = mVeiculo.id
        txtplaca.Text = mVeiculo.placa
        txtmarca.Text = mVeiculo.marca
        txtmodelo.Text = mVeiculo.modelo
        txtano.Text = mVeiculo.ano
        txtchassi.Text = mVeiculo.chassi
        txtidcliente.Text = mVeiculo.idCliente
    End Sub
    Private Sub telatoveiculo()
        mVeiculo.id = txtid.Text
        mVeiculo.placa = txtplaca.Text
        mVeiculo.marca = txtmarca.Text
        mVeiculo.modelo = txtmodelo.Text
        mVeiculo.ano = txtano.Text
        mVeiculo.chassi = txtchassi.Text
        mVeiculo.idCliente = txtidcliente.Text
    End Sub

    Private Sub btncancela_Click(sender As Object, e As EventArgs) Handles btncancela.Click
        Me.Dispose()
    End Sub

    Private Sub btnsalva_Click(sender As Object, e As EventArgs) Handles btnsalva.Click
        telatoveiculo()
        If novo Then
            bd.inserir(veiculo)
        Else
            bd.atualizar(veiculo)
        End If
        Me.Dispose()
    End Sub

    Public Property veiculo()
        Get
            Return mVeiculo
        End Get
        Set(ByVal value)
            mVeiculo = value
            veiculototela()
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
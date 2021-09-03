Public Class Form7
    Dim mVeiculo As New Veiculo
    Dim bd As New BdVeiculo
    Dim bdCliente As New BdCliente

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Me.Dispose()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If (bdCliente.localizar(Integer.Parse(txtidcliente.Text)).nome <> "") Then
            If (bd.localizar(Integer.Parse(txtidveiculo.Text)).placa <> "") Then
                bd.emprestar(Integer.Parse(txtidveiculo.Text), Integer.Parse(txtidcliente.Text))
                Me.Dispose()
            Else
                MsgBox("Veículo não existe")
            End If
        Else
            MsgBox("Cliente não existe")
        End If

    End Sub

    Public Property veiculo()
        Get
            Return mVeiculo
        End Get
        Set(ByVal value)
            mVeiculo = value
        End Set
    End Property

End Class
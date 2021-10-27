Public Class Form1
    Dim animal As New Animal
    Private Sub limpaTela()
        txtCodigo.Text = ""
        txtNome.Text = ""
        txtProprietario.Text = ""
        txtIdade.Text = ""
        txtEspecie.Text = ""
        txtRaca.Text = ""

    End Sub
    Private Sub telaToCliente()
        animal.codigo = txtCodigo.Text
        animal.nome = txtNome.Text
        animal.proprietario = txtProprietario.Text
        animal.idade = txtIdade.Text
        animal.especie = txtEspecie.Text
        animal.raca = txtRaca.Text

    End Sub
    Private Sub clienteToTela()
        txtCodigo.Text = animal.codigo
        txtNome.Text = animal.nome
        txtProprietario.Text = animal.proprietario
        txtIdade.Text = animal.idade
        txtEspecie.Text = animal.especie
        txtRaca.Text = animal.raca
    End Sub

    Private Sub Label7_Click(sender As Object, e As EventArgs)

    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub TextBox6_TextChanged(sender As Object, e As EventArgs) Handles txtRaca.TextChanged

    End Sub

    Private Sub TextBox4_TextChanged(sender As Object, e As EventArgs) Handles txtIdade.TextChanged

    End Sub

    Private Sub TextBox3_TextChanged(sender As Object, e As EventArgs) Handles txtProprietario.TextChanged

    End Sub

    Private Sub TextBox2_TextChanged(sender As Object, e As EventArgs) Handles txtNome.TextChanged

    End Sub

    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles txtCodigo.TextChanged

    End Sub

    Private Sub TextBox5_TextChanged(sender As Object, e As EventArgs) Handles txtEspecie.TextChanged

    End Sub

    Private Sub btnNovo_Click(sender As Object, e As EventArgs) Handles btnNovo.Click
        limpaTela()
    End Sub

    Private Sub btnSalva_Click(sender As Object, e As EventArgs) Handles btnSalva.Click
        telaToCliente()
    End Sub

    Private Sub btnLe_Click(sender As Object, e As EventArgs) Handles btnLe.Click
        clienteToTela()
    End Sub
End Class

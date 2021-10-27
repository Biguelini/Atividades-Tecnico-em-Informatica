Public Class Form1
    Dim cliente As New Cliente
    Dim novo As Boolean = True
    Dim bd As New BdCliente
    Private Sub limpaTela()
        txtCodigo.Text = ""
        txtNome.Text = ""
        txtEndereco.Text = ""
        txtCidade.Text = ""
        txtUf.Text = ""
        txtTelefone.Text = ""
        txtRenda.Text = ""

    End Sub
    Private Sub telaToCliente()
        cliente.codigo = txtCodigo.Text
        cliente.nome = txtNome.Text
        cliente.endereco = txtEndereco.Text
        cliente.cidade = txtCidade.Text
        cliente.uf = txtUf.Text
        cliente.telefone = txtTelefone.Text
        cliente.renda = txtRenda.Text

    End Sub
    Private Sub clienteToTela()
        txtCodigo.Text = cliente.codigo
        txtNome.Text = cliente.nome
        txtEndereco.Text = cliente.endereco
        txtCidade.Text = cliente.cidade
        txtUf.Text = cliente.uf
        txtTelefone.Text = cliente.telefone
        txtRenda.Text = cliente.renda
    End Sub

    Private Sub Label7_Click(sender As Object, e As EventArgs) Handles Label7.Click

    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub TextBox6_TextChanged(sender As Object, e As EventArgs) Handles txtTelefone.TextChanged

    End Sub

    Private Sub TextBox4_TextChanged(sender As Object, e As EventArgs) Handles txtCidade.TextChanged

    End Sub

    Private Sub TextBox3_TextChanged(sender As Object, e As EventArgs) Handles txtEndereco.TextChanged

    End Sub

    Private Sub TextBox2_TextChanged(sender As Object, e As EventArgs) Handles txtNome.TextChanged

    End Sub

    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles txtCodigo.TextChanged

    End Sub

    Private Sub TextBox5_TextChanged(sender As Object, e As EventArgs) Handles txtUf.TextChanged

    End Sub

    Private Sub btnNovo_Click(sender As Object, e As EventArgs) Handles btnNovo.Click
        novo = True
        limpaTela()
    End Sub

    Private Sub btnSalva_Click(sender As Object, e As EventArgs) Handles btnSalva.Click
        telaToCliente()
        If novo Then
            bd.inserir(cliente)
        Else
            bd.atualizar(cliente)
        End If
        novo = False
    End Sub

    Private Sub btnExclui_Click(sender As Object, e As EventArgs) Handles btnExclui.Click
        telaToCliente()
        bd.excluir(cliente.codigo)
        limpaTela()
    End Sub

    Private Sub btnLocaliza_Click(sender As Object, e As EventArgs) Handles btnLocaliza.Click
        Dim busca As String = InputBox("Digite o código
a localizar")
        cliente = bd.localizar(busca)
        If Not cliente.nome.Equals("") Then
            clienteToTela()
            novo = False
        Else
            MsgBox("Código não Existente", vbExclamation + vbOKOnly, "Atenção")
            limpaTela()
            novo = True
        End If
    End Sub
End Class

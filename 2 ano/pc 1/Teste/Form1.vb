Public Class Form1
    Dim novo As Boolean = True
    Dim usuario As New Usuario
    Dim bd As New BdUsuario
    Private Sub telaToUsuario()
        usuario.Nome = txtnome.Text
        usuario.Senha = txtsenha.Text
        usuario.User = txtuser.Text
    End Sub
    Private Sub usuarioToTela()
        txtnome.Text = usuario.Nome
        txtsenha.Text = usuario.Senha
        txtuser.Text = usuario.User
    End Sub
    Private Sub limpaTela()
        txtnome.Text = ""
        txtsenha.Text = ""
        txtuser.Text = ""
    End Sub

    Private Sub btnnovo_Click(sender As Object, e As EventArgs) Handles btnnovo.Click
        novo = True
        limpaTela()
    End Sub

    Private Sub btnsalva_Click(sender As Object, e As EventArgs) Handles btnsalva.Click
        telaToUsuario()
        If novo Then
            bd.inserir(usuario)
        Else
            bd.atualizar(usuario)
        End If
        novo = False
    End Sub

    Private Sub btnexclui_Click(sender As Object, e As EventArgs) Handles btnexclui.Click
        telaToUsuario()
        bd.excluir(usuario.User)
        limpaTela()
    End Sub

    Private Sub btnlocalizar_Click(sender As Object, e As EventArgs) Handles btnlocalizar.Click
        Dim busca As String = InputBox("Digite o usuário a localizar")
        usuario = bd.localizar(busca)
        If Not usuario.Nome.Equals("") Then
            usuarioToTela()
            novo = False
        Else
            MsgBox("Usuário não Existente", vbExclamation + vbOKOnly, "Atenção")
            limpaTela()
            novo = True
        End If
    End Sub
End Class

Imports MySql.Data.MySqlClient
Public Class BdUsuario
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "usuario"
    End Sub
    Public Sub inserir(ByVal usuario As Usuario)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter()
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into usuario (nome, senha, user) values(@nome,@senha,@user)"
            cmd.Parameters.AddWithValue("@nome", usuario.Nome)
            cmd.Parameters.AddWithValue("@senha", usuario.Senha)
            cmd.Parameters.AddWithValue("@user", usuario.User)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal usuario As Usuario)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter()
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update usuario set nome=@nome, senha=@senha where user=@user"
            cmd.Parameters.AddWithValue("@nome", usuario.Nome)
            cmd.Parameters.AddWithValue("@senha", usuario.Senha)
            cmd.Parameters.AddWithValue("@user", usuario.User)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub excluir(ByVal user As String)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter()
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "delete from usuario where user=@user"
            cmd.Parameters.AddWithValue("@user", user)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal user As String) As Usuario
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim u As New Usuario
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from usuario where user=@user"
            cmd.Parameters.AddWithValue("@user", user)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                u.Nome = dr.GetString("nome")
                u.Senha = dr.GetString("senha")
                u.User = dr.GetString("user")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return u
    End Function
End Class

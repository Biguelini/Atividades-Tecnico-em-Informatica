Imports MySql.Data.MySqlClient
Public Class BdCliente
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "veiculo"
    End Sub
    Public Sub Inserir(ByVal cliente As Cliente)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into cliente (id,nome,endereco,cidade,uf,cpf,rg) values (@id,@nome,@endereco,@cidade,@uf,@cpf,@rg)"
            cmd.Parameters.AddWithValue("@id", cliente.id)
            cmd.Parameters.AddWithValue("@nome", cliente.nome)
            cmd.Parameters.AddWithValue("@endereco", cliente.endereco)
            cmd.Parameters.AddWithValue("@cidade", cliente.cidade)
            cmd.Parameters.AddWithValue("@uf", cliente.uf)
            cmd.Parameters.AddWithValue("@cpf", cliente.cpf)
            cmd.Parameters.AddWithValue("@rg", cliente.rg)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
End Class

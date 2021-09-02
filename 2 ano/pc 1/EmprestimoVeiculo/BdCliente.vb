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
    Public Sub atualizar(ByVal cliente As Cliente)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update cliente set nome=@nome,endereco=@endereco,cidade=@cidade,uf=@uf,cpf=@cpf,rg=@rg where id=@id"
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
    Public Sub excluir(ByVal id As Integer)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "delete from cliente where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal id As Integer) As Cliente
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim cliente As New Cliente
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from cliente where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                cliente.id = dr.GetInt32("id")
                cliente.nome = dr.GetString("nome")
                cliente.endereco = dr.GetString("endereco")
                cliente.cidade = dr.GetString("cidade")
                cliente.uf = dr.GetString("uf")
                cliente.cpf = dr.GetString("cpf")
                cliente.rg = dr.GetString("rg")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return cliente
    End Function
    Public Function pesquisa(ByVal nome As String)
        Dim ds As New DataSet
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from cliente where nome like @nome"
            cmd.Parameters.AddWithValue("@nome", "%" & nome & "%")

            cmd.Connection = Conexao
            da.SelectCommand = cmd
            da.Fill(ds)
            da.Dispose()
            Return ds
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return ds
    End Function

End Class

Imports MySql.Data.MySqlClient
Public Class BdCliente
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "cliente"
    End Sub
    Public Sub inserir(ByVal cliente As Cliente)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter()
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into clientes (codigo,nome,endereco,cidade,uf,telefone,renda) values(@codigo,@nome,@endereco,@cidade,@uf,@telefone,@renda)"
            cmd.Parameters.AddWithValue("@codigo", cliente.codigo)
            cmd.Parameters.AddWithValue("@nome", cliente.nome)
            cmd.Parameters.AddWithValue("@endereco", cliente.endereco)
            cmd.Parameters.AddWithValue("@cidade", cliente.cidade)
            cmd.Parameters.AddWithValue("@uf", cliente.uf)
            cmd.Parameters.AddWithValue("@telefone", cliente.telefone)
            cmd.Parameters.AddWithValue("@renda", cliente.renda)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()

            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal cliente As Cliente)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter()
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update usuario set nome=@nome, endereco=@endereco, cidade=@cidade, uf=@uf, telefone=@telefone, renda=@renda, where codigo=@codigo"
            cmd.Parameters.AddWithValue("@codigo", cliente.codigo)
            cmd.Parameters.AddWithValue("@nome", cliente.nome)
            cmd.Parameters.AddWithValue("@endereco", cliente.endereco)
            cmd.Parameters.AddWithValue("@cidade", cliente.cidade)
            cmd.Parameters.AddWithValue("@uf", cliente.uf)
            cmd.Parameters.AddWithValue("@telefone", cliente.telefone)
            cmd.Parameters.AddWithValue("@renda", cliente.renda)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub excluir(ByVal codigo As Integer)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter()
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "delete from clientes where codigo=@codigo"
            cmd.Parameters.AddWithValue("@codigo", codigo)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal codigo As Integer) As Cliente
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim u As New Cliente
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from clientes where codigo=@codigo"
            cmd.Parameters.AddWithValue("@codigo", codigo)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                u.codigo = dr.GetString("codigo")
                u.nome = dr.GetString("nome")
                u.endereco = dr.GetString("endereco")
                u.cidade = dr.GetString("cidade")
                u.uf = dr.GetString("uf")
                u.telefone = dr.GetString("telefone")
                u.renda = dr.GetString("renda")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return u
    End Function
End Class

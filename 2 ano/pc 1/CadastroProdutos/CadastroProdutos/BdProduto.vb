Imports MySql.Data.MySqlClient
Public Class BdProduto
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "produto"
    End Sub
    Public Sub inserir(ByVal produto As Produto)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into produtos (id,codbar,descricao,quantidade,minimo) values (@id,@codbar,@descricao,@quantidade,@minimo)"
            cmd.Parameters.AddWithValue("@id", produto.id)
            cmd.Parameters.AddWithValue("@codbar", produto.codbar)
            cmd.Parameters.AddWithValue("@descricao", produto.descricao)
            cmd.Parameters.AddWithValue("@quantidade", produto.quantidade)
            cmd.Parameters.AddWithValue("@minimo", produto.minimo)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal produto As Produto)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update produtos set codbar=@codbar, descricao=@descricao, quantidade=@quantidade, minimo=@minimo where id=@id"
            cmd.Parameters.AddWithValue("@id", produto.id)
            cmd.Parameters.AddWithValue("@codbar", produto.codbar)
            cmd.Parameters.AddWithValue("@descricao", produto.descricao)
            cmd.Parameters.AddWithValue("@quantidade", produto.quantidade)
            cmd.Parameters.AddWithValue("@minimo", produto.minimo)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub mudarqtd(ByVal produto As Produto, ByVal id As Integer)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update produtos set quantidade=@quantidade where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Parameters.AddWithValue("@quantidade", produto.quantidade)
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
            cmd.CommandText = "delete from produtos where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal id As Integer) As Produto
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim produto As New Produto
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from produtos where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                produto.id = dr.GetInt32("id")
                produto.codbar = dr.GetInt32("codbar")
                produto.descricao = dr.GetString("descricao")
                produto.quantidade = dr.GetInt32("quantidade")
                produto.minimo = dr.GetInt32("minimo")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return produto
    End Function
    Public Function pesquisa(ByVal descricao As String) As DataSet
        Dim ds As New DataSet
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from produtos where descricao like @descricao"
            cmd.Parameters.AddWithValue("@descricao", "%" & descricao & "%")

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

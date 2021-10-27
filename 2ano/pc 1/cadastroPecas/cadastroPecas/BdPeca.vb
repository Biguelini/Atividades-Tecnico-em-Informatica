Imports MySql.Data.MySqlClient

Public Class BdPeca
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "peca"
    End Sub
    Public Sub inserir(ByVal peca As Peca)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into peca (id,descricao,marca,aplicacao,codigodebarras) values (@id,@descricao,@marca,@aplicacao,@codigodebarras)"
            cmd.Parameters.AddWithValue("@id", peca.id)
            cmd.Parameters.AddWithValue("@descricao", peca.descricao)
            cmd.Parameters.AddWithValue("@marca", peca.marca)
            cmd.Parameters.AddWithValue("@aplicacao", peca.aplicacao)
            cmd.Parameters.AddWithValue("@codigodebarras", peca.codigodebarras)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal peca As Peca)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update peca set descricao=@descricao, marca=@marca, aplicacao=@aplicacao, codigodebarras=@codigodebarras where id=@id"
            cmd.Parameters.AddWithValue("@id", peca.id)
            cmd.Parameters.AddWithValue("@descricao", peca.descricao)
            cmd.Parameters.AddWithValue("@marca", peca.marca)
            cmd.Parameters.AddWithValue("@aplicacao", peca.aplicacao)
            cmd.Parameters.AddWithValue("@codigodebarras", peca.codigodebarras)
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
            cmd.CommandText = "delete from peca where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal id As Integer) As Peca
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim peca As New Peca
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from peca where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                peca.id = dr.GetInt32("id")
                peca.descricao = dr.GetString("descricao")
                peca.marca = dr.GetString("marca")
                peca.aplicacao = dr.GetString("aplicacao")
                peca.codigodebarras = dr.GetString("codigodebarras")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return peca
    End Function
    Public Function pesquisa(ByVal codigodebarras As String) As DataSet
        Dim ds As New DataSet
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from peca where codigodebarras like @codigodebarras"
            cmd.Parameters.AddWithValue("@codigodebarras", "%" & codigodebarras & "%")

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

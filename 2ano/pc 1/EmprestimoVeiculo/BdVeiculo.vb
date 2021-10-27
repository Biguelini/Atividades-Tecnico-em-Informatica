Imports MySql.Data.MySqlClient
Public Class BdVeiculo
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "veiculo"
    End Sub
    Public Sub inserir(ByVal veiculo As Veiculo)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into veiculo (id,placa,marca,modelo,ano,chassi,idCliente) values (@id,@placa,@marca,@modelo,@ano,@chassi,@idCliente)"
            cmd.Parameters.AddWithValue("@id", veiculo.id)
            cmd.Parameters.AddWithValue("@placa", veiculo.placa)
            cmd.Parameters.AddWithValue("@marca", veiculo.marca)
            cmd.Parameters.AddWithValue("@modelo", veiculo.modelo)
            cmd.Parameters.AddWithValue("@ano", veiculo.ano)
            cmd.Parameters.AddWithValue("@chassi", veiculo.chassi)
            cmd.Parameters.AddWithValue("@idCliente", veiculo.idCliente)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal veiculo As Veiculo)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update veiculo set placa=@placa, marca=@marca, modelo=@modelo, ano=@ano, chassi=@chassi where id=@id"
            cmd.Parameters.AddWithValue("@id", veiculo.id)
            cmd.Parameters.AddWithValue("@placa", veiculo.placa)
            cmd.Parameters.AddWithValue("@marca", veiculo.marca)
            cmd.Parameters.AddWithValue("@modelo", veiculo.modelo)
            cmd.Parameters.AddWithValue("@ano", veiculo.ano)
            cmd.Parameters.AddWithValue("@chassi", veiculo.chassi)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub emprestar(ByVal idveiculo As Integer, ByVal idcliente As Integer)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update veiculo set idCliente=@idcliente where id=@id"
            cmd.Parameters.AddWithValue("@id", idveiculo)
            cmd.Parameters.AddWithValue("@idcliente", idcliente)
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
            cmd.CommandText = "delete from veiculo where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub devolver(ByVal id As Integer)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update veiculo set idCliente=0 where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal id As Integer) As Veiculo
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim veiculo As New Veiculo
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from veiculo where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                veiculo.id = dr.GetInt32("id")
                veiculo.placa = dr.GetString("placa")
                veiculo.marca = dr.GetString("marca")
                veiculo.modelo = dr.GetString("modelo")
                veiculo.ano = dr.GetString("ano")
                veiculo.chassi = dr.GetString("chassi")
                veiculo.idCliente = dr.GetInt32("idCliente")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return veiculo
    End Function
    Public Function pesquisa(ByVal placa As String) As DataSet
        Dim ds As New DataSet
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from veiculo where placa like @placa"
            cmd.Parameters.AddWithValue("@placa", "%" & placa & "%")

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
    Public Function verEmprestados() As DataSet
        Dim ds As New DataSet
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from veiculo where idCliente <> 0"

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

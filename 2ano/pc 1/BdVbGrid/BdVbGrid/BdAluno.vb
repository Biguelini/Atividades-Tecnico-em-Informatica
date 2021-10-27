Imports MySql.Data.MySqlClient
Public Class BdAluno
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "aluno"
    End Sub
    Public Sub inserir(ByVal aluno As Aluno)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into aluno (codigo,nome,serie,turma) values (@codigo,@nome,@serie,@turma)"
            cmd.Parameters.AddWithValue("@codigo", aluno.codigo)
            cmd.Parameters.AddWithValue("@nome", aluno.nome)
            cmd.Parameters.AddWithValue("@serie", aluno.serie)
            cmd.Parameters.AddWithValue("@turma", aluno.turma)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal aluno As Aluno)
        Dim da As mysqldataadapter = New mysqldataadapter
        Dim cmd As mysqlcommand = New mysqlcommand
        Try
            abrir()
            cmd.commandtype = CommandType.Text
            cmd.CommandText = "update aluno set nome=@nome, serie=@serie, turma=@turma where codigo=@codigo"
            cmd.Parameters.AddWithValue("@codigo", aluno.codigo)
            cmd.Parameters.AddWithValue("@nome", aluno.nome)
            cmd.Parameters.AddWithValue("@serie", aluno.serie)
            cmd.Parameters.AddWithValue("@turma", aluno.turma)
            cmd.Connection = conexao
            da.updatecommand = cmd
            da.updatecommand.executenonquery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub excluir(ByVal codigo As Integer)
        Dim da As mysqldataadapter = New mysqldataadapter
        Dim cmd As mysqlcommand = New mysqlcommand
        Try
            abrir()
            cmd.commandtype = CommandType.Text
            cmd.CommandText = "delete from aluno where codigo=@codigo"
            cmd.Parameters.AddWithValue("@codigo", codigo)
            cmd.Connection = conexao
            da.updatecommand = cmd
            da.updatecommand.executenonquery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal codigo As Integer) As Aluno
        Dim dr As mysqldatareader = Nothing
        Dim cmd As mysqlcommand = New mysqlcommand
        Dim aluno As New Aluno
        Try
            abrir()
            cmd.commandtype = CommandType.Text
            cmd.CommandText = "select * from aluno where codigo=@codigo"
            cmd.Parameters.AddWithValue("@codigo", codigo)
            cmd.Connection = conexao
            dr = cmd.executereader
            If dr.read Then
                aluno.codigo = dr.getint32("codigo")
                aluno.nome = dr.getstring("nome")
                aluno.turma = dr.getstring("turma")
                aluno.serie = dr.getint32("serie")
            End If
            cmd.dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return aluno
    End Function
    Public Function pesquisa(ByVal nome As String) As DataSet
        Dim ds As New DataSet
        Dim da As mysqldataadapter = New mysqldataadapter
        Dim cmd As mysqlcommand = New mysqlcommand
        Try
            abrir()
            cmd.commandtype = CommandType.Text
            cmd.CommandText = "select * from aluno where nome like @nome"
            cmd.Parameters.AddWithValue("@nome", "%" & nome & "%")

            cmd.connection = conexao
            da.selectcommand = cmd
            da.fill(ds)
            da.dispose()
            Return ds
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return ds
    End Function
End Class

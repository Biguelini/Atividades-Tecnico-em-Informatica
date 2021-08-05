Imports MySql.Data.MySqlClient
Public Class Bd
    Public Property User As String
    Public Property bd As String
    Public Property Senha As String
    Public Property Servidor As String
    Public Property Conexao As MySqlConnection
    Public Sub New()
        Conexao = New MySqlConnection
    End Sub
    Public Sub Abrir()
        Dim strConnString As String = "Data Source=" & Servidor & ";user id=" & _
        User & ";password=" & Senha & "; database=" & bd & ";sslmode=none; "
        If conexao Is Nothing Or conexao.State = ConnectionState.Broken Or conexao.State = ConnectionState.Closed Then
            conexao = New MySqlConnection()
            conexao.ConnectionString = strConnString
            conexao.Open()
        End If
    End Sub
    Public Sub fechar()
        conexao.Close()
    End Sub
End Class

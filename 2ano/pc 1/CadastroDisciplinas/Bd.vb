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
        Dim strConnString As String = "Data Source=" & Servidor & ";user id=" &
        User & ";password=" & Senha & "; database=" & bd & ";sslmode=none; "
        If Conexao Is Nothing Or Conexao.State = ConnectionState.Broken Or Conexao.State = ConnectionState.Closed Then
            Conexao = New MySqlConnection()
            Conexao.ConnectionString = strConnString
            Conexao.Open()
        End If
    End Sub
    Public Sub fechar()
        Conexao.Close()
    End Sub
End Class

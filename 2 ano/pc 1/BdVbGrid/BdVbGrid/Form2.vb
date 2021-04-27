Public Class Form2
    Dim mAluno As New Aluno
    Dim mnovo As Boolean
    Dim bd As New BdAluno
    Private Sub alunototela()
        txtcodigo.Text = mAluno.codigo
        txtnome.Text = mAluno.nome
        txtserie.Text = mAluno.serie
        txtturma.Text = mAluno.turma
    End Sub
    Private Sub telatoaluno()
        mAluno.codigo = txtcodigo.Text
        mAluno.serie = txtserie.Text
        mAluno.nome = txtnome.Text
        mAluno.turma = txtturma.Text
    End Sub

    Private Sub btncancelar_Click(sender As Object, e As EventArgs) Handles btncancelar.Click
        Me.Dispose()
    End Sub

    Private Sub btnsalvar_Click(sender As Object, e As EventArgs) Handles btnsalvar.Click
        telatoaluno()
        If novo Then
            bd.inserir(aluno)
        Else
            bd.atualizar(aluno)
        End If
        Me.Dispose()
    End Sub

    Public Property aluno()
        Get
            Return mAluno
        End Get
        Set(ByVal value)
            mAluno = value
            alunototela()
        End Set
    End Property
    Public Property novo()
        Get
            Return mnovo
        End Get
        Set(ByVal value)
            mnovo = value
        End Set
    End Property
End Class
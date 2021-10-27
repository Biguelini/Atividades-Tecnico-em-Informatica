Public Class Form2
    Dim mDisciplina As New Disciplina
    Dim mnovo As Boolean
    Dim bd As New BdDisciplina
    Private Sub disciplinatotela()
        txtCodigo.Text = mDisciplina.codigo
        txtNome.Text = mDisciplina.nome
        txtCh.Text = mDisciplina.ch
        txtProfessor.Text = mDisciplina.professor
    End Sub
    Private Sub telatodisciplina()
        mDisciplina.codigo = txtCodigo.Text
        mDisciplina.ch = txtCh.Text
        mDisciplina.nome = txtNome.Text
        mDisciplina.professor = txtProfessor.Text
    End Sub

    Private Sub btnCancelar_Click(sender As Object, e As EventArgs) Handles btnCancelar.Click
        Me.Dispose()
    End Sub

    Private Sub btnSalvar_Click(sender As Object, e As EventArgs) Handles btnSalvar.Click
        telatodisciplina()
        If novo Then
            bd.inserir(disciplina)
        Else
            bd.atualizar(disciplina)
        End If
        Me.Dispose()
    End Sub

    Public Property disciplina()
        Get
            Return mDisciplina
        End Get
        Set(ByVal value)
            mDisciplina = value
            disciplinatotela()
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
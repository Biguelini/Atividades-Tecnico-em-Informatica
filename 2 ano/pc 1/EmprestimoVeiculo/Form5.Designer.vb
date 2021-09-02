<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form5
    Inherits System.Windows.Forms.Form

    'Descartar substituições de formulário para limpar a lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Exigido pelo Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'OBSERVAÇÃO: o procedimento a seguir é exigido pelo Windows Form Designer
    'Pode ser modificado usando o Windows Form Designer.  
    'Não o modifique usando o editor de códigos.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.btncancela = New System.Windows.Forms.Button()
        Me.txtid = New System.Windows.Forms.TextBox()
        Me.txtplaca = New System.Windows.Forms.TextBox()
        Me.PlacaLabel = New System.Windows.Forms.Label()
        Me.txtmarca = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txtmodelo = New System.Windows.Forms.TextBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.txtano = New System.Windows.Forms.TextBox()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.txtchassi = New System.Windows.Forms.TextBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.txtidcliente = New System.Windows.Forms.TextBox()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.btnsalva = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(12, 15)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(16, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Id"
        '
        'btncancela
        '
        Me.btncancela.Location = New System.Drawing.Point(96, 242)
        Me.btncancela.Name = "btncancela"
        Me.btncancela.Size = New System.Drawing.Size(75, 23)
        Me.btncancela.TabIndex = 1
        Me.btncancela.Text = "Cancelar"
        Me.btncancela.UseVisualStyleBackColor = True
        '
        'txtid
        '
        Me.txtid.Location = New System.Drawing.Point(82, 11)
        Me.txtid.Name = "txtid"
        Me.txtid.ReadOnly = True
        Me.txtid.Size = New System.Drawing.Size(100, 20)
        Me.txtid.TabIndex = 2
        '
        'txtplaca
        '
        Me.txtplaca.Location = New System.Drawing.Point(82, 41)
        Me.txtplaca.Name = "txtplaca"
        Me.txtplaca.Size = New System.Drawing.Size(100, 20)
        Me.txtplaca.TabIndex = 4
        '
        'PlacaLabel
        '
        Me.PlacaLabel.AutoSize = True
        Me.PlacaLabel.Location = New System.Drawing.Point(12, 45)
        Me.PlacaLabel.Name = "PlacaLabel"
        Me.PlacaLabel.Size = New System.Drawing.Size(34, 13)
        Me.PlacaLabel.TabIndex = 3
        Me.PlacaLabel.Text = "Placa"
        '
        'txtmarca
        '
        Me.txtmarca.Location = New System.Drawing.Point(82, 71)
        Me.txtmarca.Name = "txtmarca"
        Me.txtmarca.Size = New System.Drawing.Size(100, 20)
        Me.txtmarca.TabIndex = 6
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(12, 75)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(37, 13)
        Me.Label3.TabIndex = 5
        Me.Label3.Text = "Marca"
        '
        'txtmodelo
        '
        Me.txtmodelo.Location = New System.Drawing.Point(82, 101)
        Me.txtmodelo.Name = "txtmodelo"
        Me.txtmodelo.Size = New System.Drawing.Size(100, 20)
        Me.txtmodelo.TabIndex = 8
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(12, 105)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(42, 13)
        Me.Label4.TabIndex = 7
        Me.Label4.Text = "Modelo"
        '
        'txtano
        '
        Me.txtano.Location = New System.Drawing.Point(82, 131)
        Me.txtano.Name = "txtano"
        Me.txtano.Size = New System.Drawing.Size(100, 20)
        Me.txtano.TabIndex = 10
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(12, 135)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(26, 13)
        Me.Label5.TabIndex = 9
        Me.Label5.Text = "Ano"
        '
        'txtchassi
        '
        Me.txtchassi.Location = New System.Drawing.Point(82, 161)
        Me.txtchassi.Name = "txtchassi"
        Me.txtchassi.Size = New System.Drawing.Size(100, 20)
        Me.txtchassi.TabIndex = 12
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(12, 165)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(38, 13)
        Me.Label6.TabIndex = 11
        Me.Label6.Text = "Chassi"
        '
        'txtidcliente
        '
        Me.txtidcliente.Location = New System.Drawing.Point(82, 191)
        Me.txtidcliente.Name = "txtidcliente"
        Me.txtidcliente.ReadOnly = True
        Me.txtidcliente.Size = New System.Drawing.Size(100, 20)
        Me.txtidcliente.TabIndex = 14
        Me.txtidcliente.Text = "0"
        Me.txtidcliente.Visible = False
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(12, 195)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(51, 13)
        Me.Label7.TabIndex = 13
        Me.Label7.Text = "Id Cliente"
        Me.Label7.Visible = False
        '
        'btnsalva
        '
        Me.btnsalva.Location = New System.Drawing.Point(15, 242)
        Me.btnsalva.Name = "btnsalva"
        Me.btnsalva.Size = New System.Drawing.Size(75, 23)
        Me.btnsalva.TabIndex = 15
        Me.btnsalva.Text = "Salvar"
        Me.btnsalva.UseVisualStyleBackColor = True
        '
        'Form5
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(197, 280)
        Me.Controls.Add(Me.btnsalva)
        Me.Controls.Add(Me.txtidcliente)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.txtchassi)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.txtano)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.txtmodelo)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txtmarca)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txtplaca)
        Me.Controls.Add(Me.PlacaLabel)
        Me.Controls.Add(Me.txtid)
        Me.Controls.Add(Me.btncancela)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form5"
        Me.Text = "Form5"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents btncancela As Button
    Friend WithEvents txtid As TextBox
    Friend WithEvents txtplaca As TextBox
    Friend WithEvents PlacaLabel As Label
    Friend WithEvents txtmarca As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents txtmodelo As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents txtano As TextBox
    Friend WithEvents Label5 As Label
    Friend WithEvents txtchassi As TextBox
    Friend WithEvents Label6 As Label
    Friend WithEvents txtidcliente As TextBox
    Friend WithEvents Label7 As Label
    Friend WithEvents btnsalva As Button
End Class

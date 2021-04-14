<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
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

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.txtCodigo = New System.Windows.Forms.TextBox()
        Me.txtNome = New System.Windows.Forms.TextBox()
        Me.txtEndereco = New System.Windows.Forms.TextBox()
        Me.txtCidade = New System.Windows.Forms.TextBox()
        Me.txtUf = New System.Windows.Forms.TextBox()
        Me.txtTelefone = New System.Windows.Forms.TextBox()
        Me.txtRenda = New System.Windows.Forms.TextBox()
        Me.btnNovo = New System.Windows.Forms.Button()
        Me.btnSalva = New System.Windows.Forms.Button()
        Me.btnExclui = New System.Windows.Forms.Button()
        Me.btnLocaliza = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(10, 11)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(40, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Código"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(10, 36)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(35, 13)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Nome"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(10, 62)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(53, 13)
        Me.Label3.TabIndex = 2
        Me.Label3.Text = "Endereço"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(10, 87)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(40, 13)
        Me.Label4.TabIndex = 3
        Me.Label4.Text = "Cidade"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(10, 112)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(21, 13)
        Me.Label5.TabIndex = 4
        Me.Label5.Text = "UF"
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(10, 137)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(49, 13)
        Me.Label6.TabIndex = 5
        Me.Label6.Text = "Telefone"
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(10, 163)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(39, 13)
        Me.Label7.TabIndex = 6
        Me.Label7.Text = "Renda"
        '
        'txtCodigo
        '
        Me.txtCodigo.Location = New System.Drawing.Point(69, 9)
        Me.txtCodigo.Name = "txtCodigo"
        Me.txtCodigo.Size = New System.Drawing.Size(218, 20)
        Me.txtCodigo.TabIndex = 7
        '
        'txtNome
        '
        Me.txtNome.Location = New System.Drawing.Point(69, 33)
        Me.txtNome.Name = "txtNome"
        Me.txtNome.Size = New System.Drawing.Size(218, 20)
        Me.txtNome.TabIndex = 8
        '
        'txtEndereco
        '
        Me.txtEndereco.Location = New System.Drawing.Point(69, 59)
        Me.txtEndereco.Name = "txtEndereco"
        Me.txtEndereco.Size = New System.Drawing.Size(218, 20)
        Me.txtEndereco.TabIndex = 9
        '
        'txtCidade
        '
        Me.txtCidade.Location = New System.Drawing.Point(69, 84)
        Me.txtCidade.Name = "txtCidade"
        Me.txtCidade.Size = New System.Drawing.Size(218, 20)
        Me.txtCidade.TabIndex = 10
        '
        'txtUf
        '
        Me.txtUf.Location = New System.Drawing.Point(69, 109)
        Me.txtUf.Name = "txtUf"
        Me.txtUf.Size = New System.Drawing.Size(218, 20)
        Me.txtUf.TabIndex = 11
        '
        'txtTelefone
        '
        Me.txtTelefone.Location = New System.Drawing.Point(69, 134)
        Me.txtTelefone.Name = "txtTelefone"
        Me.txtTelefone.Size = New System.Drawing.Size(218, 20)
        Me.txtTelefone.TabIndex = 12
        '
        'txtRenda
        '
        Me.txtRenda.Location = New System.Drawing.Point(69, 160)
        Me.txtRenda.Name = "txtRenda"
        Me.txtRenda.Size = New System.Drawing.Size(218, 20)
        Me.txtRenda.TabIndex = 13
        '
        'btnNovo
        '
        Me.btnNovo.Location = New System.Drawing.Point(12, 191)
        Me.btnNovo.Name = "btnNovo"
        Me.btnNovo.Size = New System.Drawing.Size(64, 40)
        Me.btnNovo.TabIndex = 14
        Me.btnNovo.Text = "Novo"
        Me.btnNovo.UseVisualStyleBackColor = True
        '
        'btnSalva
        '
        Me.btnSalva.Location = New System.Drawing.Point(82, 191)
        Me.btnSalva.Name = "btnSalva"
        Me.btnSalva.Size = New System.Drawing.Size(64, 40)
        Me.btnSalva.TabIndex = 15
        Me.btnSalva.Text = "Salva"
        Me.btnSalva.UseVisualStyleBackColor = True
        '
        'btnExclui
        '
        Me.btnExclui.Location = New System.Drawing.Point(153, 191)
        Me.btnExclui.Name = "btnExclui"
        Me.btnExclui.Size = New System.Drawing.Size(64, 40)
        Me.btnExclui.TabIndex = 16
        Me.btnExclui.Text = "Exclui"
        Me.btnExclui.UseVisualStyleBackColor = True
        '
        'btnLocaliza
        '
        Me.btnLocaliza.Location = New System.Drawing.Point(223, 191)
        Me.btnLocaliza.Name = "btnLocaliza"
        Me.btnLocaliza.Size = New System.Drawing.Size(64, 40)
        Me.btnLocaliza.TabIndex = 17
        Me.btnLocaliza.Text = "Localiza"
        Me.btnLocaliza.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(298, 243)
        Me.Controls.Add(Me.btnLocaliza)
        Me.Controls.Add(Me.btnExclui)
        Me.Controls.Add(Me.btnSalva)
        Me.Controls.Add(Me.btnNovo)
        Me.Controls.Add(Me.txtRenda)
        Me.Controls.Add(Me.txtTelefone)
        Me.Controls.Add(Me.txtUf)
        Me.Controls.Add(Me.txtCidade)
        Me.Controls.Add(Me.txtEndereco)
        Me.Controls.Add(Me.txtNome)
        Me.Controls.Add(Me.txtCodigo)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents Label5 As Label
    Friend WithEvents Label6 As Label
    Friend WithEvents Label7 As Label
    Friend WithEvents txtCodigo As TextBox
    Friend WithEvents txtNome As TextBox
    Friend WithEvents txtEndereco As TextBox
    Friend WithEvents txtCidade As TextBox
    Friend WithEvents txtUf As TextBox
    Friend WithEvents txtTelefone As TextBox
    Friend WithEvents txtRenda As TextBox
    Friend WithEvents btnNovo As Button
    Friend WithEvents btnSalva As Button
    Friend WithEvents btnExclui As Button
    Friend WithEvents btnLocaliza As Button
End Class

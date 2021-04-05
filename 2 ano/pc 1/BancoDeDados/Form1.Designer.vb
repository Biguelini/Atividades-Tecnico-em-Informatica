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
        Me.txtuser = New System.Windows.Forms.TextBox()
        Me.txtnome = New System.Windows.Forms.TextBox()
        Me.txtsenha = New System.Windows.Forms.TextBox()
        Me.btnlocalizar = New System.Windows.Forms.Button()
        Me.btnnovo = New System.Windows.Forms.Button()
        Me.btnsalvar = New System.Windows.Forms.Button()
        Me.btnexcluir = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Segoe UI", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point)
        Me.Label1.Location = New System.Drawing.Point(35, 48)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(42, 21)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "User"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Segoe UI", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point)
        Me.Label2.Location = New System.Drawing.Point(35, 87)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(53, 21)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Nome"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Segoe UI", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point)
        Me.Label3.Location = New System.Drawing.Point(35, 132)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(53, 21)
        Me.Label3.TabIndex = 2
        Me.Label3.Text = "Senha"
        '
        'txtuser
        '
        Me.txtuser.Location = New System.Drawing.Point(114, 46)
        Me.txtuser.Name = "txtuser"
        Me.txtuser.Size = New System.Drawing.Size(145, 23)
        Me.txtuser.TabIndex = 3
        '
        'txtnome
        '
        Me.txtnome.Location = New System.Drawing.Point(114, 85)
        Me.txtnome.Name = "txtnome"
        Me.txtnome.Size = New System.Drawing.Size(145, 23)
        Me.txtnome.TabIndex = 4
        '
        'txtsenha
        '
        Me.txtsenha.Location = New System.Drawing.Point(114, 130)
        Me.txtsenha.Name = "txtsenha"
        Me.txtsenha.Size = New System.Drawing.Size(145, 23)
        Me.txtsenha.TabIndex = 5
        '
        'btnlocalizar
        '
        Me.btnlocalizar.Location = New System.Drawing.Point(275, 46)
        Me.btnlocalizar.Name = "btnlocalizar"
        Me.btnlocalizar.Size = New System.Drawing.Size(75, 23)
        Me.btnlocalizar.TabIndex = 6
        Me.btnlocalizar.Text = "Localizar"
        Me.btnlocalizar.UseVisualStyleBackColor = True
        '
        'btnnovo
        '
        Me.btnnovo.Location = New System.Drawing.Point(35, 190)
        Me.btnnovo.Name = "btnnovo"
        Me.btnnovo.Size = New System.Drawing.Size(75, 23)
        Me.btnnovo.TabIndex = 7
        Me.btnnovo.Text = "Novo"
        Me.btnnovo.UseVisualStyleBackColor = True
        '
        'btnsalvar
        '
        Me.btnsalvar.Location = New System.Drawing.Point(127, 190)
        Me.btnsalvar.Name = "btnsalvar"
        Me.btnsalvar.Size = New System.Drawing.Size(75, 23)
        Me.btnsalvar.TabIndex = 8
        Me.btnsalvar.Text = "Salvar"
        Me.btnsalvar.UseVisualStyleBackColor = True
        '
        'btnexcluir
        '
        Me.btnexcluir.Location = New System.Drawing.Point(218, 190)
        Me.btnexcluir.Name = "btnexcluir"
        Me.btnexcluir.Size = New System.Drawing.Size(75, 23)
        Me.btnexcluir.TabIndex = 9
        Me.btnexcluir.Text = "Excluir"
        Me.btnexcluir.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(524, 275)
        Me.Controls.Add(Me.btnexcluir)
        Me.Controls.Add(Me.btnsalvar)
        Me.Controls.Add(Me.btnnovo)
        Me.Controls.Add(Me.btnlocalizar)
        Me.Controls.Add(Me.txtsenha)
        Me.Controls.Add(Me.txtnome)
        Me.Controls.Add(Me.txtuser)
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
    Friend WithEvents txtuser As TextBox
    Friend WithEvents txtnome As TextBox
    Friend WithEvents txtsenha As TextBox
    Friend WithEvents btnlocalizar As Button
    Friend WithEvents btnnovo As Button
    Friend WithEvents btnsalvar As Button
    Friend WithEvents btnexcluir As Button
End Class

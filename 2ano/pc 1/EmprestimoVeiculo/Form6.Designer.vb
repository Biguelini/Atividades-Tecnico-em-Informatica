<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form6
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
        Me.MenuStrip1 = New System.Windows.Forms.MenuStrip()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.Button2 = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtfiltro = New System.Windows.Forms.TextBox()
        Me.btnfiltro = New System.Windows.Forms.Button()
        Me.dgfiltro = New System.Windows.Forms.DataGridView()
        CType(Me.dgfiltro, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'MenuStrip1
        '
        Me.MenuStrip1.Location = New System.Drawing.Point(0, 0)
        Me.MenuStrip1.Name = "MenuStrip1"
        Me.MenuStrip1.Size = New System.Drawing.Size(800, 24)
        Me.MenuStrip1.TabIndex = 0
        Me.MenuStrip1.Text = "MenuStrip1"
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(241, 354)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(140, 49)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Emprestar"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(387, 354)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(140, 49)
        Me.Button2.TabIndex = 2
        Me.Button2.Text = "Devolver"
        Me.Button2.UseVisualStyleBackColor = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(16, 17)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(29, 13)
        Me.Label1.TabIndex = 3
        Me.Label1.Text = "Filtro"
        '
        'txtfiltro
        '
        Me.txtfiltro.Location = New System.Drawing.Point(52, 13)
        Me.txtfiltro.Name = "txtfiltro"
        Me.txtfiltro.Size = New System.Drawing.Size(100, 20)
        Me.txtfiltro.TabIndex = 4
        '
        'btnfiltro
        '
        Me.btnfiltro.Location = New System.Drawing.Point(159, 12)
        Me.btnfiltro.Name = "btnfiltro"
        Me.btnfiltro.Size = New System.Drawing.Size(75, 23)
        Me.btnfiltro.TabIndex = 5
        Me.btnfiltro.Text = "Ok"
        Me.btnfiltro.UseVisualStyleBackColor = True
        '
        'dgfiltro
        '
        Me.dgfiltro.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.dgfiltro.Location = New System.Drawing.Point(19, 41)
        Me.dgfiltro.Name = "dgfiltro"
        Me.dgfiltro.Size = New System.Drawing.Size(769, 307)
        Me.dgfiltro.TabIndex = 6
        '
        'Form6
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(800, 450)
        Me.Controls.Add(Me.dgfiltro)
        Me.Controls.Add(Me.btnfiltro)
        Me.Controls.Add(Me.txtfiltro)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.MenuStrip1)
        Me.MainMenuStrip = Me.MenuStrip1
        Me.Name = "Form6"
        Me.Text = "Form6"
        CType(Me.dgfiltro, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents MenuStrip1 As MenuStrip
    Friend WithEvents Button1 As Button
    Friend WithEvents Button2 As Button
    Friend WithEvents Label1 As Label
    Friend WithEvents txtfiltro As TextBox
    Friend WithEvents btnfiltro As Button
    Friend WithEvents dgfiltro As DataGridView
End Class

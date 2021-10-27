<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form2
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
        Me.txtid = New System.Windows.Forms.TextBox()
        Me.txtdescricao = New System.Windows.Forms.TextBox()
        Me.txtfabricante = New System.Windows.Forms.TextBox()
        Me.txtnumserie = New System.Windows.Forms.TextBox()
        Me.btnsalvar = New System.Windows.Forms.Button()
        Me.btncancelar = New System.Windows.Forms.Button()
        Me.txtnumpatrimonio = New System.Windows.Forms.TextBox()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.txtlocalizacao = New System.Windows.Forms.TextBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(13, 13)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(16, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Id"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(13, 48)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(55, 13)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Descricao"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(13, 86)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(57, 13)
        Me.Label3.TabIndex = 2
        Me.Label3.Text = "Fabricante"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(13, 121)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(84, 13)
        Me.Label4.TabIndex = 3
        Me.Label4.Text = "Número de série"
        '
        'txtid
        '
        Me.txtid.Location = New System.Drawing.Point(152, 10)
        Me.txtid.Name = "txtid"
        Me.txtid.Size = New System.Drawing.Size(100, 20)
        Me.txtid.TabIndex = 4
        '
        'txtdescricao
        '
        Me.txtdescricao.Location = New System.Drawing.Point(152, 45)
        Me.txtdescricao.Name = "txtdescricao"
        Me.txtdescricao.Size = New System.Drawing.Size(100, 20)
        Me.txtdescricao.TabIndex = 5
        '
        'txtfabricante
        '
        Me.txtfabricante.Location = New System.Drawing.Point(152, 83)
        Me.txtfabricante.Name = "txtfabricante"
        Me.txtfabricante.Size = New System.Drawing.Size(100, 20)
        Me.txtfabricante.TabIndex = 6
        '
        'txtnumserie
        '
        Me.txtnumserie.Location = New System.Drawing.Point(152, 118)
        Me.txtnumserie.Name = "txtnumserie"
        Me.txtnumserie.Size = New System.Drawing.Size(100, 20)
        Me.txtnumserie.TabIndex = 7
        '
        'btnsalvar
        '
        Me.btnsalvar.Location = New System.Drawing.Point(60, 226)
        Me.btnsalvar.Name = "btnsalvar"
        Me.btnsalvar.Size = New System.Drawing.Size(75, 23)
        Me.btnsalvar.TabIndex = 8
        Me.btnsalvar.Text = "Salvar"
        Me.btnsalvar.UseVisualStyleBackColor = True
        '
        'btncancelar
        '
        Me.btncancelar.Location = New System.Drawing.Point(142, 226)
        Me.btncancelar.Name = "btncancelar"
        Me.btncancelar.Size = New System.Drawing.Size(75, 23)
        Me.btncancelar.TabIndex = 9
        Me.btncancelar.Text = "Cancelar"
        Me.btncancelar.UseVisualStyleBackColor = True
        '
        'txtnumpatrimonio
        '
        Me.txtnumpatrimonio.Location = New System.Drawing.Point(152, 155)
        Me.txtnumpatrimonio.Name = "txtnumpatrimonio"
        Me.txtnumpatrimonio.Size = New System.Drawing.Size(100, 20)
        Me.txtnumpatrimonio.TabIndex = 11
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(13, 158)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(110, 13)
        Me.Label5.TabIndex = 10
        Me.Label5.Text = "Número de patrimônio"
        '
        'txtlocalizacao
        '
        Me.txtlocalizacao.Location = New System.Drawing.Point(152, 192)
        Me.txtlocalizacao.Name = "txtlocalizacao"
        Me.txtlocalizacao.Size = New System.Drawing.Size(100, 20)
        Me.txtlocalizacao.TabIndex = 13
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(13, 195)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(64, 13)
        Me.Label6.TabIndex = 12
        Me.Label6.Text = "Localização"
        '
        'Form2
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(284, 261)
        Me.Controls.Add(Me.txtlocalizacao)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.txtnumpatrimonio)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.btncancelar)
        Me.Controls.Add(Me.btnsalvar)
        Me.Controls.Add(Me.txtnumserie)
        Me.Controls.Add(Me.txtfabricante)
        Me.Controls.Add(Me.txtdescricao)
        Me.Controls.Add(Me.txtid)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form2"
        Me.Text = "Form2"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents txtid As System.Windows.Forms.TextBox
    Friend WithEvents txtdescricao As System.Windows.Forms.TextBox
    Friend WithEvents txtfabricante As System.Windows.Forms.TextBox
    Friend WithEvents txtnumserie As System.Windows.Forms.TextBox
    Friend WithEvents btnsalvar As System.Windows.Forms.Button
    Friend WithEvents btncancelar As System.Windows.Forms.Button
    Friend WithEvents txtnumpatrimonio As System.Windows.Forms.TextBox
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents txtlocalizacao As System.Windows.Forms.TextBox
    Friend WithEvents Label6 As System.Windows.Forms.Label
End Class

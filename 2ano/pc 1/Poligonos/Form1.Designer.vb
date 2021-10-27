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
        Me.txtAltura = New System.Windows.Forms.TextBox()
        Me.txtBase = New System.Windows.Forms.TextBox()
        Me.btnAreaRetangulo = New System.Windows.Forms.Button()
        Me.btnPerimetroRetangulo = New System.Windows.Forms.Button()
        Me.btnAreaTriangulo = New System.Windows.Forms.Button()
        Me.lblResultado = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(327, 94)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(42, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Altura:"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(327, 128)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(37, 15)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Base: "
        '
        'txtAltura
        '
        Me.txtAltura.Location = New System.Drawing.Point(376, 90)
        Me.txtAltura.Name = "txtAltura"
        Me.txtAltura.Size = New System.Drawing.Size(100, 23)
        Me.txtAltura.TabIndex = 2
        '
        'txtBase
        '
        Me.txtBase.Location = New System.Drawing.Point(376, 124)
        Me.txtBase.Name = "txtBase"
        Me.txtBase.Size = New System.Drawing.Size(100, 23)
        Me.txtBase.TabIndex = 3
        '
        'btnAreaRetangulo
        '
        Me.btnAreaRetangulo.Location = New System.Drawing.Point(171, 178)
        Me.btnAreaRetangulo.Name = "btnAreaRetangulo"
        Me.btnAreaRetangulo.Size = New System.Drawing.Size(149, 65)
        Me.btnAreaRetangulo.TabIndex = 4
        Me.btnAreaRetangulo.Text = "Area Retangulo"
        Me.btnAreaRetangulo.UseVisualStyleBackColor = True
        '
        'btnPerimetroRetangulo
        '
        Me.btnPerimetroRetangulo.Location = New System.Drawing.Point(327, 178)
        Me.btnPerimetroRetangulo.Name = "btnPerimetroRetangulo"
        Me.btnPerimetroRetangulo.Size = New System.Drawing.Size(149, 65)
        Me.btnPerimetroRetangulo.TabIndex = 5
        Me.btnPerimetroRetangulo.Text = "Perimetro Retangulo"
        Me.btnPerimetroRetangulo.UseVisualStyleBackColor = True
        '
        'btnAreaTriangulo
        '
        Me.btnAreaTriangulo.Location = New System.Drawing.Point(483, 178)
        Me.btnAreaTriangulo.Name = "btnAreaTriangulo"
        Me.btnAreaTriangulo.Size = New System.Drawing.Size(149, 65)
        Me.btnAreaTriangulo.TabIndex = 6
        Me.btnAreaTriangulo.Text = "Area Triangulo"
        Me.btnAreaTriangulo.UseVisualStyleBackColor = True
        '
        'lblResultado
        '
        Me.lblResultado.AutoSize = True
        Me.lblResultado.Font = New System.Drawing.Font("Segoe UI", 15.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point)
        Me.lblResultado.Location = New System.Drawing.Point(376, 267)
        Me.lblResultado.Name = "lblResultado"
        Me.lblResultado.Size = New System.Drawing.Size(0, 30)
        Me.lblResultado.TabIndex = 7
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(800, 450)
        Me.Controls.Add(Me.lblResultado)
        Me.Controls.Add(Me.btnAreaTriangulo)
        Me.Controls.Add(Me.btnPerimetroRetangulo)
        Me.Controls.Add(Me.btnAreaRetangulo)
        Me.Controls.Add(Me.txtBase)
        Me.Controls.Add(Me.txtAltura)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents txtAltura As TextBox
    Friend WithEvents txtBase As TextBox
    Friend WithEvents btnAreaRetangulo As Button
    Friend WithEvents btnPerimetroRetangulo As Button
    Friend WithEvents btnAreaTriangulo As Button
    Friend WithEvents lblResultado As Label
End Class

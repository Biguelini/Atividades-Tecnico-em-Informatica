<?php
function mysql_result($res, $row, $field="") {
 $res->data_seek($row);
 $datarow = $res->fetch_array();
 return $datarow[$field];
}
$db = mysqli_connect("localhost", "root", "vertrigo");
mysqli_select_db($db,"pessoa");
$codigo="";$nome="";$cpf="";$oper="";$sel="";
if(isset($_POST["codigo"]))
$codigo = mysqli_real_escape_string($db,$_POST["codigo"]);
if(isset($_POST["nome"]))
$nome = mysqli_real_escape_string($db,$_POST["nome"]);
if(isset($_POST["cpf"]))
$cpf = mysqli_real_escape_string($db,$_POST["cpf"]);
if(isset($_POST["oper"]))
$oper = $_POST["oper"];
if(isset($_POST["sel"]))
$sel = $_POST["sel"];
switch ($oper) {
 case "Insere":
 echo "insert into pessoa (nome,cpf)
values('$nome','$cpf')";
 mysqli_query($db,"insert into pessoa (nome,cpf)
values('$nome','$cpf')");
 echo "Elemento inserido";
 break;
 case "Excluir":
 mysqli_query($db,"delete from pessoa where codigo=
$sel");
 echo "Elemento exclu&iacutedo";
 break;
 case "Altera":
 mysqli_query($db,"update pessoa set
nome='$nome',cpf='$cpf' where codigo=$codigo");
 echo "Elemento alterado";
 break;
 case "Alterar":
 if ($sel) {
 $lista = mysqli_query($db,"Select * from pessoa
where codigo=$sel");
 $codigo = mysql_result($lista, 0, "codigo");
 $nome = mysql_result($lista, 0, "nome");
 $cpf = mysql_result($lista, 0, "cpf");
 } else {
 $oper = "";
 }
 default:
 break;
}
$tabela = "<table border=1><tr><td></td><td>C&oacutedigo</td>
<td>Nome</td><td>CPF</td></tr>";
$lista = mysqli_query($db,"Select * from pessoa order by
codigo");
$linhas=$lista?mysqli_num_rows($lista):0;
for ($i = 0; $i <$linhas; $i++) {
 $tabela.="<tr><td><input type='radio' name='sel'
value='" . mysql_result($lista, $i, "codigo") . "'></td>";
 $tabela.="<td>" . mysql_result($lista, $i, "codigo") .
"</td>";
 $tabela.="<td>" . mysql_result($lista, $i, "nome") .
"</td>";
 $tabela.="<td>" . mysql_result($lista, $i, "cpf") . "</td>
</tr>";
}
$tabela.="</table>";
mysqli_close($db);
?>
<html>
 <body>
 <form action="codigo_professor.php" method="post">
 <input type="submit" name="oper" value="Novo">
 <input type="submit" name="oper" value="Alterar">
 <input type="submit" name="oper" value="Excluir">
 <?php
 echo $tabela;
 if ($oper == "Novo" || $oper == "Alterar") {
 if ($oper == "Novo") {
 $codigo = "";
 $nome = "";
 $cpf = "";
 }
 echo "C&oacutedigo<input type='text'
name='codigo' value='$codigo' readonly><br>";
 echo "Nome<input type='text' name='nome'
value='$nome'><br>";
 echo "CPF<input type='text' name='cpf'
value='$cpf'><br>";
 echo "<input type='submit' name='oper'
value='Cancelar'>";
 if ($oper == "Novo") {
 echo "<input type='submit' name='oper'
value='Insere'>";
 } else {
 echo "<input type='submit' name='oper'
value='Altera'>";
 }
 }
 ?>
 </form>
 </body>
</html>
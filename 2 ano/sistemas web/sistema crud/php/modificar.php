<?php
    include_once('conexao.php'); // inclui conexão
    $oper = $_POST['oper'];
    $matricula = $_POST['matricula'];
    if($oper == "Deletar"){
        mysqli_query($connect,"delete from aluno where matricula=$matricula");
        echo"Deletado";
    }
?>
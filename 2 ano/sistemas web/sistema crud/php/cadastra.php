<?php
    include_once('conexao.php');
    if(isset($_POST['nome'])){
        $nome = mysqli_real_escape_string($connect,$_POST['nome']);
    }
    if(isset($_POST['media'])){
        $media = mysqli_real_escape_string($connect,$_POST['media']);
    }
    if($nome && $media){
        mysqli_query($connect,"INSERT INTO `aluno` (nome,media) VALUES('$nome','$media')");
    }
    header('Location: ../index.html');
?>
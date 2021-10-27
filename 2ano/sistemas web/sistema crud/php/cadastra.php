<?php
    include_once('conexao.php');
    $oper = $_POST['oper'];
    switch($oper){
        case "Cadastrar":
            if(isset($_POST['nome'])){
                $nome = mysqli_real_escape_string($connect,$_POST['nome']);
            }
            if(isset($_POST['media'])){
                $media = mysqli_real_escape_string($connect,$_POST['media']);
            }
            if($nome && $media && $media<=10 && $media>=0){
                mysqli_query($connect,"INSERT INTO `aluno` (nome,media) VALUES('$nome','$media')");
            }
            header('Location: ../index.html');
            break;
        case "Listar":
            header('Location: ./listagem.php');
            break;
        default:
            break;
    }
?>
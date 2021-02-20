<?php
    include_once('conexao.php');
    $oper = $_POST['oper'];
    $matricula = $_POST['matricula'];
    switch($oper){
        case "Confirmar":
            if(isset($_POST['nome'])){
                $nome = mysqli_real_escape_string($connect,$_POST['nome']);
            }
            if(isset($_POST['media'])){
                $media = mysqli_real_escape_string($connect,$_POST['media']);
            }
            if($nome && $media && $media<=10 && $media>=0){
                mysqli_query($connect,"UPDATE aluno SET nome='$nome',media='$media' WHERE matricula=$matricula");
            }
            break;
        case "Cancelar":
            break;
        default:
            break;
    }
    header('Location: ./listagem.php');



?>
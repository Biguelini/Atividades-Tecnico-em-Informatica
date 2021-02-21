<?php
    include_once('conexao.php');
    $oper = $_POST['oper'];
    $matricula = $_POST['matricula'];
    $nome = mysqli_fetch_array(mysqli_query($connect, "SELECT nome FROM `aluno` WHERE matricula = $matricula"))[0];
    $media = mysqli_fetch_array(mysqli_query($connect, "SELECT media FROM `aluno` WHERE matricula = $matricula"))[0];
    switch($oper){
        case "Deletar":
            mysqli_query($connect,"delete from aluno where matricula=$matricula");
            header('Location: ./listagem.php');
            break;
        case "Atualizar":
?>
            <!DOCTYPE html>
            <html lang="pt-br">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
                    <title>Atualizar</title>
                </head>
                <body>
                    <div class="container col-lg-4 col-md-6 col-sm-8 my-5">
                        <h1 class="text-center">Atualizar cadastro</h1>
                        <form action="atualizar.php" method="POST">
                            <div class="mb-3">
                                <label for="matricula" class="form-label">Matrícula do aluno</label>
                                <input type="text" name="matricula" class="form-control" id="nomatriculame" value="<?=$matricula;?>" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="nome" class="form-label">Nome do aluno</label>
                                <input type="text" name="nome" class="form-control" id="nome" value="<?=$nome;?>">
                            </div>
                            <div class="mb-3">
                                <label for="media">Nota média do aluno</label>
                                <input type="number" name="media" class="form-control" id="media" value="<?=$media;?>" step="0.1">
                            </div>
                            <div class="d-flex justify-content-center">
                                <input type="submit" name="oper" value="Confirmar" class="btn btn-success me-3">
                                <input type="submit" name="oper" value="Cancelar" class="btn btn-danger">
                            </div>
                        </form>
                    </div>
                </body>
            </html>
<?php 
            break;
        case "Voltar":
            header("Location: ../index.html");
            break;
        default:
            break;
    }
?>